import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.school_management_app.R

class ExamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)

        val submitBtn = findViewById<Button>(R.id.btnSubmitExam)

        submitBtn.setOnClickListener {
            val success = true // simulate

            if (success) {
                Toast.makeText(this, "Exam data submitted successfully", Toast.LENGTH_SHORT).show()
                // startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(this, "Failed to submit exam data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
