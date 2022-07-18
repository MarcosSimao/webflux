package com.api.webflux.repository;

import com.api.webflux.document.PlayList;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayListRepository extends ReactiveMongoRepository<PlayList,String> {
}
