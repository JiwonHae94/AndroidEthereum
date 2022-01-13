package com.jiwon.android_ethereum.data

data class Rate(
    val rate : Double
)

enum class Node{
    /**
     * Retaining all historical data can trace arbitrary transactions
     * at any point in time.
     */
    Archive,

    /**
     * Retaining all historical data after initial sync can only trace
     * transactions from blocks following the initial sync point
     */
    FullSynced,

    /**
     * Retaining only periodic state data after initial sync can only
     * trace transactions from blocks following the initial sync point.
     */
    FastSynced,

    /**
     * Retrieving data on demand can in theory trace transactions for which
     * all required historical state is readily available in the network
     */
    LightSynced
}