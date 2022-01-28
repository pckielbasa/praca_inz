package com.example.praca_inz.property

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DayScheduleProperty (
    val username: String,
    val dayDate:String
        ): Parcelable {

}

