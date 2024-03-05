package com.example.study4webflux.learn;

import reactor.core.publisher.Mono;

/**
 * 설명:
 *
 * @author Aldo / kwon.sy@dreamus.io
 * @since 2024/03/05
 */
public class TestMono {
    // TODO Return an empty Mono
    Mono<String> emptyMono() {
        return Mono.empty();
    }

    //========================================================================================

    // TODO Return a Mono that never emits any signal
    Mono<String> monoWithNoSignal() {
        return Mono.never();
    }

    //========================================================================================

    // TODO Return a Mono that contains a "foo" value
    Mono<String> fooMono() {
        return Mono.just("foo");
    }

    //========================================================================================

    // TODO Create a Mono that emits an IllegalStateException
    Mono<String> errorMono() {
        return Mono.error(new IllegalStateException());
    }
}
