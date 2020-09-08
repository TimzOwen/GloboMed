package com.owen.globomed

import android.app.Activity
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class AddEmployeeActivity : Activity() {

    private val myCalender : Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)

        val date = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH,month)
            myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth)

            etDoBirth.setText(getFormatedDate(myCalender.timeInMillis))
        }
        etDoBirth.setOnClickListener {
            setUpCalenderDate(date)
        }
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