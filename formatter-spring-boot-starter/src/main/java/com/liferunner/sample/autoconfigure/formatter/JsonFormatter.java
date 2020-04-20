package com.liferunner.sample.autoconfigure.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * JsonFormatter
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2020/4/20
 **/
public class JsonFormatter implements Formatter {

    private final ObjectMapper objectMapper;

    public JsonFormatter() {
        this(new ObjectMapper());
    }

    public JsonFormatter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String format(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        } catch (IOException e) { // shouldn't really happen, but is declared as possibility so:
            throw new IllegalArgumentException();
        }
    }
}
