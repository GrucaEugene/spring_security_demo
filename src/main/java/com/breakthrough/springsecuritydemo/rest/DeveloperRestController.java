package com.breakthrough.springsecuritydemo.rest;

import com.breakthrough.springsecuritydemo.model.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('developers:read')")
    public List<Developer> getDevelopers(){
        return developers;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getDeveloperById(@PathVariable Long id){
        return developers.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('developers:write')")
    public Developer create(@RequestBody Developer developer) {
        developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void delete(@PathVariable Long id) {
        developers.removeIf(item -> item.getId().equals(id));
    }



}
