package com.nguyenxuansangvn.demomvvm.data.repository

import com.nguyenxuansangvn.demomvvm.data.ApiService
import com.nguyenxuansangvn.demomvvm.data.model.Repositories
import com.nguyenxuansangvn.demomvvm.data.source.remote.UserRemoteDataSource
import io.reactivex.rxjava3.core.Observable

class RepositoriesRepository(
    private var userRemoteDataSource: UserRemoteDataSource,
    private val apiRepository: ApiService
){
    fun getRepositories():Observable<Repositories>{
        userRemoteDataSource = UserRemoteDataSource(apiRepository)
        return userRemoteDataSource.getUser()
    }
}
