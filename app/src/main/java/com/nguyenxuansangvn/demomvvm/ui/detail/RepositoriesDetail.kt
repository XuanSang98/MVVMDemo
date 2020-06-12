package com.nguyenxuansangvn.demomvvm.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyenxuansangvn.demomvvm.R

class RepositoriesDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories_detail)
    }

    companion object {
        const val ID: String = "id"
        fun getIntent(context: Context, id: Int) =
            Intent(context, RepositoriesDetail::class.java).putExtra(ID, id)
    }
}
