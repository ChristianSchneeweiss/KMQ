package dev.schneeweiss.kmq.core.internal.queues.internal

import dev.schneeweiss.kmq.core.api.entities.KMQQueue
import dev.schneeweiss.kmq.core.api.entities.KMQQueueProvider
import dev.schneeweiss.kmq.core.api.entities.Options
import dev.schneeweiss.kmq.core.api.entities.Type
import dev.schneeweiss.kmq.core.api.queueoptions.InternalQueueOptions

class InternalQueueProvider : KMQQueueProvider() {
    override val type: Type = Type.Internal()

    private val defaultOptions = InternalQueueOptions()

    override fun instantiateQueue(options: Options): KMQQueue {
        if (options is InternalQueueOptions) return InternalKMQQueue(
            options.latency
        )
        return InternalKMQQueue(defaultOptions.latency)
    }
}