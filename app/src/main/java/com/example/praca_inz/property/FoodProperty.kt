package com.example.praca_inz.property

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodProperty (
    val username: String,
    val foodName:String,
    val composition:String,
    val type:String,
    val favourite:Boolean,
        ):Parcelable{

        }