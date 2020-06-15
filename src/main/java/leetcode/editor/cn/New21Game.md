<p>爱丽丝参与一个大致基于纸牌游戏 &ldquo;21点&rdquo; 规则的游戏，描述如下：</p>

<p>爱丽丝以 <code>0</code> 分开始，并在她的得分少于 <code>K</code> 分时抽取数字。 抽取时，她从 <code>[1, W]</code> 的范围中随机获得一个整数作为分数进行累计，其中 <code>W</code> 是整数。 每次抽取都是独立的，其结果具有相同的概率。</p>

<p>当爱丽丝获得不少于 <code>K</code> 分时，她就停止抽取数字。 爱丽丝的分数不超过 <code>N</code> 的概率是多少？</p>

<p><strong>示例</strong><strong> 1</strong><strong>：</strong></p>

<pre><strong>输入：</strong>N = 10, K = 1, W = 10
<strong>输出：</strong>1.00000
<strong>说明：</strong>爱丽丝得到一张卡，然后停止。</pre>

<p><strong>示例 </strong><strong>2</strong><strong>：</strong></p>

<pre><strong>输入：</strong>N = 6, K = 1, W = 10
<strong>输出：</strong>0.60000
<strong>说明：</strong>爱丽丝得到一张卡，然后停止。
在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。</pre>

<p><strong>示例 </strong><strong>3</strong><strong>：</strong></p>

<pre><strong>输入：</strong>N = 21, K = 17, W = 10
<strong>输出：</strong>0.73278</pre>

<p><strong>提示：</strong></p>

<ol>
	<li><code>0 &lt;= K &lt;= N &lt;= 10000</code></li>
	<li><code>1 &lt;= W &lt;= 10000</code></li>
	<li>如果答案与正确答案的误差不超过 <code>10^-5</code>，则该答案将被视为正确答案通过。</li>
	<li>此问题的判断限制时间已经减少。</li>
</ol>
<div><div>Related Topics</div><div><li>动态规划</li></div></div>

## 思路
`d[i]` 从i分开始，最终获胜的概率
```
d[i] = sum{d[i+1]...d[i+W]} / W
(d[i+1] - d[i]) = d[i+1+W] - d[i+1]
d[i] = d[i+1] + (d[i+1]-d[i+1+W]) / W ; 0<=i<K-1
d[K-1] = sum{d[K]...d[K+W]} / w
d[i] = 1 ; K<=i<=min{N,K+W-1}
d[i] = 0 ; min{N,K+W-1}<i
组合上四式有：
d[K-1] = (min{N,K+W-1}-(K-1))/w = min{N-K+1,W} / W
```