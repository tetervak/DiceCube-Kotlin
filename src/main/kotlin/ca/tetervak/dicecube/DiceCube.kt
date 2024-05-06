package ca.tetervak.ca.tetervak.dicecube

import java.lang.IllegalArgumentException
import java.util.Random

// One die object, for random values from 1 to 6
class DiceCube(
    val initValue: Int = DEFAULT_INIT_VALUE,
    private val random: Random = Random()
) {

    companion object {
        const val DEFAULT_INIT_VALUE: Int = 1
    }

    var value: Int = DEFAULT_INIT_VALUE
        set(n) {
            if (n in 1..6) {
                field = n
            } else {
                throw IllegalArgumentException("Illegal die value $n")
            }
        }

    init {
        value = initValue
    }

    fun roll() {
        value = random.nextInt(1,7)
    }

    fun reset() {
        value = initValue
    }

    override fun toString() = "DiceCube(value = $value)"
}
