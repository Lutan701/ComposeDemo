package com.demo.xx.instrument


interface Consumables {
    val value: Int
    val desc: String

    companion object {
        fun <T : Consumables> get(consumablesClass: Class<T>, value: Int): T? { // 抽象的 get 函数，所有实现该接口的枚举类都会使用它
            return consumablesClass.enumConstants?.first { it.value == value }
        }
    }
}

enum class PlaceHolder(override val value: Int, override val desc: String) : Consumables {
    PLACE_HOLDER(0, "占位耗材");
}

enum class Diluent(override val value: Int, override val desc: String) : Consumables {

    DILUENT1(1, "稀释液1"),
    DILUENT2(2, "稀释液2"),
    DILUENT3(3, "稀释液3"),
    DILUENT4(4, "稀释液4"),
    DILUENT5(5, "稀释液5"),
    DILUENT6(6, "稀释液6");

}

enum class WellPlate(override val value: Int, override val desc: String) : Consumables {
    WELL_PLATE_P96(7, "96孔板");
}