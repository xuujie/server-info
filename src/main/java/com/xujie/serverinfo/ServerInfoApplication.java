package com.xujie.serverinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ServerInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerInfoApplication.class, args);
    }

    @GetMapping(value = "/", produces = "application/json")
    public Map<String, String> index() throws UnknownHostException {
        Map<String, String> map = new HashMap<>();
        map.putAll(ip());
        map.putAll(hostName());
        map.putAll(os());
        return map;
    }

    @GetMapping(value = "/ip", produces = "application/json")
    public Map<String, String> ip() throws UnknownHostException {
        Map<String, String> map = new HashMap<>();
        map.put("ip", Inet4Address.getLocalHost().getHostAddress());
        return map;
    }

    @GetMapping(value = "/host-name", produces = "application/json")
    public Map<String, String> hostName() throws UnknownHostException {
        Map<String, String> map = new HashMap<>();
        map.put("host-name", Inet4Address.getLocalHost().getHostName());
        map.put("canonical-host-name", Inet4Address.getLocalHost().getCanonicalHostName());
        return map;
    }

    @GetMapping(value="/os", produces = "application/json")
    public Map<String, String> os() {
        Map<String, String> map = new HashMap<>();
        map.put("os", System.getProperty("os.name"));
        return map;
    }

}
