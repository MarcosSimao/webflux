package com.api.webflux.controller;

import com.api.webflux.document.PlayList;
import com.api.webflux.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequestMapping("/playlist")
public class PlayListController {
    @Autowired
    private PlayListService playListService;

    @GetMapping
    public ResponseEntity<Flux<PlayList>> findAll(){
        return ResponseEntity.ok().body(playListService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mono<PlayList>>findById(@PathVariable String id){
        return ResponseEntity.ok().body(playListService.findByid(id));
    }
    @PostMapping
    public ResponseEntity<Mono<PlayList>> save(@RequestBody PlayList playList){
        return ResponseEntity.status(HttpStatus.CREATED).body(playListService.save(playList));
    }
    @GetMapping(value="/events",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long,PlayList>> getPlayListEvents(){
        Flux<Long>interval=Flux.interval(Duration.ofSeconds(12));
        Flux<PlayList>events=playListService.findAll();
        System.out.println("texte "+events.toString());
        return Flux.zip(interval,events);
    }
}
