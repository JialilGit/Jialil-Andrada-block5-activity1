package com.andrada.jialil.block5.p1.quiz


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class LoginFragment : Fragment() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log_in, container, false)

        usernameEditText = view.findViewById(R.id.editTextUsername)
        passwordEditText = view.findViewById(R.id.editTextPassword)

        val loginButton: Button = view.findViewById(R.id.buttonLogin)
        loginButton.setOnClickListener {
            login()
        }

        val signUpButton: Button = view.findViewById(R.id.buttonSignUp)
        signUpButton.setOnClickListener {
            navigateToSignUp()
        }

        return view
    }

    private fun login() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        val sharedPreferences =
            activity?.getPreferences(Context.MODE_PRIVATE) ?: return

        val savedUsername = sharedPreferences.getString("username", "")
        val savedPassword = sharedPreferences.getString("password", "")

        if (username == savedUsername && password == savedPassword) {
            // Successful login, navigate to another fragment or activity
            // For simplicity, let's just show a toast message for now
            showToast("Login successful!")
        } else {
            showToast("Invalid credentials")
        }
    }

    private fun navigateToSignUp() {
        val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment_container, SignUpFragment())
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }

    private fun showToast(message: String) {
        // Implement your toast message display here
    }
}
