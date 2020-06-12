package com.nguyenxuansangvn.demomvvm.data.source

import com.nguyenxuansangvn.demomvvm.data.model.Repositories

interface UserDataSource {
    interface Remote{
        fun getUser():io.reactivex.rxjava3.core.Observable<Repositories>
    }
}
