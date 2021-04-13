package edu.rockvalleycollege.apppreferences

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.txtEmail) as EditText
        val preferences = getSharedPreferences ("data", Context.MODE_PRIVATE)
        et1.setText (preferences.getString ("mail", ""))
        val button1 = findViewById<Button>(R.id.btnSubmit) as Button
        button1.setOnClickListener {
            val editor = preferences.edit ()
            editor.putString ("mail", et1.text.toString())
            editor.commit()
            // finish()
        }
        findViewById<View>(android.R.id.content).setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }
    }
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            //TODO: handle exception
        }
    }
}







