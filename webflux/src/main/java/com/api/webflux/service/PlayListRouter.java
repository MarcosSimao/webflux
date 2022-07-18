package com.api.webflux.service;

import com.api.webflux.service.PlaylistHandle;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class PlayListRouter {
   // @Bean
    public RouterFunction<ServerResponse> route(PlaylistHandle playlistHandle){
        return RouterFunctions
                .route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)),playlistHandle::findAll)
                .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)),playlistHandle::findById)
                .andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)),playlistHandle::save);
    }
}
