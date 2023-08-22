package kz.arbuz.kinobuz.domain.usecase

import kz.arbuz.kinobuz.data.api.PokemonService
import kz.arbuz.kinobuz.domain.entity.Pokemon

class GetPokemonListUseCase(
    private val service: PokemonService
) {

    suspend operator fun invoke(): List<Pokemon> {
        return service.getPokemons()
            .results.map { apiPokemon ->
                val number = if (apiPokemon.url.endsWith("/")) {
                    apiPokemon.url.dropLast(1).takeLastWhile { it.isDigit() }
                } else {
                    apiPokemon.url.takeLastWhile { it.isDigit() }
                }
                Pokemon(
                    name = apiPokemon.name,
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
                )
            }
    }
}