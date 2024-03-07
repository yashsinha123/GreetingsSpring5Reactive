package org.bridgelabz.greetingsreactive.service;

import org.bridgelabz.greetingsreactive.model.Greetings;
import org.bridgelabz.greetingsreactive.repository.GreetingReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class GreetingsReactiveService implements  IGreetingService {
    @Autowired
    GreetingReactiveRepository greetingsReactiveRepository;

    @Override
    public Mono<Greetings> saveGreeting(Greetings greeting) {
        return greetingsReactiveRepository.save(greeting);

    }

    @Override
    public Flux<Greetings> getGreeting() {
        return greetingsReactiveRepository.findAll();

    }

    @Override
    public Mono<Greetings> getGreetingById(int id) {
        return greetingsReactiveRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteGreetingById(int id) {

        return greetingsReactiveRepository.deleteById(id);
    }
}
