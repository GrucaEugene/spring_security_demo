package com.breakthrough.springsecuritydemo.rest;

import com.breakthrough.springsecuritydemo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {
    private List<Developer> developers = Stream.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Petr", "Petriv"),
            new Developer(3L, "Nick", "Nickolson")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getDevelopers(){
        return developers;
    }

    @GetMapping("/{id}")
    public Developer getDeveloperById(@PathVariable Long id){
        return developers.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping()
    public Developer create(@RequestBody Developer developer) {
        developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        developers.removeIf(item -> item.getId().equals(id));
    }



}
