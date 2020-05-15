package dev.schneeweiss.kmq.core.api.entities

interface Subscription {
    val subscriber: Subscriber
    val queue: KMQQueue

    fun cancel()
}
