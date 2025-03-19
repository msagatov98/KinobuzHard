package kz.arbuz.kinobuz.domain.usecase

import android.util.Log
import kz.arbuz.kinobuz.data.api.PokemonService
import kz.arbuz.kinobuz.data.entity.ApiPokemon
import kz.arbuz.kinobuz.data.mapper.PokemonListMapper
import kz.arbuz.kinobuz.domain.entity.Pokemon

class GetPokemonListUseCase(
    private val service: PokemonService
) {

    suspend operator fun invoke(): List<Pokemon> {
        val pokemonResponse = service.getPokemons()
        return PokemonListMapper().map(pokemonResponse)
    }
}