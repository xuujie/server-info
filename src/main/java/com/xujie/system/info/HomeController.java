package com.xujie.system.info;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "system-info");
        map.put("description", "simple application showing system information");
        Map<String, String> endpointMap = new HashMap<>();
        endpointMap.put("server", "/server");
        endpointMap.put("client", "/client");
        map.put("endpoints", endpointMap);
        return map;
    }
}
