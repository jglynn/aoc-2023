package org.jglynn.aoc

class Day07(private val input: List<String>) {

    fun solvePart1(): Int {

        val hands: List<Hand> = input.map {
            Hand(it.substringBefore(" "),
                    it.substringAfter(" ").toInt()) }

        return hands.sortedDescending()
            .mapIndexed { index, hand ->
                (index+1) * hand.bid }
            .sum()
    }

    fun solvePart2(): Int {
        return 0
    }

    private class Hand(
        val cards: String,
        val bid: Int
    ) : Comparable<Hand> {

        val cardRank = "23456789TJQKA"
        val value: HandValue = cards.handValue()

        private fun String.handValue(): HandValue {
            val counts = this.asSequence().groupingBy { it }.eachCount()
            return when {
                5 in counts.values -> HandValue.FIVE_KIND
                4 in counts.values -> HandValue.FOUR_KIND
                3 in counts.values && 2 in counts.values -> HandValue.FULL_HOUSE
                3 in counts.values -> HandValue.THREE_KIND
                2 == counts.filter { it.value == 2 }.count() -> HandValue.TWO_PAIR
                2 in counts.values -> HandValue.ONE_PAIR
                else -> HandValue.HIGH
            }
        }

        override fun compareTo(other: Hand): Int {
            val valueDiff = compareValues(this.value, other.value)
            return if (valueDiff != 0) valueDiff
                else { other.cards.asSequence()
                        .zip(this.cards.asSequence())
                        .find { (a, b) -> a != b }
                        ?.let { (a, b) -> cardRank.indexOf(a).compareTo(cardRank.indexOf(b)) }
                        ?: 0
                }
        }

        override fun toString(): String {
            return "Hand(bid=$bid, value=$value, cards=$cards)"
        }

        private enum class HandValue {
            FIVE_KIND,
            FOUR_KIND,
            FULL_HOUSE,
            THREE_KIND,
            TWO_PAIR,
            ONE_PAIR,
            HIGH
        }

    }

}

