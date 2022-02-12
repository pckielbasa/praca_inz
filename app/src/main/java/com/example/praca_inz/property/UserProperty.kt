package com.example.praca_inz.property

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserProperty (
    val username: String,
    val email: String,
    val name: String,
    val surname: String,
    val phoneNumber: String,
): Parcelable {

}