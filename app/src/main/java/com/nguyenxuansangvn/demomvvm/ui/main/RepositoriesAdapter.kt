package com.nguyenxuansangvn.demomvvm.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nguyenxuansangvn.demomvvm.data.model.Items
import androidx.databinding.DataBindingUtil
import com.nguyenxuansangvn.demomvvm.R
import com.nguyenxuansangvn.demomvvm.databinding.ComponentItemBinding

class RepositoriesAdapter : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    private lateinit var clickListener: (Int) ->Unit
    private val items = mutableListOf<Items>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val databinding = DataBindingUtil.inflate<ComponentItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.component_item,
            parent,
            false
        )
        return ViewHolder(databinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position], clickListener)
    }

    fun setItems(items: List<Items>) {
        if (this.items.isNotEmpty()) this.items.clear()
        this.items.addAll(items)
    }

    fun setOnClickListener(clickListener: (Int) ->Unit) {
        this.clickListener = clickListener
    }

    class ViewHolder(
        private val databinding: ComponentItemBinding
    ) :
        RecyclerView.ViewHolder(databinding.root){

        fun bindData(items: Items,clickListener: (Int) ->Unit) {
            databinding.item = items
            itemView.setOnClickListener {
                clickListener(adapterPosition)
            }
        }
    }
}
