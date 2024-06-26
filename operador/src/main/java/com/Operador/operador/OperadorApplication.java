package com.Operador.operador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OperadorApplication {
	public static void main(String[] args) {
		SpringApplication.run(OperadorApplication.class, args);
	}
}
