package kz.arbuz.kinobuz.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kz.arbuz.kinobuz.domain.entity.Pokemon
import kz.arbuz.kinobuz.domain.usecase.GetPokemonListUseCase

class PokemonViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase
): ViewModel() {

    private val _pokemons = MutableLiveData<List<Pokemon>>(emptyList())
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    fun dispatch(action: Action) {
        when (action) {
            Action.onCreated -> {
                GlobalScope.launch {
                    _pokemons.value = getPokemonListUseCase.invoke()
                }
            }
        }
    }

    sealed class Action {
        object onCreated: Action()
    }
}