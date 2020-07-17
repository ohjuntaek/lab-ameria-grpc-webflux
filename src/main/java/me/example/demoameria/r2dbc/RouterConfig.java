package me.example.demoameria.r2dbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
@EnableWebFlux
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(FuncHandler handler) {
        return RouterFunctions.route(GET("/hi"), handler::hello);
    }
}
