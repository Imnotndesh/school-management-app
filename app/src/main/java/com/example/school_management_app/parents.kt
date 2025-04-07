package com.example.school_management_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ParentActivity : AppCompatActivity() {

    private lateinit var parentNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var studentNameEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parents)

        parentNameEditText = findViewById(R.id.editTextParentName)
        emailEditText = findViewById(R.id.editTextEmail)
        phoneEditText = findViewById(R.id.editTextPhone)
        studentNameEditText = findViewById(R.id.editTextStudentName)
        submitButton = findViewById(R.id.buttonSubmit)

        submitButton.setOnClickListener {
            val parentName = parentNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val studentName = studentNameEditText.text.toString().trim()

            if (parentName.isEmpty() || email.isEmpty() || phone.isEmpty() || studentName.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Simulate success/failure
                val success = true // change this based on your DB insert logic

                if (success) {
                    Toast.makeText(this, "Parent registered successfully", Toast.LENGTH_SHORT).show()

                    // Return to home or another page (uncomment and update intent)
                    // val intent = Intent(this, HomeActivity::class.java)
                    // startActivity(intent)
                    // finish()
                } else {
                    Toast.makeText(this, "Failed to register parent", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
