package camplans.m8.a12_animacions_jbarrera

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        setContentView(R.layout.activity_splash)
        splashScreen.setKeepOnScreenCondition{false}

        val pelotaImageView: ImageView = findViewById(R.id.imageViewBall)

        val rotationAnimator = ObjectAnimator.ofFloat(pelotaImageView, "rotation", 0f, 360f)
        rotationAnimator.duration = 1000
        rotationAnimator.interpolator = AccelerateDecelerateInterpolator()
        rotationAnimator.repeatCount = ObjectAnimator.INFINITE

        val translationAnimator = ObjectAnimator.ofFloat(pelotaImageView, "translationY", 400f, 0f)
        translationAnimator.duration = 2000
        translationAnimator.interpolator = AccelerateDecelerateInterpolator()

        rotationAnimator.start()
        translationAnimator.start()

        translationAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                // Inicia l'Activity principal
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        })
    }
}