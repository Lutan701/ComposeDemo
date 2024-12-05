package com.demo.xx.instrument

/**
 * 桶定义
 */
enum class Barrel(private val value: Int, val bName: String) {
    WASTE(1, "废液桶"),
    LOTION(2, "洗涤液桶"),
    WATER(3, "纯水桶");

    companion object {
        operator fun get(index: Int): Barrel = entries.first { it.value == index }
    }
}

/**
 * 桶状态定义
 */
enum class BarrelStatus(private val value: Int, val level: Float) {
    EMPTY(1, 0f),
    HALF(2, 50f),
    FULL(3, 100f);

    companion object {
        operator fun get(index: Int): BarrelStatus = entries.first { it.value == index } // 重构get函数
    }
}