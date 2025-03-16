package kz.arbuz.kinobuz.data.api

import kz.arbuz.kinobuz.data.entity.ApiPokemonList
import retrofit2.http.GET

// https://pokeapi.co/
interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemons(): ApiPokemonList
}