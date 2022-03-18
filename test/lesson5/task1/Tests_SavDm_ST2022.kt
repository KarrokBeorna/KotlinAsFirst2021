package lesson5.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests_SavDm_ST2022 {

    @Test
    @Tag("6")
    fun findSumOfTwo() {
        assertEquals(Pair(-1, -1), findSumOfTwo(emptyList(), 1))
        assertEquals(Pair(0, 2), findSumOfTwo(listOf(1, 2, 3), 4))
        assertEquals(Pair(-1, -1), findSumOfTwo(listOf(1, 2, 3), 6))

        assertEquals(Pair(2, 4), findSumOfTwo(listOf(1, 2, 3, 4, 5, 6, 7, 8), 8))
        assertEquals(Pair(3, 4), findSumOfTwo(listOf(1, 1, 1, 1, 7, 7, 7, 7), 8))
    }

    @Test
    @Tag("8")
    fun bagPacking() {
        assertEquals(
            setOf("Кубок"),
            bagPacking(
                mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                850
            )
        )
        assertEquals(
            emptySet<String>(),
            bagPacking(
                mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                450
            )
        )

        // Black Desert Online - Orc camp - 280+ AP, 340+ DP - main-spot grinding (400~1200kk/h)
        // Price and LT don't correspond to reality
        assertEquals(
            setOf("Фрагмент яростной ночи", "Сердце иссохшего леса", "Мясистый оранжевый гриб"),
            bagPacking(
                mapOf(                                          // 3500+900+300=4700
                    "Мясистый оранжевый гриб" to (2 to 300),
                    "Черный камень (броня)" to (1000 to 2000),
                    "Черный камень (оружие)" to (750 to 1500),
                    "Сгусток чистых чар" to (100 to 250),
                    "Пламя Вельтара" to (1000 to 2500),
                    "Сердце иссохшего леса" to (300 to 900),
                    "Семя пустоты" to (3 to 500),
                    "Иолит III [Здоровье]" to (500 to 1000),
                    "Иолит IV [Защита]" to (1500 to 4500),
                    "Порошок варваров" to (500 to 800),
                    "Фрагмент яростной ночи" to (1199 to 3500)
                ),
                1501
            )
        )

        // Black Desert Online - Monastery of Blood - 280+ AP, 320+ DP - sec-spot grinding (300~800kk/h)
        // Price and LT don't correspond to reality
        assertEquals(
            setOf("Фрагмент утомленной ночи", "Семя пустоты", "Сгусток чистых чар", "Символ преданности"),
            bagPacking(
                mapOf(                                          //3500+500+250+300=4550
                    "Символ преданности" to (2 to 300),
                    "Черный камень (броня)" to (1000 to 2000),
                    "Черный камень (оружие)" to (750 to 1500),
                    "Сгусток чистых чар" to (100 to 250),
                    "Молния Карнака" to (1000 to 2500),
                    "Коготь разделенной луны" to (300 to 900),
                    "Семя пустоты" to (3 to 500),
                    "Холодные слёзы Черного солнца" to (500 to 1000),
                    "Гранат III [Меткость]" to (1500 to 4500),
                    "Порошок битвы" to (500 to 1000),
                    "Фрагмент утомленной ночи" to (1201 to 3500)
                ),
                1501
            )
        )
        assertEquals(
            emptySet<String>(),
            bagPacking(
                mapOf(
                    "Символ преданности" to (1502 to 300)
                ),
                1501
            )
        )
    }
}