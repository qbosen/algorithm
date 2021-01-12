<p>公司共有 <code>n</code> 个项目和  <code>m</code> 个小组，每个项目要不无人接手，要不就由 <code>m</code> 个小组之一负责。</p>

<p><code>group[i]</code> 表示第 <code>i</code> 个项目所属的小组，如果这个项目目前无人接手，那么 <code>group[i]</code> 就等于 <code>-1</code>。（项目和小组都是从零开始编号的）小组可能存在没有接手任何项目的情况。</p>

<p>请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表：</p>

<ul>
	<li>同一小组的项目，排序后在列表中彼此相邻。</li>
	<li>项目之间存在一定的依赖关系，我们用一个列表 <code>beforeItems</code> 来表示，其中 <code>beforeItems[i]</code> 表示在进行第 <code>i</code> 个项目前（位于第 <code>i</code> 个项目左侧）应该完成的所有项目。</li>
</ul>

<p>如果存在多个解决方案，只需要返回其中任意一个即可。如果没有合适的解决方案，就请返回一个 <strong>空列表 </strong>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/22/1359_ex1.png" style="height: 181px; width: 191px;" /></strong></p>

<pre>
<strong>输入：</strong>n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
<strong>输出：</strong>[6,3,4,1,5,2,0,7]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
<strong>输出：</strong>[]
<strong>解释：</strong>与示例 1 大致相同，但是在排序后的列表中，4 必须放在 6 的前面。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= m <= n <= 3 * 10<sup>4</sup></code></li>
	<li><code>group.length == beforeItems.length == n</code></li>
	<li><code>-1 <= group[i] <= m - 1</code></li>
	<li><code>0 <= beforeItems[i].length <= n - 1</code></li>
	<li><code>0 <= beforeItems[i][j] <= n - 1</code></li>
	<li><code>i != beforeItems[i][j]</code></li>
	<li><code>beforeItems[i]</code> 不含重复元素</li>
</ul>
<div><div>Related Topics</div><div><li>深度优先搜索</li><li>图</li><li>拓扑排序</li></div></div>\n<div><li>👍 122</li><li>👎 0</li></div>