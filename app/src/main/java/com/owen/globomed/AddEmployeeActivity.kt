package com.owen.globomed

import android.app.Activity
import android.app.DatePickerDialog
import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class AddEmployeeActivity : Activity() {

    private val myCalender : Calendar = Calendar.getInstance()
    private lateinit var databaseHelper:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)

        databaseHelper = DatabaseHelper(this)

        val date = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH,month)
            myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth)

            etDoBirth.setText(getFormatedDate(myCalender.timeInMillis))
        }
        etDoBirth.setOnClickListener {
            setUpCalenderDate(date)
        }
        btnCancel.setOnClickListener {
            finish()
        }
        btnSave.setOnClickListener {
            saveEmployee()
        }
    }

    private fun saveEmployee() {
        var isValid = true

        etfullName.error = if (etfullName?.text.toString().isEmpty())
        {
            isValid = false
            "Required Field"
        } else null
        etDesignation.error = if(etDesignation?.text.toString().isEmpty())
        {
            isValid = false
            "Required Field"
        }else null

        if (isValid)
        {
            val name:String  = etfullName?.text.toString()
            val designation:String  = etDesignation?.text.toString()
            val dob:Long = myCalender.timeInMillis

            val db:SQLiteDatabase = databaseHelper.writableDatabase

            val values = ContentValues()
            values.put(GloboMedContract.EmployeeEntry.COLUMN_NAME, name)
            values.put(GloboMedContract.EmployeeEntry.COLUMN_DESIGNATION,designation)
            values.put(GloboMedContract.EmployeeEntry.COLUMN_DOB, dob)

            val result:Long = db.insert(GloboMedContract.EmployeeEntry.TABLE_NAME,null,values)
            setResult(RESULT_OK, Intent())

            Toast.makeText(applicationContext,"Added successfully",Toast.LENGTH_SHORT).show()
        }
        finish()
    }

    private fun setUpCalenderDate(date: DatePickerDialog.OnDateSetListener) {
        DatePickerDialog(this,date,myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH),
            myCalender.get(Calendar.DAY_OF_MONTH)).show()
    }
    private fun getFormatedDate(dobInMilis: Long): String {
        return dobInMilis?.let {
            val sdf = SimpleDateFormat("d MMM yyyy", Locale.getDefault())
            sdf.format(dobInMilis)
        }?: "Not Found"
    }
}