# Kotlin Message Queue

Lightweight message queue system implemented in Kotlin, easy to create own message queue and not use the internal one.

## Usage

### Internal Queue

The easiest way to use the message queue without any customisation.

```
    val queue = KMQ.queue(Type.Internal())
    val subscription = queue.subscribe(Channel.DEFAULT) {
        println(messageTitle)
    }

    queue.publish(Channel.DEFAULT)
```
