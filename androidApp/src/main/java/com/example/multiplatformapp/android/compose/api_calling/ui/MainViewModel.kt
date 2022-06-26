package com.example.multiplatformapp.android.compose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multiplatformapp.api_calling.di.model.Phone
import com.example.multiplatformapp.api_calling.di.repository.PostRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: PostRepository) : ViewModel() {

    private val _response: MutableState<Contract.PhoneContract> =
        mutableStateOf(Contract.PhoneContract())
    val response = _response

    init {
        viewModelScope.launch {
            repository.getPhone()
                .onStart {
                    _response.value = Contract.PhoneContract(
                        data = emptyList(),
                        error = "",
                        isLoading = true
                    )
                }
                .catch { e ->
                    _response.value = Contract.PhoneContract(
                        data = emptyList(),
                        error = e.message!!,
                        isLoading = false
                    )
                }.collect {
                    _response.value = Contract.PhoneContract(
                        data = it,
                        error = "",
                        isLoading = false
                    )
                }
        }
    }

}

class Contract {
    data class PhoneContract(
        val data: List<Phone> = emptyList(),
        val error: String = "",
        val isLoading: Boolean = false
    )
}
