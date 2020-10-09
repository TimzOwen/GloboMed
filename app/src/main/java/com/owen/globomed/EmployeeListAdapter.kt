package com.owen.globomed

import android.content.Context
import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class EmployeeListAdapter(
    private val context: Context
) : RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>()
{
    lateinit var employeesList: ArrayList<Employee>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeListAdapter.EmployeeViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val itemView  = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return EmployeeViewHolder(itemView)
    }

    override fun getItemCount(): Int = employeesList.size

    override fun onBindViewHolder(holder: EmployeeListAdapter.EmployeeViewHolder, position: Int) {
        val employee:Employee = employeesList[position]
        holder.setData(employee.name,employee.designation)
    }

    fun setEmployees(employees: ArrayList<Employee>) {

        employeesList = employees
        notifyDataSetChanged()
    }

    class EmployeeViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        fun setData(name: String ,designation: String) {
            itemView.tvEmpName.text =name
            itemView.tvEmpDesgn.text = designation
        }

    }

}