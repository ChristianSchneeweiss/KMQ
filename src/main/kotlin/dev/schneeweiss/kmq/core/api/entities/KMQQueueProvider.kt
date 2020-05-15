package dev.schneeweiss.kmq.core.api.entities

abstract class KMQQueueProvider {
    abstract val type: Type
    abstract fun instantiateQueue(options: Options): KMQQueue
}