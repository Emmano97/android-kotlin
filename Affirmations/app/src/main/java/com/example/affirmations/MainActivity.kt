package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource
import com.example.affirmations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        val view = binding.root
        //binding.totalAffirmations.text = Datasource().loadAffirmations().size.toString()
        setContentView(view)

        val affirmations = Datasource().loadAffirmations()

        val recyclerView = binding.recyclerView

        recyclerView.adapter = ItemAdapter(this, affirmations)

        recyclerView.setHasFixedSize(true)
    }
}