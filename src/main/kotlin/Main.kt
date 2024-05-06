package ca.tetervak

import ca.tetervak.ca.tetervak.dicecube.DiceCube
import java.util.*

fun main() {
    println("Hello from DiceCube App!")

    val cube1 = DiceCube()
    cube1.roll()

    println("value1 = ${cube1.value}")
    println("cube1 = $cube1")

    repeat(5) {
        println("value1 = " + cube1.run { roll(); value })
    }

    with(cube1) {
        reset()
        roll()
    }
    println("cube1 = $cube1")

    // providing the seed value makes the roll value sequence always the same
    val cube2 = DiceCube(random = Random(12))
    repeat(5) {
        println("value2 = " + cube2.run { roll(); value })
    }
}