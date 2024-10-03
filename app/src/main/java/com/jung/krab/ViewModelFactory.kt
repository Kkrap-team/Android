package com.jung.krab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jung.krab.core.network.Repository

class ViewModelFactory(repository: Repository): ViewModelProvider.Factory {
    private var repository: Repository? = null

    init {
        this.repository = repository
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return repository?.let { MainViewModel(it) } as T
        }
        throw IllegalArgumentException("뷰모델을 만들 수 없습니다 : IllegalArgumentException")
    }
}