package com.changzakso.CompareDevPattern.mvp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.changzakso.CompareDevPattern.databinding.ActivityMvpBinding
import com.changzakso.CompareDevPattern.mvp.presenter.LoginPresenterImpl

/*
* MVP Pattern
* 
* view와 model 사이의 데이터 흐름이 사라지고 presenter가 중간에서 데이터 흐름을 제어
* 인터페이스를 추가로 구현해야하기 때문에 구현비용이 올라가게됨
* view와 presenter가 1:1로 대응해야 하기 때문에 앱이커질수록 두요소의 의존성이 강해지게 됨
* */
class MvpLoginActivity : AppCompatActivity(), MvpLoginView {
    //뷰바인딩
    private val binding: ActivityMvpBinding by lazy {
        ActivityMvpBinding.inflate(layoutInflater)
    }
    //뷰바인딩

    //presenter
    private lateinit var loginPresenterImpl: LoginPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰바인딩
        setContentView(binding.root)
        //뷰바인딩

        loginPresenterImpl = LoginPresenterImpl(this)
        binding.included.loginBtn.setOnClickListener {
            loginPresenterImpl.login()
        }
    }

    override val userName: String?
        get() = binding.included.etUserName.text.toString()

    override val password: String?
        get() = binding.included.etPassword.text.toString()

    override fun onLoginResult(isLoginSuccess: Boolean?) {
        if (isLoginSuccess == true) {
            Toast.makeText(
                this@MvpLoginActivity,
                "${binding.included.etUserName.text.toString()} 로그인 성공",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                this@MvpLoginActivity,
                "${binding.included.etUserName.text.toString()} 로그인 실패",
                Toast.LENGTH_LONG
            )
                .show()
        }
    }
}