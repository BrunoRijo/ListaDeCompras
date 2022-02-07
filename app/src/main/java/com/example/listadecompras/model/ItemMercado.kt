package com.example.listadecompras.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemMercado(
    var name :String,
    var qtd : Int
) : Parcelable