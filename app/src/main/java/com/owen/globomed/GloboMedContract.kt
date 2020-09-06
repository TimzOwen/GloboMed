package com.owen.globomed

import android.provider.BaseColumns
import android.provider.BaseColumns._ID

object GloboMedContract {


    object EmployeeEntry:BaseColumns{
        const val TABLE_NAME = "employee"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_DOB = "dob"
        const val COLUMN_DESIGNATION = "designation"

        //create the Query here
        const val SQL_CREATE_ENTRIES: String = "" +
                "CREATE TABLE ${EmployeeEntry.TABLE_NAME}(" +
                _ID + " INTEGER PRIMARY KEY AUTO INCREMENT," +
                "${EmployeeEntry.COLUMN_NAME} TEXT NOT NULL," +
                "${EmployeeEntry.COLUMN_DOB} INTEGER, NOT NULL," +
                "${EmployeeEntry.COLUMN_DESIGNATION} TEXT NOT NULL)"

        //drop table
        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS ${EmployeeEntry.TABLE_NAME}"
    }
}