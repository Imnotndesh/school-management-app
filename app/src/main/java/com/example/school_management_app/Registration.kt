package com.example.school_management_app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
        val switchRegistration: Switch = findViewById<Switch>(R.id.switchRegistration)
        val teachFields: LinearLayout = findViewById<LinearLayout>(R.id.teacherFields)
        val adminFields: LinearLayout = findViewById<LinearLayout>(R.id.adminFields)
        val registerButton: Button = findViewById<Button>(R.id.registerButton)
        switchRegistration.setOnCheckedChangeListener { _, isChecked ->
            teachFields.visibility = if (isChecked) View.VISIBLE else View.GONE
            adminFields.visibility = if (isChecked) View.GONE else View.VISIBLE
        }
        registerButton.setOnClickListener{
            if (switchRegistration.isChecked){
                val teacherName = findViewById<EditText>(R.id.teacherName).text.toString()
                val email = findViewById<EditText>(R.id.teacherEmail).text.toString()
                val subjects = findViewById<EditText>(R.id.teacherSubjects).text.toString()
                val phone = findViewById<EditText>(R.id.teacherPhone).text.toString()
                val className = findViewById<EditText>(R.id.teacherClassName).text.toString()
                val username = findViewById<EditText>(R.id.teacherUsername).text.toString()
                val password = findViewById<EditText>(R.id.teacherPassword).text.toString()
                // TODO: add the above TO DB
            }else{
                val adminName = findViewById<EditText>(R.id.adminName).text.toString()
                val adminPassword = findViewById<EditText>(R.id.adminPassword).text.toString()
                // TODO: add the above TO DB
            }
            // TODO : IF ABOVE SUCCESSFUL SET A WAY TO CACHE KEY OR SAVE LOGIN FOR LATER USE THAT EXPIRES AFTER A WHILE
        }
    }
}