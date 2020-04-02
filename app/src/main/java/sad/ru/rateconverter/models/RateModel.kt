package sad.ru.rateconverter.models

data class RateModel(
    val base: String,
    val date: String,
    val rates: Rates
)