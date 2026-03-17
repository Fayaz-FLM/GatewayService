package com.flmhospitals.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Patient Service Routes
                .route("patient-service", r -> r
                        .path("/patients/**")
                        .uri("lb://PATIENTMANAGEMENT"))
                
                // Appointment Service Routes
                .route("appointment-service", r -> r
                        .path("/appointments/**")
                        .uri("lb://APPOINTMENTMANAGEMENT"))
                
                // Bed Service Routes - Beds
                .route("bed-service", r -> r
                        .path("/bed/**")
                        .uri("lb://BEDMANAGEMENT"))
                
                // Bed Service Routes - Rooms
                .route("room-service", r -> r
                        .path("/rooms/**")
                        .uri("lb://BEDMANAGEMENT"))
                
                // Staff Service Routes
                .route("staff-service", r -> r
                        .path("/staff/**")
                        .uri("lb://STAFFSERVICE"))
                
                // Doctor Schedule Routes
                .route("doctor-schedule-service", r -> r
                        .path("/doctorSchedule/**")
                        .uri("lb://STAFFSERVICE"))
                
                // Notification Service Routes
                .route("notification-service", r -> r
                        .path("/api/notifications/**")
                        .uri("lb://NOTIFICATION-SERVICE"))
                
                .build();
    }
}
