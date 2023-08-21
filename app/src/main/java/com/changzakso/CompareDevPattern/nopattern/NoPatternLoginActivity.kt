package com.changzakso.CompareDevPattern.nopattern

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.changzakso.CompareDevPattern.common.ConstCommon
import com.changzakso.CompareDevPattern.databinding.ActivityNoPatternLoginBinding

class NoPatternLoginActivity : AppCompatActivity() {

    //뷰바인딩
    private val binding: ActivityNoPatternLoginBinding by lazy {
        ActivityNoPatternLoginBinding.inflate(layoutInflater)
    }
    //뷰바인딩

    var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰바인딩
        setContentView(binding.root)
        //뷰바인딩

        binding.included.loginBtn.setOnClickListener {
            val isLoginSuccess = login(
                binding.included.etUserName.text.toString(),
                binding.included.etPassword.text.toString()
            )

            if (isLoginSuccess) {
                Toast.makeText(
                    this@NoPatternLoginActivity,
                    "${binding.included.etUserName.text.toString()} 로그인 성공",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(this@NoPatternLoginActivity, "${binding.included.etUserName.text.toString()} 로그인 실패", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun login(userName: String?, password: String?): Boolean {

        return userName.let {
            password.let {
                userName == ConstCommon.savedUserName && password == ConstCommon.savedPassword
            }
        }
    }
}