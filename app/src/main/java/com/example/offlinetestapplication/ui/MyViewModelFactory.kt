package com.example.offlinetestapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.offlinetestapplication.data.repository.MyReposiotry

@Suppress("UNCHECKED_CAST")
class MyViewModelFactory(
    private val profilesRepo: MyReposiotry
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(profilesRepo) as T
    }
}