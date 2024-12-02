fun main() {
    fun IsSafe(input: List<Int>): Boolean {
        val sortedAscending = input.sorted()
        val sortedDescending = input.sortedDescending()

        if (input != sortedAscending && input != sortedDescending) {
            return false
        }

        val inputCopy = input.toMutableList()
        var iteratorElement = inputCopy.removeFirst()
        inputCopy.forEach {
            if (kotlin.math.abs(it - iteratorElement) !in 1..3) {
                return false
            }
            iteratorElement = it
        }

        return true
    }

    fun IsSafeWithError(input: List<Int>): Boolean {
        if (IsSafe(input)) {
            return true
        }

        input.forEachIndexed { index, element ->
            val mutableInput = input.toMutableList().apply { removeAt(index) }
            if (IsSafe(mutableInput)) {
                return true
            }
        }
        return false
    }

    fun part1(input: List<String>): Int {
        return input
            .map { it.split(" ") }
            .map {
                it.map { element ->
                    element.toInt()
                }
            }
            .map { IsSafe(it) }
            .count { it }

    }

    fun part2(input: List<String>): Int {
        return input
            .map { it.split(" ") }
            .map {
                it.map { element ->
                    element.toInt()
                }
            }
            .map { IsSafeWithError(it) }
            .count { it }
    }

    val input = readInput("Day02")

    println("part1: ${part1(input)}")
    println("part2: ${part2(input)}")
}