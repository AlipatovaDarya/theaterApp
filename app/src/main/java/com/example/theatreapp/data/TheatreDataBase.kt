package com.example.theatreapp.data

import android.content.ContentValues
import android.content.Context

/*
class TheatreDatabase(context: Context) {
    private val dbHelper = DBHelper(context, "my_database", 1)

    fun insertData(name: String, value: Int): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("value", value)
        }
        return db.insert("my_table", null, values)
    }

    fun getData(): List<Map<String, Any?>> {
        val db = dbHelper.readableDatabase
        val cursor = db.query("my_table", null, null, null, null, null, null)
        val dataList = mutableListOf<Map<String, Any?>>()
        while (cursor.moveToNext()) {
            val dataMap = mutableMapOf<String, Any?>()
            dataMap["id"] = cursor.getInt(cursor.getColumnIndex("id"))
            dataMap["name"] = cursor.getString(cursor.getColumnIndex("name"))
            dataMap["value"] = cursor.getInt(cursor.getColumnIndex("value"))
            dataList.add(dataMap)
        }
        cursor.close()
        return dataList
    }

    // ... функции updateData и deleteData аналогично
}*/
