
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day02Test {

    private val testData = resourceAsListOfString("Day02_test.txt")
    private val realData = resourceAsListOfString("Day02_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day02(testData).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day02(realData).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(2162)

        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {

            val answer = Day02(testData).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(2286)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day02(realData).solvePart2()

            println("Answer = $answer")

            // Assert
            assertThat(answer).isEqualTo(72513)
        }
    }


}