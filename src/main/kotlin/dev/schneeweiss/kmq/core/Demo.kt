package dev.schneeweiss.kmq.core

import dev.schneeweiss.kmq.core.api.KMQ
import dev.schneeweiss.kmq.core.api.entities.Channel
import dev.schneeweiss.kmq.core.api.entities.Type

fun main() {
    val queue = KMQ.queue(Type.Internal())
//    val queue = KMQ.queue(InternalQueueOptions(0))

    val subscription = queue.subscribe(Channel.DEFAULT) {
        println(messageTitle)
    }

    queue.publish(Channel.DEFAULT)
    queue.publish(Channel.DEFAULT)
    queue.publish(Channel.DEFAULT)

    Thread.sleep(50)

    subscription.cancel()

    queue.publish(Channel.DEFAULT)

    Thread.sleep(200)
}


