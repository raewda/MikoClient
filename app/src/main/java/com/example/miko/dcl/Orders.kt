package com.example.miko.dcl

import com.example.miko.R

open class Orders(
    val id: Int,
    val orderName: String,
    val orderCode: Int,
    val orderImage: Int,
    val orderCharacter: String,
    val orderTransport: Int,
    val orderStatus: Boolean
){

    object onee : Orders(0,"one", 1, R.drawable.fox,"oneoneone", 28, false)
    object twoo : Orders(1,"two", 2, R.drawable.fox,"twotwotwo", 26, true)
    object threee : Orders(2,"three", 3, R.drawable.fox,"threethreethree", 30, false)

    companion object{

        val ordersAll = listOf(
            onee, twoo, threee
        )

        fun getById(id: Int): Orders {
            ordersAll.forEach() { el ->
                if (el.id == id) return el
            }
            return onee
        }
    }
}
