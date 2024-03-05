package com.example.study4webflux.learn;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 설명:
 *
 * @author Aldo / kwon.sy@dreamus.io
 * @since 2024/03/05
 */
public class TestTransform {
    // TODO Capitalize the user username, firstname and lastname
    @Test
    void testCapitalizeOne() {
        Mono<User> userMono = capitalizeOne(Mono.just(User.SAUL));
        userMono.subscribe(user -> System.out.println(user));
    }
    Mono<User> capitalizeOne(Mono<User> mono) {
        return mono.map(user -> new User(user.username().toUpperCase(), user.firstname().toUpperCase(), user.lastname().toUpperCase()));
    }

    //========================================================================================

    // TODO Capitalize the users username, firstName and lastName
    @Test
    void testCapitalizeMany() {
        Flux<User> userFlux = capitalizeMany(Flux.just(User.JESSE, User.WALTER));
        userFlux.subscribe(user -> System.out.println(user));
    }
    Flux<User> capitalizeMany(Flux<User> flux) {
        return flux.map(user -> new User(user.username().toUpperCase(), user.firstname().toUpperCase(), user.lastname().toUpperCase()));
    }

    //========================================================================================

    // TODO Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
    @Test
    void testAsyncCapitalizeMany() {
        Flux<User> userFlux = capitalizeMany(Flux.just(User.JESSE, User.WALTER));
        userFlux.subscribe(user -> System.out.println(user));
    }
    Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        return flux.flatMap(user -> asyncCapitalizeUser(user));
    }

    Mono<User> asyncCapitalizeUser(User u) {
        return Mono.just(new User(u.username().toUpperCase(), u.firstname().toUpperCase(), u.lastname().toUpperCase()));
    }
}
