package com.jiwon.android_ethereum.api

import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService

typealias onWalletConnected = (Boolean) -> Unit

class WalletApi {
    private var isWallectConnected = false

    fun connect(
        key : String,
        onWalletConnected: onWalletConnected
    ){
        val httpService = HttpService("$URL/$key")
        val web3J = Web3j.build(httpService)

        try{
            val clientVersion = web3J.web3ClientVersion().sendAsync().get()
            isWallectConnected = !clientVersion.hasError()

            onWalletConnected(!clientVersion.hasError())
        }catch(e: Exception){
            onWalletConnected(false)
        }
    }



    companion object{
        const val URL = ""
        const val KEY = ""
    }
}