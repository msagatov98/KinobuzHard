package kz.arbuz.kinobuz.di

import kz.arbuz.kinobuz.BuildConfig
import kz.arbuz.kinobuz.data.api.PokemonService
import kz.arbuz.kinobuz.domain.usecase.GetPokemonListUseCase
import kz.arbuz.kinobuz.presentation.PokemonViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val module = module {

    factory {
        GetPokemonListUseCase(service = get())
    }

    viewModel { PokemonViewModel(get()) }

    single {
        Retrofit
            .Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .callTimeout(60_000, TimeUnit.MILLISECONDS)
                    .readTimeout(60_000, TimeUnit.MILLISECONDS)
                    .addInterceptor(HttpLoggingInterceptor())
                    .build()
            )
            .build().create(PokemonService::class.java)
    }
}
