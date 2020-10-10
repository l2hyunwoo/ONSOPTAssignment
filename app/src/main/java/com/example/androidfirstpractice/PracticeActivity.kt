package com.example.androidfirstpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class PracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)
        val nullOrString1 : String? = null
        val nullOrString2 : String? = "지지지지베베베베베베베"
        val stringSequence = "Apple, Bananana, Kiwi"
        val nameList = listOf("David", "Alice", "Steven", "Simpson", "Amy", "Bob", "Frankenstein")

        val list1 = listOf("1", "2", "3")
        Log.d("Intro", "${nullOrString1?.length}")
        //Log.d("Intro", "${nullOrString1!!.length}")
        Log.d("Intro", "${nullOrString2?.length}")
        Log.d("Intro2", "${nullOrString1?.length ?: -1}")
        Log.d("Intro2", "${nullOrString2?.length ?: -1}")
        Log.d("Intro2", "${nullOrString2?.length ?: -1}")
        equationRoot(1.0, 2.0, 1.0)
        equationRoot(1.0, 2.0, 13.0)
        equationRoot(1.0, 2.0, -3.0)
        Log.d("Intro3", "${nullOrString2.getLength()}")
        Log.d("Intro4", nameList.findEInList().toString())
        val answer = stringSequence.parseString(",")
        Log.d("Intro4", "${answer}")
        val parent = Parent("이현우", 24)
        val child = Child("이현우 자식", 15, true)
        parent.say()
        parent.introduce()
        child.say()
        child.introduce()

    }

    private fun String?.getLength() : Int {
        return this!!.length
    }

    private fun String.parseString(param : String) : MutableList<String>?{
        var listOfString : MutableList<String>? = mutableListOf()
        var tempString : String = ""
        for(item in this.indices){
            if(this[item] == ',') {
                listOfString?.add(tempString)
                tempString = ""
            }
            else {
                tempString += this[item]
            }
            if(item == this.length - 1){
                if(tempString != "")
                    listOfString?.add(tempString)
            }
        }

        return listOfString
    }

    private fun equationRoot(a: Double, b:Double, c:Double) {
        if(b*b - 4*a*c < 0)
            Log.d("IntroR", "해가 없습니다")
        else if(b*b - 4*a*c == 0.0) {
            val root = (-b + Math.sqrt(b*b - 4*a*c))/(2*a)
            Log.d("IntroR", "중근입니다")
            Log.d("IntroR", "근: $root")
        }
        else {
            val root1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a)
            val root2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a)
            Log.d("IntroR", "근1: $root1")
            Log.d("IntroR", "근2: $root2")
        }
    }

    private fun List<String>.findEInList() : Int {
        var count = 0
        for (person in this) {
            if(person.contains('e'))
                count++
        }
        return count
    }

}

open class Parent(var name : String, var age : Int) {
    open fun say() {
        Log.d("Intro", "Hello")
    }
    fun introduce() {
        Log.d("Intro", "I'm $name and I'm $age years old")
    }
}

class Child(name: String, age: Int, isCute : Boolean) : Parent(name, age) {
    override fun say() {
        Log.d("Intro", "Hello I'm Child")
    }

}