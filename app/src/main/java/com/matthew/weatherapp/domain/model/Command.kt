package com.matthew.weatherapp.domain.model

/**
 * Created by Matthew on 18/09/2017.
 */
public interface Command<out T> {
    fun execute(): T
}