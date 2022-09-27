package com.example.applicationnotes

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationnotes.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityMainBinding

    private var mWidth: Int? = null
    private var mHeight: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportActionBar?.hide()

        mBinding.cardAnotacoes.setOnClickListener(this)
        mBinding.cardEstudos.setOnClickListener(this)
        mBinding.cardMusicas.setOnClickListener(this)
        mBinding.cardSeries.setOnClickListener(this)

        val metrics = DisplayMetrics()
        val result = windowManager
        //verificar versão do android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            //verificar e pegar tamanho da tela
            mWidth = result.currentWindowMetrics.bounds.width()
            mHeight = result.currentWindowMetrics.bounds.height()
        } else {
            result.defaultDisplay.getRealMetrics(metrics)
            mWidth = metrics.widthPixels
            mHeight = metrics.heightPixels
        }

        val imageLogo = mBinding.imagemLogo
        val conteinerCategorias = mBinding.conteinerCategorias

        conteinerCategorias.y = (mHeight!! * 0.6).toFloat()

        imageLogo.y = (mHeight!! * 0.25).toFloat()
        imageLogo.scaleX = (mHeight!! * 0.0006).toFloat()
        imageLogo.scaleY = (mHeight!! * 0.0006).toFloat()

        Handler(Looper.getMainLooper()).postDelayed({
            //bloco executado depois de 2 segundos
            conteinerCategorias.animate().duration = 500
            conteinerCategorias.animate().yBy(-(mHeight!! * 0.6).toFloat())

            imageLogo.animate().duration = 500
            imageLogo.animate().yBy(-(mHeight!! * 0.25).toFloat())
            imageLogo.animate().scaleX((mHeight!! * 0.0005).toFloat())
            imageLogo.animate().scaleY((mHeight!! * 0.0005).toFloat())

        }, 2000) // = 2 segundos
    }

    override fun onClick(view: View) {
        if(view.id == R.id.card_anotacoes){
            startActivity(Intent(this, AnotacoesActivity::class.java))
        } else if (view.id == R.id.card_estudos){
            startActivity(Intent(this, EstudosActivity::class.java))
        } else if (view.id == R.id.card_musicas){
            startActivity(Intent(this, MusicasActivity::class.java))
        } else if (view.id == R.id.card_series){
            startActivity(Intent(this, SeriesActivity::class.java))
        }
    }
}


