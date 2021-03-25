package com.example.gmbn.adapter

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import org.ocpsoft.prettytime.PrettyTime
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs
import kotlin.math.ln
import kotlin.math.pow

class CustomBindingAdapter {

    companion object {

        @BindingAdapter("setCover")
        @JvmStatic
        fun setCoverImg(view: ImageView, url: String?) {
            url?.let{
                Glide.with(view.context).load(it).into(view)
            }
        }

        fun setViewsCount(views: String?): String?{
            return views?.let {
                formatNumber(views) + " views"
            }
        }

        fun formatNumber(number: String?): String? {
            return number.let{
                val count = it!!.toLong()
                if (count < 1000) return "" + count
                val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
                String.format("%.1f%c", count / 1000.0.pow(exp.toDouble()), "kmgtpe"[exp - 1])
            }
        }

        @SuppressLint("SimpleDateFormat")
        fun setPublishTime(publishedAt: String?): String? {
            return publishedAt?.let { pubTime ->
                val prettyTime = PrettyTime()
                val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                sdf.timeZone = TimeZone.getTimeZone("GMT")
                val time = sdf.parse(pubTime)!!.time
                prettyTime.format(Date(time))
            }
        }

        fun setDuration(duration: String?): String? {
            return duration?.let {
                getFormattedTimeString(TimeUnit.MILLISECONDS.toSeconds(Duration.parse(it).toMillis()))
            }
        }

        fun getFormattedTimeString(timeInSeconds: Long?): String {
            var timeStr: String? = ""
            timeInSeconds?.let { seconds ->
                val secTime: Long = 1
                val minTime = 60 * secTime
                val hourTime = 60 * minTime
                var result = abs(seconds)

                val hour = (result / hourTime).toInt()
                result %= hourTime
                val min = (result / minTime).toInt()
                result %= minTime
                val sec = (result / secTime).toInt()

                if (seconds < 0) {
                    timeStr = "-"
                }
                if (hour > 0) {
                    timeStr += hour.toString() + "h "
                }
                if (min > 0) {
                    timeStr += min.toString() + "m "
                }
                if (sec > 0) {
                    timeStr += sec.toString() + "s "
                }
            }
            return timeStr ?: ""
        }


    }
}