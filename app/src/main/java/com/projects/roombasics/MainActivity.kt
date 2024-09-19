package com.projects.roombasics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.projects.roombasics.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactDAO = DBHelper.getInstance(this)

        val viewModel = ViewModelProvider(this,ContactViewModelFactory(contactDAO))[ContactViewModel::class.java]

        viewModel.contacts.observe(this){ contacts->
            binding.tvValue.text = contacts[0].name
        }

        //go to app inspector -> database inspector to check entries
        viewModel.insertContact(Contact(0,"gsfad","4365764764"))

    }
}