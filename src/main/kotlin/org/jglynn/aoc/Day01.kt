package org.jglynn.aoc

class Day01(private val input: List<String>) {

    fun solvePart1(): Int =
        calibrationValues(input).sum()

    fun solvePart2(): Int {
        val replacedInput = replaceTextWithNumbers(input)
        return calibrationValues(replacedInput).sum()
    }

    private fun calibrationValues(artsyValues: List<String>): List<Int>  {
        return artsyValues
            .map { artsy -> artsy.filter { it.isDigit() } } // remove non-digit characters
            .map { charArrayOf(it.first(), it.last()).concatToString().toInt() } // combine first and last as an integer
    }

    private fun replaceTextWithNumbers(inputList: List<String>): List<String> {
        return inputList.map { original ->
            replacements.entries.fold(original) { acc, (text, number) ->
                acc.replace(text.lowercase(), number)
            }
        }
    }

    private val replacements = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )
}
