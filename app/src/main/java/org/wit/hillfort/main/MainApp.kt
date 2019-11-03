package org.wit.hillfort.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.hillfort.models.HillfortMemStore
import org.wit.hillfort.models.HillfortModel
import org.wit.hillfort.models.UserModel

class MainApp : Application(), AnkoLogger {

  val hillforts = HillfortMemStore()
  val users = ArrayList<UserModel>()


  override fun onCreate() {
    super.onCreate()
    info("Hillfort started")


  }
}