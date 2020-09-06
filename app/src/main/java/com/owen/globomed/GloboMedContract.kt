package com.owen.globomed

import android.provider.BaseColumns

object GloboMedContract {

    //create the Query here
    const val SQL_CREATE_ENTRIES: String = "" +
            "CREATE TABLE ${EmployeeEntry.TABLE_NAME}(" +
            "${EmployeeEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTO INCREMENT," +
            "${EmployeeEntry.COLUMN_NAME} TEXT NOT NULL," +
            "${EmployeeEntry.COLUMN_DOB} DATE, NOT NULL," +
            "${EmployeeEntry.COLUMN_DESIGNATION} TEXT NOT NULL)"

    object EmployeeEntry:BaseColumns{
        const val TABLE_NAME = "employee"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_DOB = "dob"
        const val COLUMN_DESIGNATION = "designation"
    }
}