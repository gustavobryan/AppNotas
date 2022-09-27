package com.example.applicationnotes

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationnotes.databinding.ActivityAnotacoesBinding

class AnotacoesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityAnotacoesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAnotacoesBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.home.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.home) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}