package com.example.latihanpropertyanimator

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var image: ImageView
    lateinit var btnRotate: Button
    lateinit var btnTranslate: Button
    lateinit var btnScale: Button
    lateinit var btnFade: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.image)
        btnRotate = findViewById(R.id.btnRotate)
        btnTranslate = findViewById(R.id.btnTranslate)
        btnScale = findViewById(R.id.btnScale)
        btnFade = findViewById(R.id.btnFade)

        btnRotate.setOnClickListener{
            rotateImage()
        }

        btnTranslate.setOnClickListener{
            translateImage()
        }

        btnScale.setOnClickListener{
            scaleImage()
        }

        btnFade.setOnClickListener{
            fadeImage()
        }
    }

    private fun rotateImage(){
        val animator = ObjectAnimator.ofFloat(image, View.ROTATION, -360f, 0f)
        animator.duration = 1500
        animator.disableViewDuringAnimation(btnRotate)
        animator.start()
    }

    private fun translateImage(){
        val animator = ObjectAnimator.ofFloat(image, View.TRANSLATION_X, 150f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(btnTranslate)
        animator.start()
    }

    private fun scaleImage(){
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(image, scaleX, scaleX)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(btnScale)
        animator.start()
    }

    private fun fadeImage(){
        val animator = ObjectAnimator.ofFloat(image, View.ALPHA, 0f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(btnFade)
        animator.start()
    }

    private fun ObjectAnimator.disableViewDuringAnimation(view: View){
        addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationStart(animation: Animator?) {
                view.isEnabled =false
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.isEnabled = true
            }
        })
    }

}