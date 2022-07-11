package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[676] 实现一个魔法字典
/* ["MagicDictionary",,"buildDict",,"search",,"search",,"search",,"search"],[[],,[["hello","leetcode"]],,["hello"],,["hhllo"],,["hell"],,["leetcoded"]] */
public class ImplementMagicDictionary{

//leetcode submit region begin(Prohibit modification and deletion)
class MagicDictionary {
    private String[] words;

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        words = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : words) {
            if (word.length() != searchWord.length()) {
                continue;
            }

            int diff = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    ++diff;
                    if (diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }
}


/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
//leetcode submit region end(Prohibit modification and deletion)

}