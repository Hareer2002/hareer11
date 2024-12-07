package com.example.now

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var db: DB_Sqlite = DB_Sqlite(this)
    var name: EditText? = null
    var ID: EditText? = null
    var password: EditText? = null
    var list: ListView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById<View>(R.id.editText_name) as EditText
        password = findViewById<View>(R.id.editText_password) as EditText
        ID = findViewById<View>(R.id.editText_id) as EditText
        list = findViewById<View>(R.id.listview_data) as ListView
        showdata()
    }

    fun btn_add(view: View?) {
        val Name = name!!.text.toString()
        val Password = password!!.text.toString()
        val result: Boolean = db.insertdata(Name, Password)
        if (result == true) {
            Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_SHORT).show()
            name!!.setText("")
            password!!.setText("")
            showdata()
        } else {
            Toast.makeText(this@MainActivity, "No", Toast.LENGTH_SHORT).show()
        }
    }

    fun showdata() {
        val listData: ArrayList<String?> = db.getallrecord()
        val arrayAdapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, R.layout.simple_list_item_1, listData)
        list!!.adapter = arrayAdapter
    }

    fun btn_update(view: View?) {
        val Name = name!!.text.toString()
        val Password = password!!.text.toString()
        val id = ID!!.text.toString()
        val result: Boolean = db.updateData(id, Name, Password)
        if (result == true) {
            Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_SHORT).show()
            name!!.setText("")
            password!!.setText("")
            ID!!.setText("")
            showdata()
        } else {
            Toast.makeText(this@MainActivity, "No", Toast.LENGTH_SHORT).show()
        }
    }

    fun btn_delete(view: View?) {
        val id = ID!!.text.toString()
        val result: Int = db.Delete(id)
        if (result > 0) {
            Toast.makeText(this@MainActivity, "تم الحذف بنجاح", Toast.LENGTH_SHORT).show()
            ID!!.setText("")
            showdata()
        } else {
            Toast.makeText(this@MainActivity, "لا توجد بيانات", Toast.LENGTH_SHORT).show()
        }
    }
}