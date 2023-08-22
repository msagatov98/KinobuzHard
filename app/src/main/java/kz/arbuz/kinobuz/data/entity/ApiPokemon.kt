package kz.arbuz.kinobuz.data.entity

class ApiPokemonList(
    val results: List<ApiPokemon>
)

class ApiPokemon(
    val name: String,
    val url: String,
)