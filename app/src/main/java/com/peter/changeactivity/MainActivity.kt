package com.peter.changeactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.peter.changeactivity.databinding.ActivityMainBinding
import com.peter.changeactivity.MenuActivity

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_MENU : Int = 101
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setListener()
    }

    private fun setListener() {

        binding.button.setOnClickListener {
            var intent = Intent(this, MenuActivity::class.java)
            startActivityForResult(intent,REQUEST_CODE_MENU)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_MENU){
            Toast.makeText(this, "onActivityResult 메서드 호출됨. 요청코드 :$requestCode 결과코드:$resultCode", Toast.LENGTH_SHORT).show()
        }
        if (resultCode== RESULT_OK){
            var name : String? = data?.getStringExtra("name")
            Toast.makeText(this, "응답으로 전달된 name:$name",Toast.LENGTH_SHORT).show()
        }
    }

}