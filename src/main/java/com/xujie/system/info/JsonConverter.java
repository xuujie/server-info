package com.xujie.system.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonConverter {
    public static final String toJson(Map map) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(map);
    }
}
