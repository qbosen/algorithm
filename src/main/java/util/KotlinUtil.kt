package util

import struct.ListNode

/**
 * @author qiubaisen
 * @date 2020/4/24
 */

fun String.to1DIntArray(): IntArray = IntUtil.parse1DIntArray(this)
fun String.to2DIntArray(): Array<IntArray> = IntUtil.parse2DIntArray(this)
fun String.to2DIntList(): List<List<Int>> = IntUtil.parse2DIntList(this)
fun String.toListNode(): ListNode = IntUtil.parse1DInt2ListNode(this)
fun String.to2DCharArray(): Array<CharArray> = CharUtil.parse2D4String(this)
fun String.toStringList(): List<String> = StringUtil.parse1DList(this)
fun String.toListNodeArray(): Array<ListNode?> = IntUtil.parse2DInt2ListNodeArray(this)

fun Int.factorial() = (1..this).reduce { a, b -> a * b }