得益于`intellij leetcode`插件的完善和`leetcode`手机app的功能增强、以及自身水平的上升，几乎不需要在IDE中进行读题、测试、调试了。

由此精简了许多`harmcrest`,`junit`相关测试，和许多用于构建输入数据的`jackson`解析，以及对应的工具类。

使用`kotlin`刷题大半年有余，好处是言简意赅、聚焦算法。不足的地方有:
1. `intellij`提供了许多优化，但是仍然有卡顿的问题，特别是扩展方法、类数量多的情况，影响写算法时流畅的感觉。
2. `leetcode`对`kotlin`的支持不足，某些内联函数不在默认引用范围，如`max,min`，无法使用默认方法(需要compile相关设置)
3. `leetcode`官方使用了`kotlinJS`执行代码，导致耗时时间长，无法体现算法效率。
4. 市场面试手写算法仍然以`Java`/`C++`为主

对比2020年，2021年的刷题主要是以速度和量为主，正确性的判断不在全靠手动测试，可以脱离IDE。所以另起分支，重置进度。