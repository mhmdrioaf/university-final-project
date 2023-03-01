package com.gudmal.storagemanagement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gudmal.storagemanagement.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StorageManagementViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
    init {
        getAuthSatate()
    }

    fun getAuthSatate() = repo.getAuthState(viewModelScope)
}