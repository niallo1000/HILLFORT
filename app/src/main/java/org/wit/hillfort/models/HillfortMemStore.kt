package org.wit.hillfort.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}


class HillfortMemStore : HillfortStore, AnkoLogger {

    val hillforts = ArrayList<HillfortModel>()

    override fun findAll(): List<HillfortModel> {
        return hillforts
    }

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
            foundHillfort.visited = hillfort.visited
            foundHillfort.image = hillfort.image
            foundHillfort.lat = hillfort.lat
            foundHillfort.lng = hillfort.lng
            foundHillfort.zoom = hillfort.zoom
            logAll()
        }
    }

    fun logAll() {
        hillforts.forEach { info("${it}") }
    }

    override fun add(hillfort: HillfortModel) {
        hillforts.add(HillfortModel(1, "Ridge of Capard", "Near the modern town of Rosenallis, a circular contour fort positioned in a commanding position at the NE end of a hill ridge known as the 'Ridge of Capard'","Laois", true, " s", -7.433312,  53.121486,0f))
        hillforts.add(HillfortModel(2, "Kilpoole Upper ", "This possible coastal promontory fort is located c. 5km SE of Wicklow Town.","Wicklow", false, " s", -6.017528,  52.943869 ,0f))
        hillforts.add(HillfortModel(3, "Kilcashel  ", "Near small village of Ballygahan, an oval hillslope fort of approximately 1.6ha total site footprint positioned on sloping ground with steep break of slope to N, E and S. Extensive views of the Avoca river valley from the interior.","Wicklow", false, " s", -6.231896,  52.872296 ,0f))
    }

}