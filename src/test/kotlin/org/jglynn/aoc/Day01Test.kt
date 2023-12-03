
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {

    // Arrange
    private val testDataP1 = resourceAsListOfString("Day01_p1_test.txt")
    private val testDataP2 = resourceAsListOfString("Day01_p2_test.txt")
    private val realData = resourceAsListOfString("Day01_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day01(testDataP1).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(142)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day01(realData).solvePart1()

            println("Answer = $answer")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        //@Test
        fun `Matches example`() {

            val answer = Day01(testDataP2).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(281)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day01(realData).solvePart2()

            println("Answer = $answer")
        }
    }


}