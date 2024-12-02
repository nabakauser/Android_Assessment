package com.example.android_assessment.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_assessment.data.remote.RecentTransactionModel
import com.example.android_assessment.service.ApiRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ApiRepository
): ViewModel() {

    private val userDetailsLD = MutableLiveData<ArrayList<RecentTransactionModel?>>()
    var userDetails: LiveData<ArrayList<RecentTransactionModel?>> = userDetailsLD

    init {
        getTransactions()
    }

    private fun getTransactions() {
        viewModelScope.launch {
            val response = repository.getTransactionUsers()
            Log.d("responseLog","$response")
            if(!response.data.isNullOrEmpty()) {
                userDetailsLD.value = response.data!!
            }
        }
    }
}