package com.example.mb22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mb22.databinding.ActivityMainBinding
import kotlin.random.Random
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newGame()
    }
    private fun newGame(){
        binding.etUserWord.text?.clear()
        val sWord = getWord()
        val mixed = sWord.toCharArray().let{
            it.shuffle()
            it.concatToString()
        }

        binding.tvScrambledText.text = mixed

        binding.button.setOnClickListener {
            val userWord = binding.etUserWord.text.toString() ?: ""
            if (userWord.equals(sWord)) {
                Toast.makeText(this, "Well done!", Toast.LENGTH_SHORT).show()
                newGame()
            } else {
                Toast.makeText(this, "Try better!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun getWord(): String {
        val words = resources.getStringArray(R.array.words)
        return words[Random.nextInt(words.size)]
    }
}