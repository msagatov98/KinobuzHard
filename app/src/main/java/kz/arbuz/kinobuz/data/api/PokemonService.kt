package kz.arbuz.kinobuz.data.api

import kz.arbuz.kinobuz.data.entity.ApiPokemon
import retrofit2.http.GET

// https://pokeapi.co/
interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemons(): List<ApiPokemon>
}