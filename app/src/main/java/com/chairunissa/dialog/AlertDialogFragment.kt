package com.chairunissa.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar

class AlertDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alert_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.signup_button)
        val username = view.findViewById<EditText>(R.id.username_edit_text)
        button.setOnClickListener {
            val name = username.text.toString().trim()
            Toast.makeText(requireContext(), name, Toast.LENGTH_LONG).show()
//            Snackbar.make(view.findViewById(R.id.username_edit_text), name, Snackbar.LENGTH_SHORT).show()
            dialog?.dismiss()
        }
    }
}