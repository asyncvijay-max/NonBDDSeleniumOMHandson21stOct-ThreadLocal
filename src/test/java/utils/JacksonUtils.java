package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static <T> T deSerializeJson(String jsonFilePath, Class<T> T) throws IOException {
        ObjectMapper objectMapper= new ObjectMapper();
        InputStream in = JacksonUtils.class.getClassLoader().getResourceAsStream(jsonFilePath);
        return objectMapper.readValue(in,T);

    }
}
