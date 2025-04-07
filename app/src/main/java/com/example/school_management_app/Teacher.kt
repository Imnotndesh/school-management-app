package com.example.school_management_app
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


import androidx.appcompat.app.AppCompatActivity

class TeacherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        val submitBtn = findViewById<Button>(R.id.btnSubmitTeacher)

        submitBtn.setOnClickListener {
            val success = true // simulate

            if (success) {
                Toast.makeText(this, "Teacher added successfully", Toast.LENGTH_SHORT).show()
                // startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(this, "Failed to add teacher", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
