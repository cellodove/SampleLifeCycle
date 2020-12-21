package com.peter.changeactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.peter.changeactivity.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_menu)

        setListener()
    }

    private fun setListener() {
        binding.apply {
            back.setOnClickListener {
                var intent = Intent()
                intent.putExtra("name","mike")
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}