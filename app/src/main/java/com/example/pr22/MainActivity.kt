package com.example.pr22

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity(), Fragment.OnSelectedButtonListener {
    private var mIsDynamic = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val fragment2 = fragmentManager
            .findFragmentById(R.id.fragment2) as Fragment2?
        mIsDynamic = fragment2 == null || !fragment2.isInLayout
        Toast.makeText(applicationContext, mIsDynamic.toString() + "", Toast.LENGTH_SHORT).show()
    }
    override fun onButtonSelected(buttonIndex: Int) {
        // подключаем FragmentManager
        val fragmentManager: FragmentManager = supportFragmentManager

        // Получаем ссылку на второй фрагмент по ID
        val fragment2 = fragmentManager.findFragmentById(R.id.fragment2) as Fragment2?

        // если фрагмента не существует или он невидим
        if (fragment2 == null || !fragment2.isVisible) {
            // запускаем активность
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("buttonIndex", buttonIndex)
            startActivity(intent)
        } else {
            // Выводим нужную информацию
            fragment2.setDescription(buttonIndex)
        }
    }
}