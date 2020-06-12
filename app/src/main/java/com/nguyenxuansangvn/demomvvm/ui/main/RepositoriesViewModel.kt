package com.nguyenxuansangvn.demomvvm.ui.main

import androidx.lifecycle.ViewModel
import com.nguyenxuansangvn.demomvvm.data.repository.RepositoriesRepository

class RepositoriesViewModel(
    private val repositoriesRepository: RepositoriesRepository
) : ViewModel() {

    fun getRepositories() = repositoriesRepository.getRepositories()
}
