package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[2043] 简易银行系统
/* ["Bank","withdraw","transfer","deposit","transfer","withdraw"],[[[10,100,20,50,30]],[3,10],[5,1,20],[5,20],[3,4,15],[10,50]] */
public class SimpleBankSystem {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Bank {
        private final long[] balance;
        private final int n;

        public Bank(long[] balance) {
            this.balance = balance;
            this.n = balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            int ac1 = ac(account1), ac2 = ac(account2);
            if (ac1 < 0 || ac2 < 0 || balance[ac1] < money) {
                return false;
            }
            balance[ac1] -= money;
            balance[ac2] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            int ac = ac(account);
            if (ac < 0) return false;
            balance[ac] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            int ac = ac(account);
            if (ac < 0 || balance[ac] < money) return false;
            balance[ac] -= money;
            return true;
        }

        private int ac(int account) {
            if (account <= 0 || account > n) return -1;
            else return account - 1;
        }
    }

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
//leetcode submit region end(Prohibit modification and deletion)

}