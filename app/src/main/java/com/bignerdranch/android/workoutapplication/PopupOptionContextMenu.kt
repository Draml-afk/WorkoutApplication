package com.bignerdranch.android.workoutapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class PopupOptionContextMenu : AppCompatActivity() {

    lateinit var popup : PopupMenu
    lateinit var text_popup : TextView
    lateinit var layout: ConstraintLayout
    lateinit var description : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_option_context_menu)

        text_popup = findViewById(R.id.text_popup)
        layout = findViewById(R.id.layout)
        description = findViewById(R.id.description)

        description.text = DESCRIPTION
        text_popup.text = "OptionMenu"

        registerForContextMenu(text_popup)


        popup = PopupMenu(this, text_popup)
        popup.inflate(R.menu.popup)
        text_popup.setOnClickListener{popup.show()}


        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.popup_click   -> {Snackbar.make(layout, "Click", Snackbar.LENGTH_LONG)
                                      .show(); true}
                R.id.popup_ofclick -> {Snackbar.make(layout, "Ofclick", Snackbar.LENGTH_LONG)
                                      .show(); true}

                else -> false
            }
        }



    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){

            R.id.context_create -> {Toast.makeText(this, "Create", Toast.LENGTH_LONG)
                .show(); true}
            R.id.context_delete -> {Toast.makeText(this, "Delete", Toast.LENGTH_LONG)
                .show(); true}

            else ->  super.onContextItemSelected(item)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.home -> {text_popup.text = ""; true}
            R.id.info -> {text_popup.text = "OptionMenu"; true}
            R.id.next -> {val intent = Intent(this, DrawerMenu::class.java)
                startActivity(intent); true}
            else -> return super.onOptionsItemSelected(item)
        }

    }


    companion object{
        val DESCRIPTION = "OPTION MENU \n CONTEXT MENU \n POPUP MENU"
    }



}