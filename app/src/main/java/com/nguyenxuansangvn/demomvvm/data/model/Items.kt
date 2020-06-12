package com.nguyenxuansangvn.demomvvm.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items (
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("full_name")
    var full_name: String?,

    @SerializedName("private")
    var private: Boolean

): Parcelable
