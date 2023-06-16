package com.example.uts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BarangClass(
    val barangimg: Int,
    val barangname: String,
    val barangharga: String,
    val barangdeskripsi: String,

) : Parcelable