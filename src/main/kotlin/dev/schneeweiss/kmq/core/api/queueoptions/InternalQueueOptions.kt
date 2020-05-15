package dev.schneeweiss.kmq.core.api.queueoptions

import dev.schneeweiss.kmq.core.api.entities.Options
import dev.schneeweiss.kmq.core.api.entities.Type

data class InternalQueueOptions(val latency: Int = 30) : Options(
    Type.Internal()
)