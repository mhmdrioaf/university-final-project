package com.gudmal.storagemanagement.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.gudmal.storagemanagement.repository.auth.AuthRepository
import com.gudmal.storagemanagement.repository.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl(
        auth = Firebase.auth
    )
}