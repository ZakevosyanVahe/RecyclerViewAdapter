package com.vmd.homework.source

import com.vmd.homework.model.Person

class PersonList {
    fun loadPerson(): List<Person> = listOf(
        Person(1,"Vahe", 22),
        Person(2,"Aram", 30),
        Person(3,"Karen", 41),
        Person(4,"Anna", 28),
        Person(5,"Garik", 18),
        Person(6,"Maria", 26)
    )
}