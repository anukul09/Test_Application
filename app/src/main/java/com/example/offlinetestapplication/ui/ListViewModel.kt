package com.example.offlinetestapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.offlinetestapplication.data.repository.MyReposiotry
import com.example.offlinetestapplication.data.roomdb.ProfileEntity

class ListViewModel(var myReposiotry: MyReposiotry) : ViewModel() {
    var mProfilesReponse =  MutableLiveData<List<ProfileEntity>>()
    private set

    init {
        mProfilesReponse = myReposiotry.savedProfiles
    }

    fun getAllProfiles(){
        myReposiotry.getDataFromRoom()
    }

    fun SaveNewProfile(profileEntity: ProfileEntity){
        myReposiotry.saveInDB(profileEntity)
    }

    fun getProfilesByName(){
        myReposiotry.getDataByNames()
    }

    fun getProfilesByPhoneNo(){
        myReposiotry.getDataByPhoneNo()
    }
}