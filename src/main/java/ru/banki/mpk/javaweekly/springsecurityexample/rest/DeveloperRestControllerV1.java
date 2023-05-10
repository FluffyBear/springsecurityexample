package ru.banki.mpk.javaweekly.springsecurityexample.rest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.banki.mpk.javaweekly.springsecurityexample.model.Developer;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private final List<Developer> DEVELOPERS = List.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Petr", "Petrov"),
            new Developer(3L, "Sergey", "Sergeev")
    );

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return DEVELOPERS.stream()
                .filter(developer -> id.equals(developer.getId()))
                .findFirst()
                .orElse(null);
    }

}
