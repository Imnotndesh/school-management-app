package com.example.school_management_app

import StudentFragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentRegistration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_registration)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.registrationFragmentContainer, StudentFragment())
                .commit()
        }
    }
}