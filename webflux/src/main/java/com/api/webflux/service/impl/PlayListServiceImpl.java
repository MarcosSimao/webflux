package com.api.webflux.service.impl;

import com.api.webflux.document.PlayList;
import com.api.webflux.repository.PlayListRepository;
import com.api.webflux.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class PlayListServiceImpl implements PlayListService {
    @Autowired
    private PlayListRepository playListRepository;
    @Override
    public Flux<PlayList> findAll() {
        return playListRepository.findAll();
    }

    @Override
    public Mono<PlayList> findByid(String id) {
        return playListRepository.findById(id);
    }

    @Override
    public Mono<PlayList> save(PlayList playList) {
        return playListRepository.save(playList);
    }
}
