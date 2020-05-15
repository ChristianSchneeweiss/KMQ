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

JAR is available at [https://kmq.s3.fr-par.scw.cloud/core-0.1.0.jar](https://kmq.s3.fr-par.scw.cloud/core-0.1.0.jar).

In general versions are available at `https://kmq.s3.fr-par.scw.cloud/core-<VERSION>.jar`.
