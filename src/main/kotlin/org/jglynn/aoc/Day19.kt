package org.jglynn.aoc

import org.jglynn.aoc.Utils.substringBetween

class Day19(private val input: String) {

    fun solvePart1(): Int {
        val (workflowList, partsList) = input.split("\n\n")
        val parts = partsList.lines().map { Part.from(it) }
        val workflows = parseWorkflows(workflowList)
        val initialWorkflow = workflows["in"] ?: throw IllegalArgumentException("Initial workflow was not found.")
        return parts
            .filter { it.process(initialWorkflow, workflows) == "A" }
            .sumOf { it.total() }
    }

    fun solvePart2(): Int {
        return 0
    }

    private fun parseWorkflows(workflowList: String): Map<String, Workflow> {
        return workflowList.lines().associate { line ->
            val name = line.substringBefore("{")
            val (ruleText, defaultOutcome) = line
                .substringBetween("{", "}")
                .split(",")
                .tailDestructure()
            val rules = ruleText.map { Rule.from(it) }
            name to Workflow(name, rules, defaultOutcome)
        }
    }

    private fun <T> List<T>.tailDestructure() = Pair(dropLast(1), last())

    data class Workflow(
        val name: String,
        val rules: List<Rule>,
        val defaultOutcome: String) {

        fun checkRules(part: Part): String {
            rules.forEach { rule->
                if( (rule.greater && part.value(rule.category) > rule.limit)
                    || (!rule.greater && part.value(rule.category) < rule.limit) ) {
                    return rule.outcome
                }
            }
            return defaultOutcome;
        }
    }

    data class Rule(
        val category: String,
        val greater: Boolean,
        val limit: Int,
        val outcome: String) {

        companion object {
            fun from(text: String): Rule {
                val (category, limit, outcome) = text.split(">", "<", ":")
                return Rule(category, text.contains(">"), limit.toInt(), outcome)
            }
        }
    }

    data class Part(val categories: Map<String, Int>) {

        fun total(): Int {
            return categories.values.sum()
        }

        fun value(category: String): Int {
            return categories[category]!!
        }

        tailrec fun process(flow: Workflow, flows: Map<String, Workflow> ): String {
            val outcome = flow.checkRules(this)
            return if (outcome.length == 1) outcome
            else process(flows[outcome]!!, flows)
        }

        companion object {
            fun from(text: String): Part {
                val categories = text
                    .substringBetween("{", "}")
                    .split(",")
                    .associate {
                        val (key, value) = it.split("=")
                        key to value.toInt()
                    }
                return Part(categories)
            }
        }
    }

}