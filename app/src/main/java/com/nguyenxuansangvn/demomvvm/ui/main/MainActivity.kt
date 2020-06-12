package com.nguyenxuansangvn.demomvvm.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nguyenxuansangvn.demomvvm.R
import com.nguyenxuansangvn.demomvvm.data.ApiService
import com.nguyenxuansangvn.demomvvm.data.ServiceBuilder
import com.nguyenxuansangvn.demomvvm.data.repository.RepositoriesRepository
import com.nguyenxuansangvn.demomvvm.data.source.remote.UserRemoteDataSource
import com.nguyenxuansangvn.demomvvm.ui.detail.RepositoriesDetail
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val apiService = ServiceBuilder.buildService(ApiService::class.java)
    private val userRemoteDataSource = UserRemoteDataSource(apiService)
    private val disposable = CompositeDisposable()
    private var repositoriesAdapter = RepositoriesAdapter()
    private val viewModel by lazy {
        val repository = RepositoriesRepository(userRemoteDataSource, apiService)
        RepositoriesViewModel(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { item ->
                    repositoriesAdapter.setItems(item.items)
                    recyclerviewRepositories.adapter = repositoriesAdapter
                }
            )
            .addTo(disposable)

        repositoriesAdapter.setOnClickListener {
            startActivity(RepositoriesDetail.getIntent(this, it))
        }
    }
}
