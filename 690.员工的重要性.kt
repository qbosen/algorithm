/*
 * @lc app=leetcode.cn id=690 lang=kotlin
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
 *	// Definition for Employee.
 *	class Employee {
 *		var id:Int = 0
 *		var importance:Int = 0
 *		var subordinates:List<Int> = listOf()
 *	}
 */

class Solution {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val map = employees.associateBy {it?.id!!}
        
        fun dfs(id:Int): Int {
            val emp = map[id]!!
            var total = emp.importance
            emp.subordinates.forEach { total+= dfs(it) }
            return total
        }

        return dfs(id);
    }
}
// @lc code=end