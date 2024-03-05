package com.example.study4webflux.learn;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * 설명:
 *
 * @author Aldo / kwon.sy@dreamus.io
 * @since 2024/03/05
 */
public class TestFlux {
    // TODO Return an empty Flux
    Flux<String> emptyFlux() {
        return Flux.empty();
    }

    //========================================================================================

    // TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo", "bar");
    }

    //========================================================================================

    // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
    Flux<String> fooBarFluxFromList() {
        List<String> list = Arrays.asList("foo", "bar");
        return Flux.fromIterable(list);
    }

    //========================================================================================

    // TODO Create a Flux that emits an IllegalStateException
    Flux<String> errorFlux() {
        return Flux.error(new IllegalStateException());
    }

    //========================================================================================

    // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
    Flux<Long> counter() {
        return Flux.interval(Duration.ofMillis(100))
                .take(10);
    }

    @Test
    void Test_counter() {
        this.counter().subscribe(
                value -> System.out.println("Value: " + value),
                error -> System.out.println("Error: " + error),
                () -> System.out.println("Completed")
        );
        try {
            // Flux.interval 이 각 스레드에서 동작하므로 출력값을 보려면 기다려야 함
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted");
        }
    }

}
