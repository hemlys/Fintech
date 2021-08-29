package com.view.fintech.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.android.volley.toolbox.NetworkImageView
import com.view.fintech.R
import com.view.fintech.unit.VolleySingletion
import com.view.fintech.bean.dadabeanItem

class CardAdapter constructor(private val context: Context, private val images:  ArrayList<dadabeanItem>) :  BaseAdapter() {

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView

        if (view == null) {
            val layoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.grid_item, parent, false)
        }


        val name = view?.findViewById(R.id.text)as TextView
        var img = view?.findViewById(R.id.image) as NetworkImageView
        var  adapter=this@CardAdapter
//        img.setDefaultImageResId(R.mipmap.ic_launcher)
//        img.setErrorImageResId(R.mipmap.ic_launcher)
        img.setImageUrl(adapter.images.get(position).url, VolleySingletion.imageLoader)
        name.text = images.get(position).title
        return view
    }

}