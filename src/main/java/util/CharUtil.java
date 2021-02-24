package util;

/**
 * @author qiubaisen
 * @date 2020/3/30
 */
public class CharUtil {

    public static char[][] parse2D4String(String input) {
        return CommonUtil.parse(input, char[][].class);
    }
    public static char[] parse1D4String(String input){
        return CommonUtil.parse(input, char[].class);
    }
}
