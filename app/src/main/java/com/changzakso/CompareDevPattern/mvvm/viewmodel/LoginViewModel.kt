package com.changzakso.CompareDevPattern.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.changzakso.CompareDevPattern.mvvm.model.User

class LoginViewModel : ViewModel() {

    private val user = User()

    /******************************************************/
    private val _isLoginSuccessFlag : MutableLiveData<Boolean> = MutableLiveData()
    val isLoginSuccessFlag: LiveData<Boolean>
        get() = _isLoginSuccessFlag

    private fun setIsLoginSuccessFlag(isLoginSuccess : Boolean){
        _isLoginSuccessFlag.postValue(isLoginSuccess)
    }
    /******************************************************/

    /******************************************************/
    val userName: String
        get() = user.userName.toString()

    fun login(userName: String, password: String){

        val isLoginSuccess : Boolean = user.login(userName, password)
        if(isLoginSuccess){
            setIsLoginSuccessFlag(true)
        }else{
            setIsLoginSuccessFlag(false)
        }
    }
    /******************************************************/
}