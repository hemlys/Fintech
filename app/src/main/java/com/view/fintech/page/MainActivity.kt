package com.view.fintech.page

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.view.fintech.*
import com.view.fintech.adapter.CardAdapter
import com.view.fintech.bean.dadabean
import com.view.fintech.bean.dadabeanItem
import com.view.fintech.unit.VolleySingletion


class MainActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        shwoDiaglog()
        this.initView()
        this.sendRequest()

    }


    lateinit var main_page_gridview: GridView

    fun initView() {
        main_page_gridview = this.findViewById(R.id.main_page_gridview) as GridView
    }

    fun loadData(movieList: ArrayList<dadabeanItem>) {
        main_page_gridview.numColumns = 4
        main_page_gridview.adapter = CardAdapter(this,movieList)
        main_page_gridview.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("date",movieList.get(position).date)
            intent.putExtra("image",movieList.get(position).url)
            intent.putExtra("title",movieList.get(position).title)
            intent.putExtra("content",movieList.get(position).description)
            startActivity(intent)
        }

    }

   lateinit var progressDialog: ProgressDialog

    fun shwoDiaglog() {
        progressDialog = ProgressDialog(this)
        progressDialog.show()
    }

    fun cancleDialog() {
        progressDialog.dismiss()
    }

    fun loadToast(content: String?) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }


    fun sendRequest() {
        var url = "https://raw.githubusercontent.com/cmmobile/NasaDataSet/main/apod.json"
        val request = StringRequest(url, Response.Listener<String> {
            response ->
            var movilist = Gson().fromJson(response, dadabean::class.java)
            loadData(movilist)
            cancleDialog()

        }, Response.ErrorListener {
            error ->
            loadToast(error.message)
            cancleDialog()
        })
        VolleySingletion.requestQueque.add(request)
    }
}
