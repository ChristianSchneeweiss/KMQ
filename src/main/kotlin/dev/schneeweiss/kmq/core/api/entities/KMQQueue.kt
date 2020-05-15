package dev.schneeweiss.kmq.core.api.entities

interface KMQQueue {
    val type: Type

    fun subscribe(channel: Channel, handler: Message.() -> Unit): Subscription
    fun publish(channel: Channel, message: Message)
    fun publish(channel: Channel)

    fun cancelSubscription(subscription: Subscription)
}