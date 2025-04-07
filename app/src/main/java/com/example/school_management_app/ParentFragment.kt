import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.school_management_app.R

class ParentFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_parent, container, false)

        val parentName = view.findViewById<EditText>(R.id.parentName)
        val email = view.findViewById<EditText>(R.id.email)
        val phone = view.findViewById<EditText>(R.id.phone)
        val studentName = view.findViewById<EditText>(R.id.studentName)

        // Autofill
        parentName.setText(arguments?.getString("parent_name"))
        studentName.setText(arguments?.getString("student_name"))

        view.findViewById<Button>(R.id.submitBtn).setOnClickListener {
            // TODO : ADD DB ENTRY LOGIC

            Toast.makeText(requireContext(), "Registration Complete", Toast.LENGTH_LONG).show()
            requireActivity().finish()
        }
        // TODO : Also add something that takes me back to the main processes page
        return view
    }
}
