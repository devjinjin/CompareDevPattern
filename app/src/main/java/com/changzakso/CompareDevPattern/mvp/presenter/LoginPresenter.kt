package com.changzakso.CompareDevPattern.mvp.presenter

import com.changzakso.CompareDevPattern.mvc.model.User

interface LoginPresenter {
    val user : User

    fun login()
}