package sad.ru.rateconverter

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var customHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        customHandler = Handler()
        customHandler.postDelayed(startNewActivity, 1000)
    }

    private val startNewActivity: Runnable = Runnable {
        val intent = Intent(this, MainActivity::class.java)
        //
        startActivity(intent)
        runFadeInAnimation()
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    private fun runFadeInAnimation() {
        overridePendingTransition(R.anim.fadein, android.R.anim.fade_out)
    }
}