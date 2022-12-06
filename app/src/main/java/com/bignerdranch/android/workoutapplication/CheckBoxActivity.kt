package com.bignerdranch.android.workoutapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class CheckBoxActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {


    lateinit var checkBox: CheckBox
    lateinit var text_check : TextView
    lateinit var text_info: TextView
    lateinit var botton : BottomNavigationView

    var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)

        checkBox = findViewById(R.id.check_box)
        text_check = findViewById(R.id.text_check)
        text_info = findViewById(R.id.text_info)
        botton = findViewById(R.id.bottom)

        savedInstanceState?.apply {
            count = getInt(KYE_TEXT_CHECK)
        }


        text_check.text = "$TEXT_UP_COUNT \n ${count.toString()}"
        checkBox.setOnClickListener{
            if(checkBox.isChecked)  count++
            text_check.text =  "$TEXT_UP_COUNT \n ${count.toString()}"
        }


            botton.setOnItemSelectedListener(this)





    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return  when(item.itemId){
            R.id.home -> {text_info.text = ""; true}
            R.id.info -> {text_info.text = CHECK; true}
            R.id.next -> {val intent = Intent(this, PopupOptionContextMenu::class.java)
                         startActivity(intent); true}

            else -> false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KYE_TEXT_CHECK, count)
        super.onSaveInstanceState(outState)
    }

    companion object{
        const val TEXT_UP_COUNT = "СЧЁТЧИК"
        const val CHECK = "CHECK \n СОХРАНЯЕМ ДАННЫЕ ПРИ ПОВОРОТЕ ЭКРАНА"
        const val KYE_TEXT_CHECK = "key_1"
    }


}