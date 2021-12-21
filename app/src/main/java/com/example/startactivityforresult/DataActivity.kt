package com.example.startactivityforresult

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class DataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_activity)

        val editText = findViewById<EditText>(R.id.editText)

        findViewById<Button>(R.id.buttonId).setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", editText.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}