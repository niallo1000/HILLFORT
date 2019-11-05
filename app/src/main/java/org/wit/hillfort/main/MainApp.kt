package org.wit.hillfort.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.hillfort.models.UserModel
import org.wit.hillfort.models.HillfortStore
import org.wit.hillfort.models.HillfortJSONStore

class MainApp : Application(), AnkoLogger {

  lateinit var hillforts: HillfortStore
  val users = ArrayList<UserModel>()

  override fun onCreate() {
    super.onCreate()
    hillforts = HillfortJSONStore(applicationContext)
    info("Hillfort started")
  }
}