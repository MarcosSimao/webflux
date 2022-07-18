package com.api.webflux.document;

import com.api.webflux.repository.PlayListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;
//@Component
public class DummyData implements CommandLineRunner {
    private final PlayListRepository playListRepository;

    public DummyData(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        playListRepository.deleteAll()
                .thenMany(
                        Flux.just("API REST SPRING BOOT","JAVA 11","web service","futebol do flamengo",
                                        "morte da bezerra","goll do palio")
                                .map(nome-> new PlayList(UUID.randomUUID().toString(),nome))
                                .flatMap(playListRepository::save))
                .subscribe(System.out::println);
    }
}
