package com.xuzhiguang.livedataandeviewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // 创建观察者，并更新 UI
    var userObserver: Observer<List<User>> = Observer {
        //it 为List<User>
        if (it != null) {
            for (User in it) {
                var textView = TextView(this)
                textView.text = User.name
                content_layout.addView(textView)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//获取ViewModel
        var model: MyViewModel = ViewModelProviders.of(this).get(MyViewModel().javaClass)
        //Observe the LiveData, passing in this activity as the LifecycleOwner and the observer
        //观察 这个 LiveData， 参数为 这个activity 的生命周期 和 观察者
        model.getUsers().observe(this, userObserver)


    }

}
