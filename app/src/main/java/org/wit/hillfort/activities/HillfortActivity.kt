package org.wit.hillfort.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_hillfort.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.hillfort.main.MainApp
import org.wit.hillfort.models.HillfortModel
import org.wit.hillfort.models.UserModel
import org.wit.hillfort.R


class HillfortActivity : AppCompatActivity(), AnkoLogger {

  var hillfort = HillfortModel()
  var user = UserModel()
    var edit = false

  lateinit var app: MainApp

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_hillfort)
    info("Hillfort Activity started..")

    app = application as MainApp

      if (intent.hasExtra("hillfort_edit")) {
          edit = true
          hillfort = intent.extras?.getParcelable<HillfortModel>("hillfort_edit")!!
          hillfortTitle.setText(hillfort.title)
          description.setText(hillfort.description)
          btnAdd.setText(R.string.save_hillfort)
      }

    toolbarAdd.title = title
    setSupportActionBar(toolbarAdd)
    info("Hillfort Activity started..")



    btnAdd.setOnClickListener() {
      hillfort.title = hillfortTitle.text.toString()
      hillfort.description = description.text.toString()
      hillfort.location = location.text.toString()
      visited.setOnClickListener() {
        hillfort.visited = true
      }

        if (hillfort.title.isEmpty()) {
            toast(R.string.enter_hillfort_title)
        } else {
            if (edit) {
                app.hillforts.update(hillfort.copy())
            } else {
                app.hillforts.create(hillfort.copy())
            }
        }
        info("add Button Pressed: $hillfortTitle")
        setResult(AppCompatActivity.RESULT_OK)
        finish()
    }
      chooseImage.setOnClickListener {
          info ("Select image")
      }

  }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      menuInflater.inflate(R.menu.menu_hillfort, menu)
      return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      when (item.itemId) {
        R.id.item_cancel -> {
          finish()
        }
      }
      return super.onOptionsItemSelected(item)
    }
  }


