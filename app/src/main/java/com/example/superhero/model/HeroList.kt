package com.example.superhero.model

import com.example.superhero.R

object HeroList {
    val heroes = listOf(
        Hero(
            image = R.drawable.android_superhero1,
            name = R.string.hero1,
            description = R.string.description1,
            power = R.string.power1,
            skills = R.string.skills1,
            health = R.string.health1,
            icon1 = R.drawable.code_20px,
            icon2 = R.drawable.bedroom_baby_20px,
            icon3 = R.drawable.favorite_20px
        ),
        Hero(
            image = R.drawable.android_superhero2,
            name = R.string.hero2,
            description = R.string.description2,
            power = R.string.power2,
            skills = R.string.skills2,
            health = R.string.health2,
            icon1 = R.drawable.regular_expression_20px,
            icon2 = R.drawable.neurology_20px,
            icon3 = R.drawable.favorite_20px
        ),
        Hero(
            image = R.drawable.android_superhero3,
            name = R.string.hero3,
            description = R.string.description3,
            power = R.string.power3,
            skills = R.string.skills3,
            health = R.string.health3,
            icon1 = R.drawable.dns_20px,
            icon2 = R.drawable.elderly_20px,
            icon3 = R.drawable.favorite_20px
        ),
        Hero(
            image = R.drawable.android_superhero4,
            name = R.string.hero4,
            description = R.string.description4,
            power = R.string.power4,
            skills = R.string.skills4,
            health = R.string.health4,
            icon1 = R.drawable.web_20px,
            icon2 = R.drawable.neurology_20px,
            icon3 = R.drawable.favorite_20px
        ),
        Hero(
            image = R.drawable.android_superhero5,
            name = R.string.hero5,
            description = R.string.description5,
            power = R.string.power5,
            skills = R.string.skills5,
            health = R.string.health5,
            icon1 = R.drawable.database_20px,
            icon2 = R.drawable.elderly_20px,
            icon3 = R.drawable.favorite_20px
        ),
        Hero(
            image = R.drawable.android_superhero6,
            name = R.string.hero6,
            description = R.string.description6,
            power = R.string.power6,
            skills = R.string.skills6,
            health = R.string.health6,
            icon1 = R.drawable.smartphone_20px,
            icon2 = R.drawable.person_20px,
            icon3 = R.drawable.favorite_20px
        )
    )
}