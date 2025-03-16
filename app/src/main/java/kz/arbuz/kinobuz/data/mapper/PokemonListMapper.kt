package kz.arbuz.kinobuz.data.mapper

import kz.arbuz.kinobuz.data.entity.ApiPokemonList
import kz.arbuz.kinobuz.domain.entity.Pokemon

class PokemonListMapper {

    fun map(data: ApiPokemonList): List<Pokemon> {
        return data.results.map {
            val number = if (it.url.endsWith("/")) {
                it.url.dropLast(1).takeLastWhile { it.isDigit() }
            } else {
                it.url.takeLastWhile { it.isDigit() }
            }
            Pokemon(
                name = it.name,
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
            )
        }
    }
}