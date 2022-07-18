package com.api.webflux.controller;

import com.api.webflux.document.PlayList;
import com.api.webflux.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
}
