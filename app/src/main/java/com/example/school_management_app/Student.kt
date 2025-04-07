import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.school_management_app.R

class StudentFragment : Fragment() {
    private lateinit var nameInput: EditText
    private lateinit var admInput: EditText
    private lateinit var dobInput: EditText
    private lateinit var parentInput: EditText
    private lateinit var genderInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var classInput: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_student, container, false)

        nameInput = view.findViewById(R.id.studentName)
        admInput = view.findViewById(R.id.admNo)
        dobInput = view.findViewById(R.id.dob)
        parentInput = view.findViewById(R.id.parentName)
        genderInput = view.findViewById(R.id.gender)
        phoneInput = view.findViewById(R.id.phone)
        classInput = view.findViewById(R.id.className)

        val nextButton = view.findViewById<Button>(R.id.nextBtn)
        nextButton.setOnClickListener {
            val bundle = Bundle().apply {
                putString("student_name", nameInput.text.toString())
                putString("parent_name", parentInput.text.toString())
            }
            // TODO : ADD DB LOGIC

            val fragment = ParentFragment()
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.registrationFragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
