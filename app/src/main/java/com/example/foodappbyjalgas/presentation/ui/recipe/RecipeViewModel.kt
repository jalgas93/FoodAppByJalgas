package com.example.foodappbyjalgas.presentation.ui.recipe

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodappbyjalgas.domain.data.State
import com.example.foodappbyjalgas.domain.model.Model
import com.example.foodappbyjalgas.iteractors.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
class RecipeViewModel @Inject constructor(
        private val mainRepository: MainRepository,
        private @Named("auth_token") val token: String,
        @Assisted private val state: SavedStateHandle,
) : ViewModel() {

    var recipeLiveData: MutableLiveData<Model> = MutableLiveData()

    private fun getRecipe(id: Int) {
        mainRepository.execute(id, token).onEach { datastate ->
            withContext(Dispatchers.IO) {


                datastate.data.let { data ->
                    recipeLiveData.value = data

                }
                datastate.error.let { error ->
                    Log.e("jalgasError", "getRecipe:${error}")

                }

            }

        }.launchIn(viewModelScope)

    }

}