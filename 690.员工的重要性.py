#
# @lc app=leetcode.cn id=690 lang=python3
#
# [690] 员工的重要性
#
import collections

# @lc code=start
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        mp = {emp.id : emp for emp in employees}
        total = 0
        que = collections.deque([id])
        while que:
            curId = que.popleft()
            employee = mp[curId]
            total += employee.importance
            for subId in employee.subordinates:
                que.append(subId)

        return total
# @lc code=end

