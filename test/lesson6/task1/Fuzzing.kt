package lesson6.task1

import edu.berkeley.cs.jqf.fuzz.Fuzz
import edu.berkeley.cs.jqf.fuzz.JQF
import org.junit.runner.RunWith


@RunWith(JQF::class)
class Fuzzing {

    @Fuzz
    fun testMostExpensive(description: String) {
        mostExpensive(description)
    }

    @Fuzz
    fun testFromRoman(roman: String) {
        fromRoman(roman)
    }
}