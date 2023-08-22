package kz.arbuz.kinobuz

import android.app.Application
import kz.arbuz.kinobuz.data.api.PokemonService
import kz.arbuz.kinobuz.di.module
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class KinobuzApplication: Application() {

    val imdbService: PokemonService by lazy {
        createRetrofit().create()
    }

    private fun createRetrofit() = Retrofit
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
        .build()
}