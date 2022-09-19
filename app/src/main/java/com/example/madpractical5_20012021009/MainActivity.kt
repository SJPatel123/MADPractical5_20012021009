package com.example.madpractical5_20012021009

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.madpractical5_20012021009.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var fabplay : FloatingActionButton
    private lateinit var fabpause : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabplay = findViewById(R.id.play)
        fabplay.setOnClickListener(View.OnClickListener{
            play()
        })

        fabpause = findViewById(R.id.pause)
        fabpause.setOnClickListener(View.OnClickListener {
            stop()
        })
    }
    private fun play(){
        Intent(applicationContext,MediaService::class.java).putExtra(MediaService.DATA_KEY,MediaService.DATA_VALUE).apply {
            startService(this)
        }
    }
    private fun stop(){
        Intent(applicationContext,MediaService::class.java).apply {
            stopService(this)
        }
    }
}