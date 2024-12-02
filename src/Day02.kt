fun main() {
    fun IsSafe(input: List<Int>): Boolean {
        val sortedAscending = input.sorted()
        val sortedDescending = input.sortedDescending()

        if (input != sortedAscending && input != sortedDescending) {
            return false
        }

        val inputCopy = input.toMutableList()
        var iteratorElement = inputCopy.removeFirst()
        inputCopy.forEach{
            if (  kotlin.math.abs(it - iteratorElement) !in 1..3) {
                return false
            }
            iteratorElement = it
        }

        return true
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

    val input = readInput("Day02")

    println(part1(input))

//    fun part1(input: List<Int>): Int {}
}