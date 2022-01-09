package com.example.praca_inz.property

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactProperty (
    val contactName:String,
    val composition:String,
    val commentAlertAllergies:String,
    val type:String,
    val allergy:Boolean
        ):Parcelable