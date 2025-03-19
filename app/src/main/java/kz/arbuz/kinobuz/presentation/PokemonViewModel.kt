package kz.arbuz.kinobuz.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kz.arbuz.kinobuz.domain.entity.Pokemon
import kz.arbuz.kinobuz.domain.usecase.GetPokemonListUseCase

class PokemonViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase
): ViewModel() {

    private val _pokemons = MutableLiveData<List<Pokemon>>(emptyList())
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    init {
        dispatch(Action.onCreated)
    }

    fun dispatch(action: Action) {
        when (action) {
            Action.onCreated -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val response = getPokemonListUseCase.invoke()
                    _pokemons.postValue(response)
                }
            }
        }
    }

    sealed class Action {
        object onCreated: Action()
    }
}