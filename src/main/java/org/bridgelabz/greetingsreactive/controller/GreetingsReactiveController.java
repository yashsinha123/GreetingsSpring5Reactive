package org.bridgelabz.greetingsreactive.controller;
import org.bridgelabz.greetingsreactive.model.Greetings;
import org.bridgelabz.greetingsreactive.model.Response;
import org.bridgelabz.greetingsreactive.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class GreetingsReactiveController {
    @Autowired
    private IGreetingService service;
    @PostMapping("/greetings")
    public Mono<ResponseEntity<Response>> savegreeting(@RequestBody Greetings greetingsReactiveModel){
        return service.saveGreeting(greetingsReactiveModel)
                .map(savedGreeting -> new ResponseEntity<>(new Response(200, "Greeting saved successfully"), HttpStatus.OK))
                .onErrorResume(e -> Mono.just(new ResponseEntity<>(new Response(500, "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR)));
    }
    @GetMapping("/greetings")
    public Mono<ResponseEntity<Flux<Greetings>>> getallgreetings(){
        return service.getGreeting()
                .collectList()
                .map(greetings -> new ResponseEntity<>(Flux.fromIterable(greetings),HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/greetingsdelete/{id}")
    public Mono<ResponseEntity<Response>> deletebyid(@PathVariable  int id){
        return service.deleteGreetingById(id)
                .map(deleteGreeting -> new ResponseEntity<>(new Response(204,"Greeting deleted successfully"),HttpStatus.NO_CONTENT))
                .defaultIfEmpty(new ResponseEntity<>(new Response(404,"GREETING NOT FOUND"),HttpStatus.NOT_FOUND));
    }
    @GetMapping("/greetings/{id}")
    public Mono<ResponseEntity<Greetings>> getbyid(@PathVariable  int id){
        return service.getGreetingById(id)
                .map(greetingById -> new ResponseEntity<>(greetingById, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
