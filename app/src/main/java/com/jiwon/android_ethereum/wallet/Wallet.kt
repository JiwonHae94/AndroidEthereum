package com.jiwon.android_ethereum.wallet

import org.web3j.crypto.WalletUtils
import java.io.File
import android.util.Log
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.tx.Transfer
import java.math.BigDecimal
import org.web3j.utils.Convert

class Wallet(
    val service : Web3j
) {
    var walletDir = File(WalletPath)
    val walletName = WalletUtils.generateLightNewWalletFile(password, walletDir).apply{
        walletDir = File(WalletPath, this)
    }
    var credential : Credentials? = null

    internal fun load(){
        try{
            credential = WalletUtils.loadCredentials(password, walletDir)
            Log.i("Wallet", "Wallet address is ${credential?.address}")
        }catch(e: Exception){
            Log.e("Wallet", "error found in ${e.localizedMessage}")
        }
    }

    internal fun transaction(
        address : String,
        convertUnit : Convert.Unit
    ) : TransactionReceipt? {
        credential ?: let{
            Log.w("Transaction", "transcation made without proper credential")
            return@let
        }

        try{
            val transaction = Transfer.sendFunds(
                service,
                credential!!,
                address,
                BigDecimal(1),
                convertUnit
            )
            val receipt = transaction.sendAsync().get()

        }catch(e: Exception){
            Log.e("Transaction" , "transaction error ${e.localizedMessage}")
        }

        return null
    }

    companion object{
        const val password = ""
        const val WalletPath = ""

    }
}