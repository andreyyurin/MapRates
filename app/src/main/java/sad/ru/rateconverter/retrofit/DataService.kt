package sad.ru.rateconverter.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import sad.ru.rateconverter.models.RateModel


interface DataService {
    @GET("/latest")
    fun getRates(@Query("base") rate: String): retrofit2.Call<RateModel>
}