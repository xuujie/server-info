package com.xujie.system.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/server")
public class ServerInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(produces = "application/json")
    public Map<String, String> server() throws UnknownHostException, JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.putAll(ip());
        map.putAll(hostName());
        map.putAll(os());
        logger.info("server info: {}", JsonConverter.toJson(map));
        return map;
    }

    @GetMapping(value = "/ip", produces = "application/json")
    public Map<String, String> ip() throws UnknownHostException, JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        String ip = Inet4Address.getLocalHost().getHostAddress();
        map.put("ip", ip);
        logger.info(JsonConverter.toJson(map));
        return map;
    }

    @GetMapping(value = "/host-name", produces = "application/json")
    public Map<String, String> hostName() throws UnknownHostException, JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        String hostName = Inet4Address.getLocalHost().getHostName();
        map.put("host-name", hostName);
        String canonicalHostName = Inet4Address.getLocalHost().getCanonicalHostName();
        map.put("canonical-host-name: ", canonicalHostName);
        logger.info(JsonConverter.toJson(map));
        return map;
    }

    @GetMapping(value = "/os", produces = "application/json")
    public Map<String, String> os() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        String os = System.getProperty("os.name");
        map.put("os", os);
        logger.info(JsonConverter.toJson(map));
        return map;
    }
}
