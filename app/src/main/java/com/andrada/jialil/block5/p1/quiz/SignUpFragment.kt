package com.andrada.jialil.block5.p1.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class SignUpFragment : Fragment() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        usernameEditText = view.findViewById(R.id.editTextUsernameSignUp)
        passwordEditText = view.findViewById(R.id.editTextPasswordSignUp)

        val signUpButton: Button = view.findViewById(R.id.buttonSignUp)
        signUpButton.setOnClickListener {
            signUp()
        }

        return view
    }

    private fun signUp() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        val sharedPreferences =
            activity?.getPreferences(Context.MODE_PRIVATE) ?: return

        with(sharedPreferences.edit()) {
            putString("username", username)
            putString("password", password)
            apply()
        }

        // After signing up, you might want to navigate to the login fragment
        // For simplicity, let's just show a toast message for now
        showToast("Sign up successful!")
    }

    private fun showToast(message: String) {
        // Implement your toast message display here
    }
}
