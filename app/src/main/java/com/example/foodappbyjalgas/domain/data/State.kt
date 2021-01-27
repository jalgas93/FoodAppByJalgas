package com.example.foodappbyjalgas.domain.data

data class State<out T>(
        val data: T? = null,
        val error: String? = null,
        val loading: Boolean = false
) {
    companion object {
        fun <T> Success(
                data: T
        ): State<T> {
            return Success(
                    data = data
            )
        }

        fun <T> Error(
                message: String
        ): State<T> {
            return Companion.Error(
                    message = message
            )

        }

        fun <T> loading(): State<T> = State(loading = true)

    }

}