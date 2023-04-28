package com.example.superhero.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superhero.R

data class  Hero(
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val power: Int,
    @StringRes val skills: Int,
    @StringRes val health: Int,
    @DrawableRes val icon1: Int,
    @DrawableRes val icon2: Int,
    @DrawableRes val icon3: Int
)