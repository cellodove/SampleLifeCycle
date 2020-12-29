package com.peter.changeactivity

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.peter.changeactivity.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setListener()
        Toast.makeText(this,"onCreate 호출",Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"onStart 호출",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume 호출",Toast.LENGTH_SHORT).show()
        restoreState()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause 호출",Toast.LENGTH_SHORT).show()
        saveState()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop 호출",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy 호출",Toast.LENGTH_SHORT).show()
    }

    private fun setListener() {
        var intent = Intent(this@MainActivity,MenuActivity::class.java)
        binding.apply {
            button.setOnClickListener {
                startActivityForResult(intent,0)
            }
        }
    }

    private fun restoreState(){
        var pref : SharedPreferences = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        if ((pref!=null)&&(pref.contains("name"))){
            var name : String? = pref.getString("name","")
            binding.nameInput.setText(name)
        }
    }

    private fun saveState(){
        var pref : SharedPreferences = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        var editor :SharedPreferences.Editor = pref.edit()
        editor.putString("name",binding.nameInput.text.toString())
        editor.commit()
    }

    private fun clearState(){
        var pref : SharedPreferences = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        var editor :SharedPreferences.Editor = pref.edit()
        editor.clear()
        editor.commit()
    }



}