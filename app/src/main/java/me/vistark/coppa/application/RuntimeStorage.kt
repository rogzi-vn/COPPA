package me.vistark.coppa.application

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.vistark.coppa._core.api.APIService
import me.vistark.coppa.domain.entity.*
import me.vistark.coppa.domain.entity.languages.CoppaTrans
import me.vistark.fastdroid.utils.Retrofit2Extension.Companion.await
import me.vistark.fastdroid.utils.storage.AppStorageManager
import java.lang.Exception

object RuntimeStorage {
    fun clear() {
        TripSyncs = emptyArray()
        CurrentTripSync = null
        TripLogs = emptyArray()
        CurrentCaptainProfile = CaptainProfile()
    }

    fun init() {
        GlobalScope.launch {
            try {
                val apis = APIService().APIs
                // Lấy danh sách các nhóm loài
                val speciesCategory = apis.getSpeciesCategories().await()
                speciesCategory!!.result?.apply {
                    RuntimeStorage.SpeciesCategories = this.toTypedArray()
                }

                // Lấy danh sách các loài
                val specieses = apis.getSpecieses().await()
                specieses!!.result?.apply {
                    RuntimeStorage.Specieses = this.toTypedArray()
                }

                // Lấy danh sách các cảng biển
                val seaPorts = apis.getSeaPorts().await()
                seaPorts!!.result?.apply {
                    RuntimeStorage.SeaPorts = this.toTypedArray()
                }

                // Lấy danh sách lịch sử chuyến đi biển
                val tripLogs = apis.getTripHistories().await()
                tripLogs!!.result?.apply {
                    RuntimeStorage.TripLogs = this.toTypedArray()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    var Countries: Array<Country>
        get() = AppStorageManager.get("COPPA_COUNTRIES") ?: emptyArray()
        set(value) {
            AppStorageManager.update("COPPA_COUNTRIES", value)
        }

    var Translates: CoppaTrans
        get() = AppStorageManager.get("COPPA_TRANSLATE") ?: CoppaTrans()
        set(value) {
            AppStorageManager.update("COPPA_TRANSLATE", value)
        }

    var TripSyncs: Array<TripSync>
        get() = AppStorageManager.get("COPPA_TRIP_SYNCS") ?: emptyArray()
        set(value) {
            AppStorageManager.update("COPPA_TRIP_SYNCS", value)
        }

    var CurrentTripSync: TripSync?
        get() = AppStorageManager.get("COPPA_CURRENT_TRIP")
        set(value) {
            AppStorageManager.update("COPPA_CURRENT_TRIP", value)
        }

    var TripLogs: Array<TripLog>
        get() = AppStorageManager.get("COPPA_TRIP_LOGS") ?: emptyArray()
        set(value) {
            AppStorageManager.update("COPPA_TRIP_LOGS", value)
        }

    var CurrentUsername: String
        get() = AppStorageManager.get("COPPA_CURRENT_USERNAME") ?: ""
        set(value) {
            AppStorageManager.update("COPPA_CURRENT_USERNAME", value)
        }

    var SavedCulture: String
        get() = AppStorageManager.get("COPPA_SAVED_CULTURE") ?: ""
        set(value) {
            AppStorageManager.update("COPPA_SAVED_CULTURE", value)
        }

    var CurrentCaptainProfile: CaptainProfile
        get() = AppStorageManager.get("COPPA_SAVED_CAPTAIN_PROFILE") ?: CaptainProfile()
        set(value) {
            SavedCulture = value.cultureName
            AppStorageManager.update("COPPA_SAVED_CAPTAIN_PROFILE", value)
        }

    var SpeciesCategories: Array<SpeciesCategory>
        get() = AppStorageManager.get("COPPA_SPECIES_CATEGORIES") ?: emptyArray()
        set(value) {
            AppStorageManager.update("COPPA_SPECIES_CATEGORIES", value)
        }

    var Specieses: Array<Species>
        get() = AppStorageManager.get("COPPA_SPECIESES") ?: emptyArray()
        set(value) {
            AppStorageManager.update("COPPA_SPECIESES", value)
        }

    var SeaPorts: Array<SeaPort>
        get() = AppStorageManager.get("COPPA_SEA_PORTS") ?: emptyArray()
        set(value) {
            AppStorageManager.update("COPPA_SEA_PORTS", value)
        }

}