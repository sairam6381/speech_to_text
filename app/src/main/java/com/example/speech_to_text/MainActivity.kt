package com.example.speech_to_text

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var btMicon : Button
    lateinit var tvText: TextView
    private val REQUEST_CODE_SPEECH_INPUT = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btMicon= findViewById(R.id.btMicon)
        tvText=findViewById(R.id.tvText)
        btMicon.setOnClickListener{
            val intent= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hello speak!!!")
            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT)
        } }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == RESULT_OK && data != null) {
            var res =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            var text = res?.get(0)
            tvText.text = text
            }
        }
}