package com.geektech.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textValue = intent.getStringExtra("text1")
        binding.edittext.setText(textValue)
        binding.button.setOnClickListener{
            if (binding.edittext.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Введите текст", Toast.LENGTH_SHORT)
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                setResult(RESULT_OK, intent)
                intent.putExtra("text", binding.edittext.text.toString())
                startActivity(intent)
            }
        }
    }
}