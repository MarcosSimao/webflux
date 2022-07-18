package com.api.webflux.service;

import com.api.webflux.document.PlayList;
import com.api.webflux.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.EntityResponse.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
public class PlaylistHandle {
    @Autowired
    PlayListService service;
    public Mono<ServerResponse> findAll(ServerRequest serverRequest){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), PlayList.class);
    }
    public Mono<ServerResponse> findById(ServerRequest serverRequest){
        String id=serverRequest.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findByid(id),PlayList.class);
    }
    public Mono<ServerResponse> save(ServerRequest serverRequest){
        final Mono<PlayList> playListMono=serverRequest.bodyToMono(PlayList.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playListMono),PlayList.class);
    }

    private Mono<PlayList> fromPublisher(Mono<PlayList> flatMap) {
        return  flatMap.flatMap(service::save);
    }
}
