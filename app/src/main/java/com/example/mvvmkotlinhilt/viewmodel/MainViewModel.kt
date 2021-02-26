package com.example.mvvmkotlinhilt.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmkotlinhilt.User
import com.example.mvvmkotlinhilt.repository.Repository
import com.example.mvvmkotlinhilt.utility.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val repository: Repository): ViewModel() {
    private val userList = MutableLiveData<Resource<List<User>>>()

    init {
      fetchUserList()
    }

    fun fetchUserList(){
        viewModelScope.launch (Dispatchers.IO){
            userList.postValue(Resource.loading(null))
            repository.getUserList().let {
                if (it.isSuccessful){
                    userList.postValue(Resource.success(it.body()))
                }
            }
        }
    }
    fun getUsers(): MutableLiveData<Resource<List<User>>> {
        return userList
    }
}