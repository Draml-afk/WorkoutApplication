package com.bignerdranch.android.workoutapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {


    lateinit var text_name : TextView
    lateinit var  button_nav : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        text_name = findViewById(R.id.name)
        button_nav = findViewById(R.id.bottom)

        button_nav.setOnItemSelectedListener(this)

        text_name.text = DESCRIPTION



    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).run {
            setTitle("Вы уверены что хотите выйти из приложения?")
            setNegativeButton("Нет"){_, _ -> return@setNegativeButton}
            setPositiveButton("Да"){ _, _ -> super.onBackPressed()}
        }.create().show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return  when(item.itemId){

            R.id.home -> {text_name.text = "" ;true}
            R.id.info -> {text_name.text = DESCRIPTION; true}
            R.id.next -> {val intent = Intent(this, CheckBoxActivity::class.java)
                startActivity(intent); true }
            else -> false
        }
    }

companion object{
    const val DESCRIPTION = "MENU \n BOTTOM NAVIGATION VIEW"
}

}