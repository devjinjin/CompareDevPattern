package com.changzakso.CompareDevPattern.mvc.model

import com.changzakso.CompareDevPattern.common.ConstCommon

data class User(
    var userName: String? = null,
    var password: String? = null
) {
    //비지니스 로직
    fun login(userName: String?, password: String?): Boolean {
        if (userName == ConstCommon.savedUserName && password == ConstCommon.savedPassword) {
            this.userName = userName
            this.password = password

            return true
        }
        return false

    }
}