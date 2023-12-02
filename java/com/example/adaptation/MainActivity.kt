package com.example.adaptation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var adapter: ArrayAdapter<CharSequence>
    private var imgNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (imgNumber == 0) findViewById<ImageView>(R.id.picture).setImageResource(R.drawable.squarecat)

        adapter = ArrayAdapter.createFromResource(this, R.array.pictures, R.layout.item)
        val spinner = findViewById<Spinner>(R.id.pictures_list)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
    }

    fun onChangePictureClick(v: View) {
        val iv = findViewById<ImageView>(R.id.picture)

        imgNumber++
        when (imgNumber){
            1 -> iv.setImageResource(R.drawable.car2)
            2 -> iv.setImageResource(R.drawable.car3)
            3 -> iv.setImageResource(R.drawable.car1)
        }

        if (imgNumber == 3) imgNumber = 1
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "выбран элемент $position", Toast.LENGTH_SHORT ).show()
        val s = findViewById<Spinner>(R.id.pictures_list)
        val iv = findViewById<ImageView>(R.id.picture)
        when (s.getSelectedItem().toString()){
            "car 1" -> iv.setImageResource(R.drawable.car1)
            "car 2" -> iv.setImageResource(R.drawable.car2)
            "car 3" -> iv.setImageResource(R.drawable.car3)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "не выбран элемент", Toast.LENGTH_SHORT ).show()
    }
}