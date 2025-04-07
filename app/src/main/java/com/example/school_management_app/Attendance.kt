import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.school_management_app.R

class AttendanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        val submitBtn = findViewById<Button>(R.id.btnSubmitAttendance)

        submitBtn.setOnClickListener {
            // Handle validation & DB saving here
            val success = true // simulate success

            if (success) {
                Toast.makeText(this, "Attendance submitted successfully", Toast.LENGTH_SHORT).show()
                // startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(this, "Failed to submit attendance", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
