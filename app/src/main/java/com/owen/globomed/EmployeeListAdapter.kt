package com.owen.globomed

import android.content.Context
import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class EmployeeListAdapter(
    private val context: Context
) : RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeListAdapter.EmployeeViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val itemView  = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return EmployeeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onBindViewHolder(holder: EmployeeListAdapter.EmployeeViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class EmployeeViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {

    }

}