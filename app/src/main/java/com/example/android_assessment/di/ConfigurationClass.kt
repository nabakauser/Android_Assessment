package com.example.android_assessment.di

import com.example.android_assessment.service.ApiRepository
import com.example.android_assessment.service.Rest
import com.example.android_assessment.ui.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ConfigurationClass {
    private val viewModelModules = module {
        viewModel { HomeViewModel(get()) }
    }

    private val repoModules = module {
        single<ApiRepository> { ApiRepository(get()) }
    }

    private val commonModules = module {
        single { Rest.client }
    }

    fun appModules() = viewModelModules + repoModules + commonModules
}