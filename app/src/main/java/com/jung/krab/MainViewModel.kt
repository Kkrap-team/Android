package com.jung.krab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jung.krab.core.network.Repository
import com.jung.krab.dto.ApiResult
import com.jung.krab.dto.Test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn

class MainViewModel(private val repository: Repository) : ViewModel() {

//    val testData: StateFlow<ApiResult<Test>> get() = _testData
//    private var _testData: StateFlow<ApiResult<Test>> =
//        repository.getToJsons("/slack", HashMap(), Test::class.java)
//            .flowOn(Dispatchers.IO)
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(3000L),
//                initialValue = ApiResult.Loading
//            )
//    fun getMovies(
//        params: Params,
//    ): Flow<ApiResult<DataResponse>> = safeFlow {
//        service.getMovies(params = Params)
//    }
    fun getData() = repository.getToJsons("/login", HashMap(), Test::class.java)
}