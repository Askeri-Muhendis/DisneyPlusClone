package com.junior.kekod.disneyplusclone.di

import com.google.firebase.auth.FirebaseAuth
import com.junior.kekod.disneyplusclone.data.repository.AuthRepositoryImpl
import com.junior.kekod.disneyplusclone.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(auth: FirebaseAuth): AuthRepository = AuthRepositoryImpl(auth = auth)

}