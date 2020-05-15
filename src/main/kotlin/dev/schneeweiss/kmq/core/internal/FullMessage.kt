package dev.schneeweiss.kmq.core.internal

import dev.schneeweiss.kmq.core.api.entities.Channel
import dev.schneeweiss.kmq.core.api.entities.Message

data class FullMessage(val channel: Channel, val message: Message)