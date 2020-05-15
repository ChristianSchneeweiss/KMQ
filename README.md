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

## Download

Current version is available at [https://github.com/ChristianSchneeweiss/KMQ/releases/download/0.1.0/core-0.1.0.jar](https://github.com/ChristianSchneeweiss/KMQ/releases/download/0.1.0/core-0.1.0.jar).

In general versions are available at the Github release page.
