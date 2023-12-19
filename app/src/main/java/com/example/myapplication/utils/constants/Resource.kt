package com.example.myapplication.utils.constants

sealed class Resource<out R> {
    class Success<out T>(val data: T) : Resource<T>()
    class Error(val exception: String, val data: Any? = null) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}