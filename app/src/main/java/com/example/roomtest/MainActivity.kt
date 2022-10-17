package com.example.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.roomtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDataBase.getDataBase(this)
        db.getDao().getAllItem().asLiveData().observe(this){list ->
            binding.tvList.text = ""
            list.forEach {
                val text = "Id: ${it.id} Name: ${it.name} Price: ${it.price}\n"
                binding.tvList.append(text)
            }

        }
        binding.btnSave.setOnClickListener {
            val item = Item(null,
                binding.etName.text.toString(),
                binding.etPrice.text.toString()
            )
            Thread{
                db.getDao().insetrItem(item)
            }.start()
        }
    }
}