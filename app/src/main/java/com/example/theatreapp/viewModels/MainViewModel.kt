package com.example.theatreapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.theatreapp.models.CarouselButtons
import com.example.theatreapp.models.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


/*
class MainViewModel() : ViewModel(){
    val uiState : MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState(CarouselButtons.PLAYBILL))

    fun changeActiveCarouselButton(newButton : CarouselButtons){
        uiState.update { it.copy(activeButton = newButton) }
    }

}*/
