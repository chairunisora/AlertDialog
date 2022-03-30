package com.chairunissa.dialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var standardDialogButton: Button
    private lateinit var actionDialogButton: Button
    private lateinit var customDialogButton: Button
    private lateinit var closedButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        standardDialogButton = findViewById(R.id.standard_dialog_button)
        actionDialogButton = findViewById(R.id.action_dialog_button)
        customDialogButton = findViewById(R.id.custom_dialog_button)


        standardDialogButton.setOnClickListener {
            standardDialog()
        }

        actionDialogButton.setOnClickListener {
            actionDialog()
        }
        customDialogButton.setOnClickListener {
            customDialog()
        }
    }

    private fun standardDialog(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Cancelable")
        dialog.setMessage("Dialog cancelable bisa ditutup dengan klik bagian luar dialog")
        dialog.setCancelable(true)
        dialog.show()
    }

    private fun actionDialog(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Dengan Button")
        dialog.setMessage("Dialog Dengan Button untuk berbagai Aksi")
        dialog.setIcon(R.mipmap.ic_launcher)

        dialog.setCancelable(true)
        dialog.setPositiveButton("Positive Button") { dialogInterface, p1 ->
            Toast.makeText(this, "Positive Button Clicked", Toast.LENGTH_LONG).show()
        }

        dialog.setNegativeButton("Negative Button") { dialogInterface, p1 ->
            Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_LONG).show()
        }

        dialog.setNeutralButton("Neutral Button") { dialogInterface, p1 ->
            Toast.makeText(this, "Neutral Button Clicked", Toast.LENGTH_LONG).show()
        }

        dialog.show()
    }

    private fun customDialog(){

        val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)
        closedButton = view.findViewById(R.id.closed_button)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(view)

        val dialog = dialogBuilder.create()

        closedButton.setOnClickListener {
            Toast.makeText(this, "Custom Dialog Closed", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
    }
}