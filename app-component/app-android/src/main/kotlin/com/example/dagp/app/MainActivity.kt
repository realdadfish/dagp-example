package com.example.dagp.app

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.dagp.library.Greeter
import com.example.dagp.library2.GreeterModel

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TextView(this).apply { text = MyGreeter().goodMorning() })
    }
}

class MyGreeter : Greeter() {
    fun goodMorning(): String = super.greet(GreeterModel.MORNING)
}
