package org.wit.hillfort.models



interface HillfortStore {
    fun findAll(): List<HillfortModel>
    fun create(hillfort: HillfortModel)
    fun update(hillfort: HillfortModel)
    fun add(hillfort: HillfortModel)

}