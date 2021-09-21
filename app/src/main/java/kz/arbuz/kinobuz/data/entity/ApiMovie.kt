package kz.arbuz.kinobuz.data.entity

class ApiMovieList(
    val items: List<ApiMovie>
)

class ApiMovie(
    val id: String,
    val title: String,
    val image: String,
    val year: Int,
    val rating: Float
)