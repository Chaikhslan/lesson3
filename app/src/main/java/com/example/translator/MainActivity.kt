package com.example.translator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.PopupMenu
import android.widget.Toast
import com.example.translator.ui.AlertFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView.setOnClickListener {
            val message = edit_text_sms.text.toString()
            if (message.isEmpty()){
                Toast.makeText(this, "Введите сообщения",Toast.LENGTH_LONG).show()
            } else sendMessage(message)
        }

        text_view.setOnClickListener {

            var dialog = AlertFragment()
            dialog.show(supportFragmentManager, "alertDialog")

//            val popupMenu = PopupMenu(this, it)
//            popupMenu.setOnMenuItemClickListener { item ->
//                when (item.itemId){
//                    R.id.menu_alert -> {
////                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://resoder.com"))
//                        startActivity(intent)
//                        true
//                    }
//                    R.id.menu_alert_toast -> {
//                        Toast.makeText(this,"Show Toast",Toast.LENGTH_LONG).show()
//                        true
//                    }
//                    else -> false
//                }
//            }
//            popupMenu.inflate(R.menu.alert_menu)
//            popupMenu.show()
        }
    }

    private fun sendMessage(message: String) {
        val str = message.toLowerCase()
        val uniArr = mutableListOf<String>()
        for (i in str.indices) {
            if (str[i] == 'ә') {
                uniArr.add("aʼ")
            }
            if (str[i] == 'л') {
                uniArr.add("l")
            }
            if (str[i] == 'е') {
                uniArr.add("e")
            }
            if (str[i] == 'м') {
                uniArr.add("m")
            }
            if (str[i] == ',') {
                uniArr.add(",")
            }
            if (str[i] == 'қ') {
                uniArr.add("q")
            }
            if (str[i] == ' ') {
                uniArr.add(" ")
            }
            if (str[i] == 'а') {
                uniArr.add("a")
            }
            if (str[i] == 'й') {
                uniArr.add("iʼ")
            }
            if (str[i] == 'с') {
                uniArr.add("s")
            }
            if (str[i] == 'ы') {
                uniArr.add("y")
            }
            if (str[i] == 'ң') {
                uniArr.add("ń")
            }
            if (str[i] == '?') {
                uniArr.add("?")
            }
            val text1 = uniArr.joinToString(separator = "")
            text_view.text = text1.capitalize()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }
}