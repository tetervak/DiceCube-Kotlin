package ca.tetervak.dicecube

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import java.util.*

class DiceCubeMockedTest {

    // Mocking the Random to produce 1,2,3,4,5,6,1,2,3,4,5,6,1,2, etc.
    private var count = 0
    private val mockRandom: Random = mock<Random> {
        on { nextInt(1, 7) } doAnswer {
            1 + (count++) % 6
        }
    }
    private val diceCube: DiceCube = DiceCube(random = mockRandom)

    @BeforeEach
    fun setUp() {
        println("--- testing case ---")
    }

    @AfterEach
    fun tearDown() {
        println("--- ------- ---- ---")
    }

    @Test
    fun roll() {
        for (repetition: Int in 1..20) {
            print("repetition %02d ".format(repetition))
            diceCube.roll()
            val value = diceCube.value
            println("value = $value")
            assertTrue(value > 0)
            assertTrue(value <= 6)
        }
    }

}