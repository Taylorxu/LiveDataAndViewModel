package com.xuzhiguang.livedataandeviewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.LiveData


/**
 * Created by Administrator on 2018/5/10.
 */
class MyViewModel : ViewModel() {
    private var users: MutableLiveData<List<User>>? = null

    fun getUsers(): LiveData<List<User>> {
        if (users == null) {
            users = MutableLiveData()
            loadUsers()
        }
        return users as MutableLiveData<List<User>>
    }

    //在这个方法中进行获取数据，耗时操作。在将数据给MutableLiveData
    private fun loadUsers() {
        val list = (1..10).map { User("这个名字有些怪${it}") }
        users?.value = list
    }

}

class User(var name: String)
