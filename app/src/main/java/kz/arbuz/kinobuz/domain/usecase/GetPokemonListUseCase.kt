package kz.arbuz.kinobuz.domain.usecase

import kz.arbuz.kinobuz.data.api.PokemonService
import kz.arbuz.kinobuz.domain.entity.Pokemon

class GetPokemonListUseCase(
    private val service: PokemonService
) {

    suspend operator fun invoke(): List<Pokemon> {
        return service.getPokemons()
    }
}