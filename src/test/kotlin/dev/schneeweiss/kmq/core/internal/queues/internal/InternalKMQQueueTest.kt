package dev.schneeweiss.kmq.core.internal.queues.internal

import dev.schneeweiss.kmq.core.api.entities.Channel
import dev.schneeweiss.kmq.core.api.entities.Message
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class InternalKMQQueueTest {
    private val queue = InternalKMQQueue(0)

    @Test
    fun assertMessageIsReceived() {
        queue.subscribe(Channel.DEFAULT) {
            assertEquals(Message.EMPTY_MESSAGE, this)
        }

        queue.publish(Channel.DEFAULT)
        Thread.sleep(50)
    }

    @Test
    fun assertSubscriptionIsCancelled() {
        var count = 0
        val subscription = queue.subscribe(Channel.DEFAULT) {
            count++
        }

        subscription.cancel()

        queue.publish(Channel.DEFAULT)
        Thread.sleep(50)
        assertEquals(0, count)
    }
}