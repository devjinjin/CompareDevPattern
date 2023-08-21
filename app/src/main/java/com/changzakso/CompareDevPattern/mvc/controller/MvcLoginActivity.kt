package com.changzakso.CompareDevPattern.mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.changzakso.CompareDevPattern.databinding.ActivityMvcBinding
import com.changzakso.CompareDevPattern.mvc.model.User

class MvcLoginActivity : AppCompatActivity() {
    private val binding: ActivityMvcBinding by lazy {
        ActivityMvcBinding.inflate(layoutInflater)
    }

    private lateinit var user : User
    //뷰바인딩

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰바인딩
        setContentView(binding.root)
        //뷰바인딩

        user = User()

        binding.included.loginBtn.setOnClickListener{
            val isLoginSuccess = user.login(
                binding.included.etUserName.text.toString(),
                binding.included.etPassword.text.toString()
            )

            if (isLoginSuccess) {
                Toast.makeText(
                    this@MvcLoginActivity,
                    "${binding.included.etUserName.text.toString()} 로그인 성공",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(this@MvcLoginActivity, "${binding.included.etUserName.text.toString()} 로그인 실패", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
    /*
    *
    * mvc  패텅에서 model과 view가 완저히 분리 되므로 model은 쉽게 테스트 가능
    * 컨트롤러가 안드로이드에 종속이 되기때문에 테스트가 어려워짐
    * 안드로이드 특성상 액티비티가 View 표시와 Controller 역할을 같이 수행 해야하기때문에 두요소의 결합도가 높아짐
    * 많은 코드가 Controller로 모이게 되어 액티비티가 비대해짐
    *
    * */
    
}