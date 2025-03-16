package kz.arbuz.kinobuz.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kz.arbuz.kinobuz.R
import kz.arbuz.kinobuz.domain.entity.Pokemon

class PokemonAdapter(
    val fragment: PokemonFragment,
): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    var items: List<Pokemon> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_pokemon, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(movie: Pokemon) {
            val nameTextView = itemView.findViewById<TextView>(R.id.name)
            val posterImageView = itemView.findViewById<ImageView>(R.id.image)

            nameTextView.text = movie.name
            posterImageView.load(movie.imageUrl)
        }
    }
}