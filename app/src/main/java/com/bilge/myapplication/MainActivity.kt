package com.bilge.myapplication

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity

import com.bilge.myapplication.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var fab: FloatingActionButton
    private lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //verknüpfungen
        fab = findViewById(R.id.floatingActionButton)
        editText = findViewById(R.id.editTextNumberDecimal)



        fab.setOnClickListener {
            val ageInYears = editText.text.toString().toIntOrNull()
            val message = if (ageInYears != null) {
                val ageInMinutes = ageInYears * 365 * 24 * 60
                "Your age in minutes is: $ageInMinutes"
            } else {
                "Please enter a valid age."
            }
            AlertDialog.Builder(this)
                .setTitle("Alter in Minuten")
                .setMessage(message)
                .setPositiveButton("Fertig") { dialog, _ -> dialog.dismiss() }
                .show()
        }

    }
}