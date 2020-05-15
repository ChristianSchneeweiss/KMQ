package dev.schneeweiss.kmq.core.internal

import dev.schneeweiss.kmq.core.api.entities.KMQQueue
import dev.schneeweiss.kmq.core.api.entities.Subscriber
import dev.schneeweiss.kmq.core.api.entities.Subscription

class SubscriptionImpl(override val subscriber: Subscriber, override val queue: KMQQueue) :
    Subscription {

    override fun cancel() {
        queue.cancelSubscription(this)
    }
}