package com.example.finalproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMadrid: RecyclerView
    private val list = ArrayList<Player>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvMadrid = findViewById(R.id.rv_madrid)
        rvMadrid.setHasFixedSize(true)
        list.addAll(getListPlayer())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

        private fun getListPlayer(): ArrayList<Player> {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listHero = ArrayList<Player>()
            for (i in dataName.indices) {
                val hero = Player(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
                listHero.add(hero)
            }
            return listHero
        }

        private fun showRecyclerList() {
            rvMadrid.layoutManager = LinearLayoutManager(this)
            val listPlayerAdapter = ListPlayerAdapter(list)
            rvMadrid.adapter = listPlayerAdapter
        }


}