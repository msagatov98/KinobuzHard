package kz.arbuz.kinobuz

import kz.arbuz.kinobuz.data.entity.ApiMovie


class MovieListResponse(
    val items: List<ApiMovie>
)

class Movie(
    val id: String,
    val title: String,
    val image: String,
    val year: Int,
    val rating: Float
)