package com.bam.roomexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.bam.roomexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.floatingBtn.setOnClickListener{

            val navHost = Navigation.findNavController(this, R.id.nav_host_fragment)
            navHost.navigate(R.id.action_userListFragment_to_userCreateFragment)
        }

    }
}