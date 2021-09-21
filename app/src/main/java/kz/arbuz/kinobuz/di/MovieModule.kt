package kz.arbuz.kinobuz.di

import kz.arbuz.kinobuz.domain.usecase.GetTop250MoviesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val module = module {

    factory {
        GetTop250MoviesUseCase(service = get())
    }


}