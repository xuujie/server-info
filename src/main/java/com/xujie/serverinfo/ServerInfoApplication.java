package com.xujie.serverinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ServerInfoApplication {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(ServerInfoApplication.class, args);
    }

    @GetMapping(value = "/", produces = "application/json")
    public Map<String, String> index(HttpServletRequest request) throws UnknownHostException {
        logger.info("Responding server information");
        Map<String, String> map = new HashMap<>();
        map.putAll(ip());
        map.putAll(hostName());
        map.putAll(os());
        map.putAll(clientIp(request));
        return map;
    }

    @GetMapping(value = "/ip", produces = "application/json")
    public Map<String, String> ip() throws UnknownHostException {
        logger.info("Responding ip address");
        Map<String, String> map = new HashMap<>();
        String ip = Inet4Address.getLocalHost().getHostAddress();
        map.put("ip", ip);
        logger.info("ip: {}", ip);
        return map;
    }

    @GetMapping(value = "/host-name", produces = "application/json")
    public Map<String, String> hostName() throws UnknownHostException {
        logger.info("Responding hostname");
        Map<String, String> map = new HashMap<>();
        String hostName = Inet4Address.getLocalHost().getHostName();
        map.put("host-name", hostName);
        logger.info("host-name: {}", hostName);
        String canonicalHostName = Inet4Address.getLocalHost().getCanonicalHostName();
        map.put("canonical-host-name: ", canonicalHostName);
        logger.info("canonical-host-name: {}", canonicalHostName);
        return map;
    }

    @GetMapping(value = "/os", produces = "application/json")
    public Map<String, String> os() {
        logger.info("Responding os name");
        Map<String, String> map = new HashMap<>();
        String os = System.getProperty("os.name");
        map.put("os", os);
        logger.info("os: {}", os);
        return map;
    }

    @GetMapping(value = "/client-ip", produces = "application/json")
    public Map<String, String> clientIp(HttpServletRequest request) {
        logger.info("Responding client ip");
        Map<String, String> map = new HashMap<>();
        String clientIp = request.getRemoteAddr();
        map.put("client-ip", clientIp);
        logger.info("client-ip: {}", clientIp);
        return map;
    }

}
