package com.jiwon.android_ethereum.wallet

import android.util.Log
import com.jiwon.android_ethereum.api.InfuraAPI
import junit.framework.TestCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService

/**
 * reference
 * https://github.com/web3j/sample-project-gradle/blob/master/src/main/java/org/web3j/sample/Application.java
 */
class WalletTest {
    private val TAG = WalletTest::class.java.simpleName

    @Test
    fun testLoadWallet(){
        try{
            CoroutineScope(Dispatchers.IO).launch {
                val web3j = Web3j.build(HttpService(InfuraAPI.Url + InfuraAPI.Token))
                println("Connected to Ethereum client version: ${web3j.web3ClientVersion().send().web3ClientVersion}")
                Log.d(TAG, "Connected to Ethereum client version: ${web3j.web3ClientVersion().send().web3ClientVersion}")
            }
        }catch(e: Exception){
            println("test web3j failed ${e.localizedMessage}")
        }
    }

}