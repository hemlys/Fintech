package com.view.fintech.unit

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley


object  VolleySingletion{

    private lateinit  var context:Context

    val  requestQueque :RequestQueue by lazy {
        Volley.newRequestQueue(context)
    }

    val  imageLoader :ImageLoader by lazy {
        // 不需要调用  new  关键字才创建对象
        ImageLoader(requestQueque, LruBtimapCache() )
    }

    fun  initConfi(context:Context){
        VolleySingletion.context =context.applicationContext
    }


}
