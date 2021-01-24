package me.vistark.coppa.application.api.signup.request


import com.google.gson.annotations.SerializedName

data class RegisterRequestDTO(
    @SerializedName("captainFirstname")
    var captainFirstname: String = "",
    @SerializedName("captainLastName")
    var captainLastname: String = "",
    @SerializedName("culture_name")
    var cultureName: String = "",
    @SerializedName("duration")
    var duration: String = "",
    @SerializedName("email")
    var email: String = "",
    @SerializedName("fishing_license")
    var fishingLicense: String = "",
    @SerializedName("image")
    var image: String = "",
    @SerializedName("password")
    var password: String = "",
    @SerializedName("phone")
    var phone: String = "",
    @SerializedName("shipownerFirstname")
    var shipownerFirstname: String = "",
    @SerializedName("shipownerLastname")
    var shipownerLastname: String = "",
    @SerializedName("username")
    var username: String = "",
    @SerializedName("vessel_registration")
    var vesselRegistration: String = ""
)