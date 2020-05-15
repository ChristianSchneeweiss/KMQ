package dev.schneeweiss.kmq.core.api

import dev.schneeweiss.kmq.core.api.entities.KMQQueue
import dev.schneeweiss.kmq.core.api.entities.KMQQueueProvider
import dev.schneeweiss.kmq.core.api.entities.Options
import dev.schneeweiss.kmq.core.api.entities.Type
import dev.schneeweiss.kmq.core.internal.KMQQueueFactory

object KMQ {
    fun queue(type: Type): KMQQueue {
        return KMQQueueFactory.instantiate(
            Options(
                type
            )
        )
    }

    fun queue(options: Options): KMQQueue {
        return KMQQueueFactory.instantiate(options)
    }

    fun registerQueueProvider(provider: KMQQueueProvider) {
        KMQQueueFactory.registerProvider(provider)
    }
}