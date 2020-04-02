package sad.ru.rateconverter

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sad.ru.rateconverter.models.RateModel
import sad.ru.rateconverter.retrofit.DataService
import sad.ru.rateconverter.retrofit.RetrofitClientInstance
import sad.ru.rateconverter.view.CustomView

class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var customHandler: Handler
    private lateinit var rate: RateModel
    private var countRate: Double = 1.0

    private val PERMISSION_CODE = 101


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initAdMob()
        initHandler()
        initSpinner()
        initSpinnerSelect()
        initEditCount()
    }

    private fun initEditCount() {
        count_et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!p0.isNullOrEmpty()) {
                    countRate = p0.toString().toDouble()
                    initLinearWithParams()
                }
            }

        })
    }

    private fun initRetrofit() {
        val service: DataService =
            RetrofitClientInstance.retrofitInstance!!.create(DataService::class.java)
        Log.d("xyi", spinner_rate.selectedItem as String)
        val call: Call<RateModel> = service.getRates((spinner_rate.selectedItem as String))
        call.enqueue(object : Callback<RateModel> {
            override fun onResponse(call: Call<RateModel>, response: Response<RateModel>) {
                Log.d("xyi", call.toString() + "\n" + response.body())
                rate = response.body()!!
                initLinearWithParams()
            }

            override fun onFailure(call: Call<RateModel>, t: Throwable) {
                Log.d("xyi", t.message)
                Toast.makeText(spinner_rate.context, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun initLinearWithParams() {
        if (rate != null) {
            linear.removeAllViews()
            date_tv.text = "Last update: " + rate.date
            if (rate.rates.AUD != null) linear.addView(
                CustomView(
                    this,
                    "AUD",
                    (countRate * rate.rates.AUD!!).toString()
                )
            )
            if (rate.rates.BGN != null) linear.addView(
                CustomView(
                    this,
                    "BGN",
                    (countRate * rate.rates.BGN!!).toString()
                )
            )
            if (rate.rates.BRL != null) linear.addView(
                CustomView(
                    this,
                    "BRL",
                    (countRate * rate.rates.BRL!!).toString()
                )
            )
            if (rate.rates.CAD != null) linear.addView(
                CustomView(
                    this,
                    "CAD",
                    (countRate * rate.rates.CAD!!).toString()
                )
            )
            if (rate.rates.CHF != null) linear.addView(
                CustomView(
                    this,
                    "CHF",
                    (countRate * rate.rates.CHF!!).toString()
                )
            )
            if (rate.rates.CNY != null) linear.addView(
                CustomView(
                    this,
                    "CNY",
                    (countRate * rate.rates.CNY!!).toString()
                )
            )
            if (rate.rates.CZK != null) linear.addView(
                CustomView(
                    this,
                    "CZK",
                    (countRate * rate.rates.CZK!!).toString()
                )
            )
            if (rate.rates.DKK != null) linear.addView(
                CustomView(
                    this,
                    "DKK",
                    (countRate * rate.rates.DKK!!).toString()
                )
            )
            if (rate.rates.EUR != null) linear.addView(
                CustomView(
                    this,
                    "EUR",
                    (countRate * rate.rates.EUR!!).toString()
                )
            )
            if (rate.rates.GBP != null) linear.addView(
                CustomView(
                    this,
                    "GBP",
                    (countRate * rate.rates.GBP!!).toString()
                )
            )
            if (rate.rates.HKD != null) linear.addView(
                CustomView(
                    this,
                    "HKD",
                    (countRate * rate.rates.HKD!!).toString()
                )
            )
            if (rate.rates.HRK != null) linear.addView(
                CustomView(
                    this,
                    "HRK",
                    (countRate * rate.rates.HRK!!).toString()
                )
            )
            if (rate.rates.HUF != null) linear.addView(
                CustomView(
                    this,
                    "HUF",
                    (countRate * rate.rates.HUF!!).toString()
                )
            )
            if (rate.rates.IDR != null) linear.addView(
                CustomView(
                    this,
                    "IDR",
                    (countRate * rate.rates.IDR!!).toString()
                )
            )
            if (rate.rates.ILS != null) linear.addView(
                CustomView(
                    this,
                    "ILS",
                    (countRate * rate.rates.ILS!!).toString()
                )
            )
            if (rate.rates.INR != null) linear.addView(
                CustomView(
                    this,
                    "INR",
                    (countRate * rate.rates.INR!!).toString()
                )
            )
            if (rate.rates.ISK != null) linear.addView(
                CustomView(
                    this,
                    "ISK",
                    (countRate * rate.rates.ISK!!).toString()
                )
            )
            if (rate.rates.JPY != null) linear.addView(
                CustomView(
                    this,
                    "JPY",
                    (countRate * rate.rates.JPY!!).toString()
                )
            )
            if (rate.rates.KRW != null) linear.addView(
                CustomView(
                    this,
                    "KRW",
                    (countRate * rate.rates.KRW!!).toString()
                )
            )
            if (rate.rates.MXN != null) linear.addView(
                CustomView(
                    this,
                    "MXN",
                    (countRate * rate.rates.MXN!!).toString()
                )
            )
            if (rate.rates.MYR != null) linear.addView(
                CustomView(
                    this,
                    "MYR",
                    (countRate * rate.rates.MYR!!).toString()
                )
            )
            if (rate.rates.NOK != null) linear.addView(
                CustomView(
                    this,
                    "NOK",
                    (countRate * rate.rates.NOK!!).toString()
                )
            )
            if (rate.rates.NZD != null) linear.addView(
                CustomView(
                    this,
                    "NZD",
                    (countRate * rate.rates.NZD!!).toString()
                )
            )
            if (rate.rates.PHP != null) linear.addView(
                CustomView(
                    this,
                    "PHP",
                    (countRate * rate.rates.PHP!!).toString()
                )
            )
            if (rate.rates.PLN != null) linear.addView(
                CustomView(
                    this,
                    "PLN",
                    (countRate * rate.rates.PLN!!).toString()
                )
            )
            if (rate.rates.RON != null) linear.addView(
                CustomView(
                    this,
                    "RON",
                    (countRate * rate.rates.RON!!).toString()
                )
            )
            if (rate.rates.RUB != null) linear.addView(
                CustomView(
                    this,
                    "RUB",
                    (countRate * rate.rates.RUB!!).toString()
                )
            )
            if (rate.rates.SEK != null) linear.addView(
                CustomView(
                    this,
                    "SEK",
                    (countRate * rate.rates.SEK!!).toString()
                )
            )
            if (rate.rates.SGD != null) linear.addView(
                CustomView(
                    this,
                    "SGD",
                    (countRate * rate.rates.SGD!!).toString()
                )
            )
            if (rate.rates.THB != null) linear.addView(
                CustomView(
                    this,
                    "THB",
                    (countRate * rate.rates.THB!!).toString()
                )
            )
            if (rate.rates.TRY != null) linear.addView(
                CustomView(
                    this,
                    "TRY",
                    (countRate * rate.rates.TRY!!).toString()
                )
            )
            if (rate.rates.USD != null) linear.addView(
                CustomView(
                    this,
                    "USD",
                    (countRate * rate.rates.USD!!).toString()
                )
            )
            if (rate.rates.ZAR != null) linear.addView(
                CustomView(
                    this,
                    "ZAR",
                    (countRate * rate.rates.ZAR!!).toString()
                )
            )
        }
    }


    private fun initView() {
        setContentView(R.layout.activity_main)
    }

    private fun initHandler() {
        customHandler = Handler()
        customHandler.postDelayed(updateTimerThread, 0)
    }

    private fun initSpinner() {
        val adapter =
            ArrayAdapter.createFromResource(
                this,
                R.array.rates,
                R.layout.spinner_item
            )
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)

        spinner_rate.adapter = adapter
    }

    private fun initSpinnerSelect() {
        spinner_rate.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                initRetrofit()
            }

        }
    }

    private fun initTimerAdvise() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        mInterstitialAd.loadAd(AdRequest.Builder().addTestDevice("91CF873F530C958EBBC647EB3C5679F1").build())
    }

    private val updateTimerThread: Runnable = object : Runnable {
        override fun run() { //write here whaterver you want to repeat
            runOnUiThread {
                initTimerAdvise()
                customHandler.postDelayed(this, 60000)
            }
        }
    }

    private fun initAdMob() {
        MobileAds.initialize(this, "ca-app-pub-8154277548860310~1511286123")

        RequestConfiguration.Builder().setTestDeviceIds(
            listOf("91CF873F530C958EBBC647EB3C5679F1")
        ).build()

        val adRequest: AdRequest =
            AdRequest.Builder().addTestDevice("91CF873F530C958EBBC647EB3C5679F1").build()
        adView.loadAd(adRequest)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-8154277548860310/8116701854"
        mInterstitialAd.loadAd(AdRequest.Builder().addTestDevice("91CF873F530C958EBBC647EB3C5679F1").build())
    }

}
