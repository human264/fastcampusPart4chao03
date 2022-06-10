package fastcampus.aop.part3.aop_part4_chapter03.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationLatLngEntity(
    val latitude:Float,
    val longitude: Float
): Parcelable
