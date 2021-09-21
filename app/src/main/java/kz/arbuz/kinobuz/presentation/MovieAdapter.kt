package kz.arbuz.kinobuz.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kz.arbuz.kinobuz.data.entity.ApiMovie
import kz.arbuz.kinobuz.R

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var items: List<ApiMovie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_movie, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(movie: ApiMovie) {
            val nameTextView = itemView.findViewById<TextView>(R.id.name)
            val posterImageView = itemView.findViewById<ImageView>(R.id.image)
            val yearTextView = itemView.findViewById<TextView>(R.id.year)
            val ratingTextView = itemView.findViewById<TextView>(R.id.rating)

            nameTextView.text = movie.title
            yearTextView.text = movie.year.toString()
            ratingTextView.text = "rating: ${movie.rating}"
            posterImageView.load(movie.image)
        }
    }
}