package com.example.study4webflux.learn;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * 설명:
 *
 * @author Aldo / kwon.sy@dreamus.io
 * @since 2024/03/05
 */
public class TestStepVerifier {
    // TODO Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then completes successfully.
    @Test
    void TestFooBarComplete() {
        expectFooBarComplete(Flux.just("foo", "bar"));
//        expectFooBarComplete(Flux.just("foo", "bar2"));
    }
    void expectFooBarComplete(Flux<String> flux) {
        StepVerifier.create(flux)
                .expectNext("foo")
                .expectNext("bar")
                .verifyComplete();
    }

    //========================================================================================

    // TODO Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then a RuntimeException error.
    @Test
    void TestFooBarError() {
        expectFooBarError(Flux.just("foo", "bar")
                .concatWith(Flux.error(new RuntimeException())));
//        expectFooBarError(Flux.just("foo", "bar"));
    }
    void expectFooBarError(Flux<String> flux) {
        StepVerifier.create(flux)
                .expectNext("foo")
                .expectNext("bar")
                .expectError(RuntimeException.class)
                .verify();
    }

    //========================================================================================

    // TODO Use StepVerifier to check that the flux parameter emits a User with "swhite"username
    // and another one with "jpinkman" then completes successfully.
    @Test
    void TestSkylerJesseComplete() {
        expectSkylerJesseComplete(Flux.just(User.SKYLER, User.JESSE));
//        expectSkylerJesseComplete(Flux.just(User.SKYLER, User.WALTER));
    }
    void expectSkylerJesseComplete(Flux<User> flux) {
        StepVerifier.create(flux)
                .expectNextMatches(user -> User.SKYLER.username().equals(user.username()))
                .expectNextMatches(user -> User.JESSE.username().equals(user.username()))
                .verifyComplete();
    }

    //========================================================================================

    // TODO Expect 10 elements then complete and notice how long the test takes.
    @Test
    void Test10Elements() {
        expect10Elements(Flux.interval(Duration.ofMillis(100)).take(10));
        //        expectSkylerJesseComplete(Flux.just(User.SKYLER, User.WALTER));
    }
    void expect10Elements(Flux<Long> flux) {
        System.out.println(StepVerifier.create(flux)
                .expectNextCount(10)
                .verifyComplete()
                .getSeconds());

    }

    //========================================================================================

    // TODO Expect 3600 elements at intervals of 1 second, and verify quicker than 3600s
    // by manipulating virtual time thanks to StepVerifier#withVirtualTime, notice how long the test takes
    @Test
    void Test3600Elements() {
        Supplier<Flux<Long>> fluxSupplier = () -> Flux.interval(Duration.ofSeconds(1)).take(3600);
        expect3600Elements(fluxSupplier);
        //        expectSkylerJesseComplete(Flux.just(User.SKYLER, User.WALTER));
    }
    void expect3600Elements(Supplier<Flux<Long>> supplier) {
        System.out.println(StepVerifier.withVirtualTime(supplier)
                .thenAwait(Duration.ofSeconds(3600))
                .expectNextCount(3600)
                .verifyComplete()
                .getSeconds());
    }

    private void fail() {
        throw new AssertionError("workshop not implemented");
    }

}
