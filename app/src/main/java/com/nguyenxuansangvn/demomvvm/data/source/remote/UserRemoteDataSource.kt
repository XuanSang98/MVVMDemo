package com.nguyenxuansangvn.demomvvm.data.source.remote

import com.nguyenxuansangvn.demomvvm.data.ApiService
import com.nguyenxuansangvn.demomvvm.data.model.Repositories
import com.nguyenxuansangvn.demomvvm.data.source.UserDataSource
import io.reactivex.rxjava3.core.Observable

open class UserRemoteDataSource(private val apiRepository: ApiService): UserDataSource.Remote{
    override fun getUser(): Observable<Repositories> {
            return apiRepository.getRepositories()
    }
}
