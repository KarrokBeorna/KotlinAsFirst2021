package lesson6.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests_SavDm_ST2022 {

    @Test
    @Tag("6")
    fun mostExpensive() {
        assertEquals("", mostExpensive(""))
        assertEquals("Курица", mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("Вино", mostExpensive("Вино 255.0"))


        assertEquals("Приправа", mostExpensive("Вино 255; Хлеб 15; Приправа 256"))
        assertEquals("", mostExpensive("Вино 255, Хлеб 15; Приправа 256")) // dropped - ";_ -> ,_" actual: "Приправа"
        assertEquals("", mostExpensive("Вино 255, Хлеб 15"))         // dropped - ";_ -> ,_" actual: "Вино 255, Хлеб"
        assertEquals("", mostExpensive("Вино 255;Хлеб 15"))          // dropped - ";_ -> ;"  actual: "Вино"

        // What's right? actual: "Вино"
        // "-256" - skip -> "Вино"    or    "-256" - invalid format -> ""
        //assertEquals("", mostExpensive("Вино 255; Хлеб 15; Приправа -256"))
    }

    @Test
    @Tag("6")
    fun fromRoman() {
        assertEquals(1, fromRoman("I"))
        assertEquals(3000, fromRoman("MMM"))
        assertEquals(1978, fromRoman("MCMLXXVIII"))
        assertEquals(694, fromRoman("DCXCIV"))
        assertEquals(49, fromRoman("XLIX"))
        assertEquals(-1, fromRoman("Z"))


        assertEquals("", fromRoman(""))
        assertEquals(-1, fromRoman("DM")) // dropped actual: 1500
        assertEquals(-1, fromRoman("LM")) // dropped actual: 1050
        assertEquals(-1, fromRoman("LD")) // dropped actual: 550
        assertEquals(-1, fromRoman("LC")) // dropped actual: 150
        assertEquals(-1, fromRoman("VM")) // dropped actual: 1005
        assertEquals(-1, fromRoman("VD")) // dropped actual: 505
        assertEquals(-1, fromRoman("VC")) // dropped actual: 105
        assertEquals(-1, fromRoman("VL")) // dropped actual: 55
        assertEquals(-1, fromRoman("VX")) // dropped actual: 15
        assertEquals(-1, fromRoman("IM")) // dropped actual: 1001
        assertEquals(-1, fromRoman("ID")) // dropped actual: 501
        assertEquals(-1, fromRoman("IC")) // dropped actual: 101
        assertEquals(-1, fromRoman("IL")) // dropped actual: 51
        assertEquals(-1, fromRoman("IXX")) // dropped actual: 19
    }
}