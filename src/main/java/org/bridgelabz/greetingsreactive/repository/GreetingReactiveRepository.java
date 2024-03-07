package org.bridgelabz.greetingsreactive.repository;

import org.bridgelabz.greetingsreactive.model.Greetings;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface GreetingReactiveRepository extends R2dbcRepository<Greetings, Integer> {

    }
