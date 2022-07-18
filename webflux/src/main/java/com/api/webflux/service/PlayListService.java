package com.api.webflux.service;

import com.api.webflux.document.PlayList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListService {
    Flux<PlayList> findAll();
    Mono<PlayList> findByid(String id);
    Mono<PlayList> save(PlayList playList);
}
