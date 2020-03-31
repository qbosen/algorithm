package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

/**
 * @author qiubaisen
 * @date 2020/3/31
 */
public class IntArrayUtil {
    /**
     * [0,1,0,3,12]
     */
    public static int[] parse1DIntArray(String intArr) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(intArr, int[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(parse1DIntArray("[0,1,0,3,12]")));
    }
}
