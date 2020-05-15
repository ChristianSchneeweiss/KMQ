package dev.schneeweiss.kmq.core.api.entities

interface Message {
    val messageTitle: String
    val payload: Any?

    companion object {
        val EMPTY_MESSAGE: Message = object :
            Message {
            override val messageTitle = "EMPTY_MESSAGE"
            override val payload: Any? = null
        }
    }
}