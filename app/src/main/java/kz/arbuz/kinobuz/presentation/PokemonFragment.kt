package kz.arbuz.kinobuz.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kz.arbuz.kinobuz.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonFragment: Fragment(R.layout.fragment_pokemons) {

    private val pokemonViewModel: PokemonViewModel by viewModel()

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.movie_list)
        val adapter = PokemonAdapter()
        recyclerView.adapter = adapter

        pokemonViewModel.pokemons.observe(this) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
    }
}