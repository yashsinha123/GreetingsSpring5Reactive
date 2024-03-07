package org.bridgelabz.greetingsreactive.service;


import org.bridgelabz.greetingsreactive.model.Greetings;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IGreetingService {
    Mono<Greetings> saveGreeting(Greetings greeting);

    Flux<Greetings> getGreeting();

    Mono<Greetings> getGreetingById(int id);

    Mono<Void> deleteGreetingById(int id);
}
