package com.example.praca_inz.property

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactProperty (
    val username: String,
    val contactName:String,
    val composition:String,
    val type:String,
        ):Parcelable{

        }