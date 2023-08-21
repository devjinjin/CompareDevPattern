package com.changzakso.CompareDevPattern

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.changzakso.CompareDevPattern.mvc.controller.MvcLoginActivity
import com.changzakso.CompareDevPattern.mvp.view.MvpLoginActivity
import com.changzakso.CompareDevPattern.mvvm.view.MvvmLoginActivity
import com.changzakso.CompareDevPattern.nopattern.NoPatternLoginActivity
import com.changzakso.CompareDevPattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //뷰바인딩
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    //뷰바인딩

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        binding.buttonNoPattern.setOnClickListener(this)
        binding.buttonMVC.setOnClickListener(this)
        binding.buttonMVP.setOnClickListener(this)
        binding.buttonMVVM.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.buttonNoPattern -> startActivity(Intent(this, NoPatternLoginActivity::class.java))
                R.id.buttonMVC -> startActivity(Intent(this, MvcLoginActivity::class.java))
                R.id.buttonMVP -> startActivity(Intent(this, MvpLoginActivity::class.java))
                R.id.buttonMVVM -> startActivity(Intent(this, MvvmLoginActivity::class.java))
            }
        }
    }
}