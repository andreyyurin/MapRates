package sad.ru.rateconverter.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.IdRes
import kotlinx.android.synthetic.main.custom_view.view.*
import sad.ru.rateconverter.R

class CustomView @JvmOverloads constructor(
    context: Context,
    name: String,
    value: String,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    @IdRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {
    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view, this, true)
        name_tv.text = name
        value_tv.text = value
    }
}