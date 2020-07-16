package me.example.demoameria.config;


import com.linecorp.armeria.common.grpc.GrpcSerializationFormats;
import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.grpc.GrpcService;
import com.linecorp.armeria.server.logging.AccessLogWriter;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;
import lombok.RequiredArgsConstructor;
import me.example.demoameria.DemoGrpcService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ServerConfig {

    private final DemoGrpcService demoGrpcService;

    @Bean
    public ArmeriaServerConfigurator armeriaServerConfigurator() {

        return serverBuilder -> {

            serverBuilder.decorator(LoggingService.newDecorator());
            serverBuilder.accessLogWriter(AccessLogWriter.combined(), false);

            serverBuilder.service(GrpcService.builder()
                    .addService(demoGrpcService)
                    .supportedSerializationFormats(GrpcSerializationFormats.values())
                    .enableUnframedRequests(true)
                    .build());

            serverBuilder.serviceUnder("/docs", new DocService());
        };

    }
}
