package com.example.listview

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.adapter.TestAdapter

class MainActivity : AppCompatActivity() {
    var list: ArrayList<TestBean> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        var adapter = TestAdapter(this)
        val listView = findViewById<ListView>(R.id.list_view)

        for (i in 0..20) {
            val bean = TestBean()
            if (i == 0 || i == 3 || i == 6) {
                bean.type = 1
            }
            if (i == 1 || i == 4 || i == 7) {
                bean.type = 2
            }
            if (i == 2 || i == 5 || i == 8) {
                bean.type = 3
            }
            list.add(bean)
        }
        adapter.setData(list)
        listView.adapter = adapter

    }
}