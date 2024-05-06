package ca.tetervak.dicecube

import ca.tetervak.ca.tetervak.dicecube.DiceCube
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.util.Random

class DiceCubeTest {

    // specifying the seed makes the "random" sequence always the same
    private val random: Random = Random( 3)
    private val diceCube: DiceCube = DiceCube(random = random)

    @BeforeEach
    fun setUp() {
        println("--- testing case ---")
    }

    @AfterEach
    fun tearDown() {
        println("--- ------- ---- ---")
    }

    @Test
    fun setValue_Valid() {
        println("set value 3")
        diceCube.value = 3
        println("diceCube = $diceCube")
        assertEquals(3, diceCube.value)
    }

    @Test
    fun setValue_Illegal() {
        println("set value 0, check throwing exception")
        assertThrows(IllegalArgumentException::class.java) {
            diceCube.value = 0
        }
    }

    @Test
    fun init_Valid() {
        println("use init value 0; check throwing exception")
        assertThrows(IllegalArgumentException::class.java) {
            DiceCube(initValue = 0)
        }
    }


    @Test
    fun roll() {
        for(repetition: Int in 1..20 ){
            print("repetition %02d ".format(repetition))
            diceCube.roll()
            val value = diceCube.value
            println("value = $value")
            assert(value > 0)
            assert(value <= 6)
        }
    }

    @Test
    fun reset() {
        diceCube.roll()
        println("before reset value = ${diceCube.value}")
        diceCube.reset()
        println("after reset value = ${diceCube.value}")
        assertEquals(diceCube.initValue, diceCube.value)
    }
}