package com.example.androidfirstpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val id = "l2hyunwoo"
        val password = "l2hyunwoo"
        var registerText : String = "회원가입 하기"
        val contentText =  SpannableString(registerText)
        contentText.setSpan(UnderlineSpan(), 0, registerText.length, 0)
        tv_register.setText(contentText)

        btn_login.setOnClickListener{
            val text_id = et_mail.text.toString()
            val text_password = et_password.text.toString()

            if(text_id == id && text_password == password) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}