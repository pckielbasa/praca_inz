package com.example.praca_inz.property

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyContactProperty  (
    val contactName:String,
    val composition:String,
    val type:String,
    val favourite:Boolean,
    val allergy:Boolean
): Parcelable {

}