package me.vistark.coppa.domain.entity


import com.google.gson.annotations.SerializedName

data class SpecicesInfomation(
    @SerializedName("catched_at")
    var catchedAt: String = "",
    @SerializedName("images")
    var images: String = "",
    @SerializedName("lat")
    var lat: String = "",
    @SerializedName("length")
    var length: Float = 0F,
    @SerializedName("long")
    var long: String = "",
    @SerializedName("specie_id")
    var specieId: Int = 0,
    @SerializedName("weight")
    var weight: Float = 0F
)