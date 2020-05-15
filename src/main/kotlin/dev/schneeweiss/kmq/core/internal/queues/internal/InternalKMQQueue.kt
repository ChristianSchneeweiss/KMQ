package dev.schneeweiss.kmq.core.internal.queues.internal

import dev.schneeweiss.kmq.core.api.entities.*
import dev.schneeweiss.kmq.core.internal.FullMessage
import dev.schneeweiss.kmq.core.internal.SubscriptionImpl
import java.lang.Integer.max
import java.util.*
import kotlin.concurrent.thread

class InternalKMQQueue(private val maxLatency: Int) : KMQQueue {
    override val type: Type = Type.Internal()

    private val queue: LinkedList<FullMessage> = LinkedList()
    private val subscribers: MutableList<Subscriber> = mutableListOf()

    init {
        loop()
    }

    private fun loop() {
        thread(true, name = "Internal KMQ Queue Loop", isDaemon = true) {
            while (true) {
                if (queueSize() > 0) {
                    val message = queue.pop()
                    subscribers.filter { it.channel == message.channel }.forEach { it.handler(message.message) }
                } else {
                    Thread.sleep(max(1, maxLatency).toLong())
                }
            }
        }
    }

    private fun queueSize(): Long {
        return queue.size.toLong()
    }

    override fun subscribe(channel: Channel, handler: Message.() -> Unit): Subscription {
        val subscriber = Subscriber(channel, handler)
        subscribers.add(subscriber)
        return SubscriptionImpl(subscriber, this)
    }

    override fun publish(channel: Channel, message: Message) {
        queue.push(FullMessage(channel, message))
    }

    override fun publish(channel: Channel) {
        publish(channel, Message.EMPTY_MESSAGE)
    }

    override fun cancelSubscription(subscription: Subscription) {
        subscribers.remove(subscription.subscriber)
    }
}