package com.example.theatreapp.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/*
class DBHelper(context: Context, dbName: String, dbVersion: Int) :
    SQLiteOpenHelper(context, dbName, null, dbVersion) {

    override fun onCreate(db: SQLiteDatabase) {
        // Здесь выполняется создание таблиц базы данных
        db.execSQL("CREATE TABLE IF NOT EXISTS my_table (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, value INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Здесь обрабатываются изменения схемы базы данных при обновлении версии
        db.execSQL("DROP TABLE IF EXISTS my_table") // Удаление старой таблицы (осторожно!)
        onCreate(db) // Создание новой таблицы
    }
}*/
