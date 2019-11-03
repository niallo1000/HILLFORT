package org.wit.hillfort.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class HillfortModel(var id: Long = 0,
                         var title: String = "",
                          var description: String = "",
                         var location: String = "",
                         var visited: Boolean = false,
                         var image: String = ""): Parcelable
