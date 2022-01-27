package com.example.praca_inz.property

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllergiesProperty (
    val allergyName:String,
    val type:String,
    val comment:String
        ): Parcelable {

}