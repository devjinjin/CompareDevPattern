package com.changzakso.CompareDevPattern.mvp.view

interface MvpLoginView {
    val userName: String?
    val password: String?

    fun onLoginResult(isLoginSuccess: Boolean?)
}