package dev.schneeweiss.kmq.core.api.entities

sealed class Type {
    abstract val name: String

    data class Internal(override val name: String = "Internal") : Type()
}