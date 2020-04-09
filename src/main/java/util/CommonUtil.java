package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author qiubaisen
 * @date 2020/4/8
 */
public class CommonUtil {
    public static <T> T parse(String input, Class<T> type) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(input, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
