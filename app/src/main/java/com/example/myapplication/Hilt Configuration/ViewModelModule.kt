package com.example.myapplication.Hilt

import com.example.myapplication.domain.DoctorRepository
import com.example.myapplication.presentation.FavoriteViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideFavoriteViewModel(repository: DoctorRepository): FavoriteViewModel {
        return FavoriteViewModel(repository)
    }


}