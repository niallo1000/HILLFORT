package org.wit.hillfort.models



interface HillfortStore {
    fun findAll(): List<HillfortModel>
    fun create(hillfort: HillfortModel)
    fun update(hillfort: HillfortModel)
   fun delete(hillfort: HillfortModel)
//    fun findUsersHillforts(userId: Long): List<HillfortModel>
 //   fun findVisitedHillforts(userId: Long): List<HillfortModel>
    fun findById(id:Long) : HillfortModel?
    fun clear()
}