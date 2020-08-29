package com.example.offlinetestapplication.data.roomdb

import androidx.room.*

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(proEntity: ProfileEntity)

    @Update
    fun updateProfile(proEntity: ProfileEntity)

    @Delete
    fun deleteProfile(proEntity: ProfileEntity)

    @Query("SELECT * FROM ProfileEntity")
    fun getAllProfiles(): List<ProfileEntity>

    @Query("SELECT * FROM ProfileEntity ORDER BY name ASC")
    fun getProfilesByNames(): List<ProfileEntity>

    @Query("SELECT * FROM ProfileEntity ORDER BY phoneNo ASC")
    fun getProfilesByPhoneNo(): List<ProfileEntity>
}