package com.xujie.system.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(produces = "application/json")
    public Map<String, String> client(HttpServletRequest request) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.putAll(ip(request));
        logger.info("client info: {}", JsonConverter.toJson(map));
        return map;
    }

    @GetMapping(value = "/ip", produces = "application/json")
    public Map<String, String> ip(HttpServletRequest request) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        String clientIp = request.getRemoteAddr();
        map.put("ip", clientIp);
        logger.info(JsonConverter.toJson(map));
        return map;
    }
}
