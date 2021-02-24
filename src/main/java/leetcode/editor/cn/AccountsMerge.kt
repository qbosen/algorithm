package leetcode.editor.cn

import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.list2DMatcher
import util.to2DStringList
import java.util.ArrayList

import java.util.Collections

import java.util.HashMap


//721 账户合并
/* [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]] */

fun main() {
    val result = AccountsMerge.Solution()::accountsMerge
    assertThat(
        result("""[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]""".to2DStringList()),
        list2DMatcher("""[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]""".to2DStringList())
    )
}

class AccountsMerge {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
            class UnionFind(n: Int) {
                private val ancestor: IntArray = IntArray(n) { it }

                fun union(i: Int, j: Int) {
                    ancestor[find(i)] = find(j)
                }

                fun find(i: Int): Int {
                    if (ancestor[i] != i) {
                        ancestor[i] = find(ancestor[i])
                    }
                    return ancestor[i]
                }
            }

            val emailToIndex = HashMap<String, Int>()
            val emailToName = HashMap<String, String>()
            var emailsCount = 0
            for (account in accounts) {
                val name = account[0]
                for (i in 1 until account.size) {
                    val email = account[i]
                    if (!emailToIndex.containsKey(email)) {
                        emailToIndex[email] = emailsCount++
                        emailToName[email] = name
                    }
                }
            }
            val uf = UnionFind(emailsCount)
            for (account in accounts) {
                val firstEmail = account[1]
                val firstIndex = emailToIndex[firstEmail]!!
                val size = account.size
                for (i in 2 until size) {
                    val nextEmail = account[i]
                    val nextIndex = emailToIndex[nextEmail]!!
                    uf.union(firstIndex, nextIndex)
                }
            }
            val indexToEmails = HashMap<Int, MutableList<String>>()
            for (email in emailToIndex.keys) {
                val index = uf.find(emailToIndex[email]!!)
                val account = indexToEmails.getOrDefault(index, ArrayList())
                account.add(email)
                indexToEmails[index] = account
            }
            val merged = ArrayList<List<String>>()
            for (emails in indexToEmails.values) {
                emails.sort()
                val name = emailToName[emails[0]]!!
                val account = ArrayList<String>()
                account.add(name)
                account.addAll(emails)
                merged.add(account)
            }
            return merged
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}