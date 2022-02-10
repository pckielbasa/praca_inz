package com.example.praca_inz.property

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyAllergiesProperty(
    val _id:String,
    val type:String,
    val allergenName:String,
    val allergiesName:String,
    val afterTime:String,
    val symptoms:String,
    val help:String
): Parcelable {

}
