<p>给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。</p>

<p>具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>&quot;abc&quot;
<strong>输出：</strong>3
<strong>解释：</strong>三个回文子串: &quot;a&quot;, &quot;b&quot;, &quot;c&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>&quot;aaa&quot;
<strong>输出：</strong>6
<strong>解释：</strong>6个回文子串: &quot;a&quot;, &quot;a&quot;, &quot;a&quot;, &quot;aa&quot;, &quot;aa&quot;, &quot;aaa&quot;</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>输入的字符串长度不会超过 1000 。</li>
</ul>
<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div>\n<div><li>👍 323</li><li>👎 0</li></div>

# 思路
manacher算法
算出每个中心的最大回文半径x,
对应回文串最大长度即为x-1,
> 半径x,总串2x-1,外两个一定是#,(a#a | b#a#b)形式长度2x-3,有效字符(2x-3+1)/2=x-1

每个中心对应的个数是x/2
> (x-1+1)/2=x/2