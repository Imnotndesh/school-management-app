import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.school_management_app.R

class ClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)

        val submitBtn = findViewById<Button>(R.id.btnSubmitClass)

        submitBtn.setOnClickListener {
            val success = true // simulate

            if (success) {
                Toast.makeText(this, "Class created successfully", Toast.LENGTH_SHORT).show()
                // startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(this, "Failed to create class", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
