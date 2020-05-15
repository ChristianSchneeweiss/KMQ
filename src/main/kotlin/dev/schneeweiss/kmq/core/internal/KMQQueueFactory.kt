package dev.schneeweiss.kmq.core.internal

import dev.schneeweiss.kmq.core.api.entities.KMQQueue
import dev.schneeweiss.kmq.core.api.entities.KMQQueueProvider
import dev.schneeweiss.kmq.core.api.entities.Options
import dev.schneeweiss.kmq.core.api.entities.Type
import dev.schneeweiss.kmq.core.internal.queues.internal.InternalQueueProvider

object KMQQueueFactory {
    private val providers: MutableMap<Type, KMQQueueProvider> = mutableMapOf()

    init {
        registerProvider(InternalQueueProvider())
    }

    fun instantiate(options: Options): KMQQueue {
        return providers[options.type]?.instantiateQueue(options)
            ?: throw NoQueueProviderRegistered("No provider registered for ${options.type}")
    }

    fun registerProvider(provider: KMQQueueProvider) {
        providers[provider.type] = provider
    }
}