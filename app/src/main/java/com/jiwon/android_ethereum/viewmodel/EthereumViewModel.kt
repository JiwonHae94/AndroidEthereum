package com.jiwon.android_ethereum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EthereumViewModel : ViewModel() {
    val dollar = MutableLiveData( 1.0)
    val ethereum = MutableLiveData(1.0)
    val rate = 1.0

    fun convert(){

    }
}