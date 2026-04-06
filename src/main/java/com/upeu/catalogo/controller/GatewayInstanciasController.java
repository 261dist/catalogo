package com.upeu.catalogo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class GatewayInstanciasController {

	private final Environment environment;
/*
	@GetMapping("/instancia")
	public Map<String, String> instancia() throws UnknownHostException {
		return Map.of(
				"app", "catalogo",
				"port", environment.getProperty("local.server.port"),
				"host", InetAddress.getLocalHost().getHostName()
		);
	}*/
    @GetMapping("/instancia")
    public Map<String, String> instancia() {
        return Map.of(
                "app", "catalogo",
                "port", environment.getProperty("local.server.port", "N/A"),
                "host", environment.getProperty("HOSTNAME", "desconocido")
        );
    }
}
