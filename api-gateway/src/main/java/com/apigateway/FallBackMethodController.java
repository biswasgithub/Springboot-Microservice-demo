package com.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/mobileServiceFallBack")
    public String mobileServiceFallBackMethod() {
        return "Mobile Service is taking longer than Expected." +
                " Please try again later";
    }
    
    @GetMapping("/movieInfoServiceFallBack")
    public String movieInfoServiceFallBackMethod() {
        return "Movie Info Service is taking longer than Expected." +
                " Please try again later";
    }
    
    @GetMapping("/movieCatalogServiceFallBack")
    public String movieCatalogServiceFallBackMethod() {
        return "Movie Catalog Service is taking longer than Expected." +
                " Please try again later";
    }
}
