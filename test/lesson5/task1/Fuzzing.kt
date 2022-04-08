package lesson5.task1

import edu.berkeley.cs.jqf.fuzz.Fuzz
import edu.berkeley.cs.jqf.fuzz.JQF
import org.junit.runner.RunWith


@RunWith(JQF::class)
class Fuzzing {

    @Fuzz
    fun testFindSumOfTwo(list: List<Int>, number: Int) {
        findSumOfTwo(list, number)
    }

    /**
    java.lang.IllegalArgumentException:
    Cannot find generator for java.util.Map<java.lang.String, kotlin.Pair<java.lang.Integer, java.lang.Integer>>:
    kotlin.Pair<java.lang.Integer,java.lang.Integer> of type kotlin.Pair<java.lang.Integer, java.lang.Integer>
     */
//    @Fuzz
//    fun testBagPacking(treasures: Map<String, Pair<Int, Int>>, capacity: Int) {
//        bagPacking(treasures, capacity)
//    }
}