package com.example.praca_inz.property

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyDayProperty(
    val _id:String,
    val time:String,
    val dayDate:String,
    val itemId:String,
    val itemName:String,
    val itemCompo:String,
    val type:String
): Parcelable {

}