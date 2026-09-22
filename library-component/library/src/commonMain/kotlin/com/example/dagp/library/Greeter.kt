package com.example.dagp.library

import com.example.dagp.library2.GreeterModel

open class Greeter {
    open fun greet(model: GreeterModel): String = "Hello good $model!"
}

