package org.wit.hillfort.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

  lateinit var app: MainApp

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_hillfort)
    info("Hillfort Activity started..")

    app = application as MainApp

    btnAdd.setOnClickListener() {
      hillfort.title = hillfortTitle.text.toString()
      hillfort.description = description.text.toString()
      hillfort.location = location.text.toString()
      visited.setOnClickListener() {
        hillfort.visited = true
      }

      if (hillfort.title.isNotEmpty()) {
        app.hillforts.add(hillfort.copy())
        info("add Button Pressed: ${hillfort}")
        for (i in app.hillforts.indices) {
          info("hillfort[$i]:${app.hillforts[i]}")
        }
        setResult(AppCompatActivity.RESULT_OK)
        finish()
      } else {
        toast("Please Enter a title")
      }
    }
  }
}

