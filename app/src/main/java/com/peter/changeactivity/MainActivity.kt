package com.peter.changeactivity

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.peter.changeactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setListener()
    }

    private fun setListener() {
        binding.apply {
            var data : String = callNum.text.toString()
            button.setOnClickListener {
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse(data))
                startActivity(intent)
            }

            button2.setOnClickListener {
                var intent = Intent()
                var name : ComponentName = ComponentName("com.peter.changeactivity","com.peter.changeactivity.MenuActivity")
                intent.component = name
                startActivityForResult(intent,101)
            }

        }
    }
}