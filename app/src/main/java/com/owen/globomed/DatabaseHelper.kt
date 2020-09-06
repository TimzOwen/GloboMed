package com.owen.globomed

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context?): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    //initialize db name and version
    companion object{
        const val DATABASE_NAME = "globomed.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //create the db
        db?.execSQL(GloboMedContract.EmployeeEntry.SQL_CREATE_ENTRIES)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
       //delete the current table
        db?.execSQL(GloboMedContract.EmployeeEntry.SQL_DROP_TABLE)
        //update
        onCreate(db)
    }

}