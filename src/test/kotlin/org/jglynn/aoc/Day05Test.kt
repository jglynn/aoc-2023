
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {

    private val testData = resourceAsListOfString("Day05_test.txt")
    private val realData = resourceAsListOfString("Day05_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day05(testData).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(35)
        }

        //@Test
        fun `Actual answer`() {

            val answer = Day05(realData).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(157211394)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        //@Test
        fun `Matches example`() {

            val answer = Day05(testData).solvePart2()
            println("Answer = $answer")
        }

        //@Test
        fun `Actual answer`() {

            val answer = Day05(realData).solvePart2()
            println("Answer = $answer")
        }
    }


}