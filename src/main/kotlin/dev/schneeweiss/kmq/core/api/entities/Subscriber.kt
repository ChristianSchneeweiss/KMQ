package dev.schneeweiss.kmq.core.api.entities

data class Subscriber(val channel: Channel, val handler: Message.() -> Unit)