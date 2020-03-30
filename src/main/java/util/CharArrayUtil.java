package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

/**
 * @author qiubaisen
 * @date 2020/3/30
 */
public class CharArrayUtil {
    /**
     * [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
     */

    public static char[][] parse2D4String(String input) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(input, char[][].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new char[0][0];
    }

    public static void main(String[] args) {
        String input = "[[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"0\",\"0\"]]";
        System.out.println(Arrays.deepToString(parse2D4String(input)));
    }
}
