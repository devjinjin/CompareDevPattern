package com.changzakso.CompareDevPattern.mvvm.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.changzakso.CompareDevPattern.databinding.ActivityMvvmBinding
import com.changzakso.CompareDevPattern.mvvm.viewmodel.LoginViewModel

/*
* mvvm pattern
* 
* view와 model 사이에 의존성이 없으며, ViewModel도 View에 의존성을 가지지 않음
* 참조는 View -> ViewModel -> Model 순으로 단반향으로만 일어남
* */
class MvvmLoginActivity : AppCompatActivity() {
    private val binding: ActivityMvvmBinding by lazy {
        ActivityMvvmBinding.inflate(layoutInflater)
    }
    //뷰바인딩

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰바인딩
        setContentView(binding.root)
        //뷰바인딩

        binding.included.loginBtn.setOnClickListener {
            loginViewModel.login(
                binding.included.etUserName.text.toString(),
                binding.included.etPassword.text.toString()
            )
        }

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        loginViewModel.isLoginSuccessFlag.observe(this, loginObserver)
    }

    private val loginObserver = Observer<Boolean> { isLoginSuccess ->
        if (isLoginSuccess == true) {
            Toast.makeText(
                this@MvvmLoginActivity,
                "${this.loginViewModel.userName} 로그인 성공",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                this@MvvmLoginActivity,
                "${this.loginViewModel.userName}  로그인 실패",
                Toast.LENGTH_LONG
            )
                .show()
        }
    }
}