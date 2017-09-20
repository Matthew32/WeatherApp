package com.matthew.weatherapp.domain.commands

interface Command<out T> {
    fun execute(): T
}