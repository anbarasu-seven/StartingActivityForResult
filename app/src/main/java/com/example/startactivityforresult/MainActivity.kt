package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var textResult: TextView? = null
    private val GET_NAME_RESULT: Int = 100

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            val returnString: String? = data?.getStringExtra("name")
            textResult?.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById<TextView>(R.id.textResult)

        //approach 1
        /*findViewById<Button>(R.id.buttonId).setOnClickListener {
            getResultApproach1()
        }*/

        //approach 2
        findViewById<Button>(R.id.buttonId).setOnClickListener {
            getResultApproach2()
        }

    }

    private fun getResultApproach1() {
        val intent = Intent(this, DataActivity::class.java)
        startActivityForResult(intent, GET_NAME_RESULT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == GET_NAME_RESULT && resultCode == RESULT_OK) {
            val returnString: String? = data?.getStringExtra("name")
            textResult?.text = returnString
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


    private fun getResultApproach2() {
        val intent = Intent(this, DataActivity::class.java)
        resultLauncher.launch(intent)
    }




}