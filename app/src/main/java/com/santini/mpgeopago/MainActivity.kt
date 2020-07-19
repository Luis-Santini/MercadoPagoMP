package com.santini.mpgeopago

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.santini.mpgeopago.databinding.ActivityMainBinding
import com.santini.mpgeopago.network.model.paymentMethods.PaymentMethods
import com.santini.mpgeopago.network.model.responseHadler.Resource
import com.santini.mpgeopago.ui.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            viewModel = this@MainActivity.viewModel
        }
        setContentView(binding.root)

        viewModel.paymentMethods.observe(this, Observer {
            // TODO :  create recycle to load. payment methods
        })
    }
}

