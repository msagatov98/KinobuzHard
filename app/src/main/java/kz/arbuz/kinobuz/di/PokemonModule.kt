package kz.arbuz.kinobuz.di

import kz.arbuz.kinobuz.domain.usecase.GetPokemonListUseCase
import org.koin.dsl.module

val module = module {

    factory {
        GetPokemonListUseCase(service = get())
    }
}
