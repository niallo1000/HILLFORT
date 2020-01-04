package org.wit.hillfort.models.mem

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.hillfort.models.HillfortModel
import org.wit.hillfort.models.HillfortStore

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}


class HillfortMemStore : HillfortStore, AnkoLogger {

    val hillforts = ArrayList<HillfortModel>()

    override fun findAll(): List<HillfortModel> {
        return hillforts
    }


  //  override fun findUsersHillforts(userId: Long): List<HillfortModel> {
 //       return hillforts.filter { it.userId == userId }

  //  }



   // override fun findVisitedHillforts(userId: Long): List<HillfortModel> {
  //      var allHillforts =  hillforts.filter { it.userId == userId }
  //      return allHillforts.filter { it.visited == true }
 //   }

    override fun create(hillfort: HillfortModel) {
        hillfort.id = getId()
        hillforts.add(hillfort)
        logAll()
    }

    override fun update(hillfort: HillfortModel) {
        val foundHillfort: HillfortModel? = hillforts.find { p -> p.id == hillfort.id }
        if (foundHillfort != null) {
            foundHillfort.title = hillfort.title
            foundHillfort.description = hillfort.description
            foundHillfort.location = hillfort.location
          //  foundHillfort.visited = hillfort.visited
          //  foundHillfort.dateVisited = hillfort.dateVisited
          //  foundHillfort.userId = hillfort.userId
            foundHillfort.image = hillfort.image

            logAll()
        }
    }

    fun logAll() {
        hillforts.forEach { info("${it}") }
    }


    override fun delete(placemark: HillfortModel) {
        hillforts.remove(placemark)
    }

    override fun findById(id:Long) : HillfortModel? {
        val foundPlacemark: HillfortModel? = hillforts.find { it.id == id }
        return foundPlacemark
    }


}