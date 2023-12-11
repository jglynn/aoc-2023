
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day08")
class Day08Test {

    private val testData = resourceAsListOfString("Day08_test.txt")
    private val realData = resourceAsListOfString("Day08_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day08(testData).solvePart1()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day08(realData).solvePart1()
            assertThat(answer).isEqualTo(11309)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day08(testData).solvePart2()
            println(answer)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day08(realData).solvePart2()
            println(answer)
        }
    }

}