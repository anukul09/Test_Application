package com.example.offlinetestapplication.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.offlinetestapplication.MvvmApplication
import com.example.offlinetestapplication.data.roomdb.AppDatabase
import com.example.offlinetestapplication.data.roomdb.ProfileEntity
import com.example.offlinetestapplication.util.Coroutins
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyReposiotry {

    var savedProfiles = MutableLiveData<List<ProfileEntity>>()

    fun saveInDB(profileEntity: ProfileEntity) {

            Coroutins.io {
                AppDatabase(MvvmApplication.context).getProfileDao().insertProfile(profileEntity)
                withContext(Dispatchers.Main){
                    getDataFromRoom()
                }
            }
    }

    fun getDataFromRoom() {
        Coroutins.io {
            var getSavedProfiles = AppDatabase(MvvmApplication.context).getProfileDao().getAllProfiles()

            withContext(Dispatchers.Main){
                savedProfiles.value = getSavedProfiles
            }
        }
    }

    fun getDataByNames() {
        Coroutins.io {
            var getSavedProfiles = AppDatabase(MvvmApplication.context).getProfileDao().getProfilesByNames()

            withContext(Dispatchers.Main){
                savedProfiles.value = getSavedProfiles
            }
        }
    }

    fun getDataByPhoneNo() {
        Coroutins.io {
            var getSavedProfiles = AppDatabase(MvvmApplication.context).getProfileDao().getProfilesByPhoneNo()

            withContext(Dispatchers.Main){
                savedProfiles.value = getSavedProfiles
            }
        }
    }

}