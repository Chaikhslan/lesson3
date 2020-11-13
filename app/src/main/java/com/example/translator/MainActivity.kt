package com.example.translator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
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
            val timeView: TextView = text_recyclerView.findViewById(R.id.text_recyclerView) as TextView
            timeView.text = text1.capitalize()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

}