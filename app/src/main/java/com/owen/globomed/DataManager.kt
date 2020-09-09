package com.owen.globomed

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.owen.globomed.GloboMedContract.EmployeeEntry

object DataManager {

    fun fetchAllEmployees(databaseHelper: DatabaseHelper):ArrayList<Employee>{

        val employees = ArrayList<Employee>()

        val db:SQLiteDatabase = databaseHelper.readableDatabase

        val columns:Array<String> = arrayOf(
            EmployeeEntry.COLUMN_ID,
            EmployeeEntry.COLUMN_NAME,
            EmployeeEntry.COLUMN_DOB,
            EmployeeEntry.COLUMN_DESIGNATION
        )

        val cursor : Cursor = db.query(EmployeeEntry.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null)

        return employees
    }
}