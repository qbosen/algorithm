package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1233] 删除子文件夹
/* ["/a","/a/b","/c/d","/c/d/e","/c/f"] */
public class RemoveSubFoldersFromTheFilesystem{
    public static void main(String[] args) {
        Solution solution = new RemoveSubFoldersFromTheFilesystem().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<String>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; ++i) {
            int prevDir = ans.size() - 1;
            int prevLen = ans.get(prevDir).length();
            if (prevLen < folder[i].length())
                if (ans.get(prevDir).equals(folder[i].substring(0, prevLen))) {
                    if (folder[i].charAt(prevLen) == '/') {
                        continue;
                    }
                }
            ans.add(folder[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}