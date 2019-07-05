package com.gystry.wifisetting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mList: ArrayList<String>
    lateinit var adapter: WifiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mList = ArrayList()
        adapter = WifiAdapter(this, mList)
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = adapter
        btn_scan.setOnClickListener {
            //扫描wifi

        }
    }
}
