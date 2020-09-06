package com.owen.globomed

import android.provider.BaseColumns

object GloboMedContract {
    object EmployeeEntry:BaseColumns{
        const val TABLE_NAME = "employee"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_DOB = "dob"
        const val COLUMN_DESIGNATION = "designation"
    }
}