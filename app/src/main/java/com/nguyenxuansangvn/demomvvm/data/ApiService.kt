package com.nguyenxuansangvn.demomvvm.data

import com.nguyenxuansangvn.demomvvm.data.model.Repositories
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("repositories?q=language:kotlin&page=1&per_page=10")
    fun getRepositories(): Observable<Repositories>
}
