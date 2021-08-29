package com.view.fintech.page

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.NetworkImageView
import com.view.fintech.R
import com.view.fintech.unit.VolleySingletion
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DetailActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val mtext = findViewById(R.id.textView) as TextView
        var mimg = findViewById(R.id.image) as NetworkImageView
        val mtitle = findViewById(R.id.title) as TextView
        val mcontent = findViewById(R.id.mcontent) as TextView
        val date = intent.getStringExtra("date")
        val image = intent.getStringExtra("image")
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("yyyy MMM dd", Locale.ENGLISH)
        val output = formatter.format(parser.parse(date))

        mtext.text = output
        mimg.setImageUrl(image, VolleySingletion.imageLoader)
        mtitle.text = title
        mcontent.text = content
    }

}