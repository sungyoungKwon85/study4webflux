package com.example.study4webflux.learn;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 설명:
 *
 * @author Aldo / kwon.sy@dreamus.io
 * @since 2024/03/05
 */
public class TestMerge {
    // Flux1: A, B, C...
    // Flux2: 1, 2, 3...
    // 이 두 스트림을 interleave 방식으로 합치면, A, 1, B, 2, C, 3... , Flux.merge() 메소드를 사용할 때
    // non-interleave 방식, 즉 Flux.concat()을 사용


    // TODO Merge flux1 and flux2 values with interleave
    Flux<User> mergeFluxWithInterleave(Flux<User> flux1, Flux<User> flux2) {
        return Flux.merge(flux1, flux2);
    }

    //========================================================================================

    // TODO Merge flux1 and flux2 values with no interleave (flux1 values and then flux2 values)
    Flux<User> mergeFluxWithNoInterleave(Flux<User> flux1, Flux<User> flux2) {
        return Flux.concat(flux1, flux2);
    }

    //========================================================================================

    // TODO Create a Flux containing the value of mono1 then the value of mono2
    Flux<User> createFluxFromMultipleMono(Mono<User> mono1, Mono<User> mono2) {
        return Flux.concat(mono1, mono2);
    }
}
