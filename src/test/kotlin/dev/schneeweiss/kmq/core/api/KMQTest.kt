package dev.schneeweiss.kmq.core.api

import dev.schneeweiss.kmq.core.api.entities.Type
import dev.schneeweiss.kmq.core.internal.queues.internal.InternalKMQQueue
import dev.schneeweiss.kmq.core.internal.queues.internal.InternalQueueProvider
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class KMQTest {

    @Test
    fun assertInternalQueueIsInstantiated() {
        KMQ.registerQueueProvider(InternalQueueProvider())

        val queue =
            KMQ.queue(Type.Internal())
        assertTrue(queue is InternalKMQQueue)
    }
}