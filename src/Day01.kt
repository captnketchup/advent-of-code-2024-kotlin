import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { it.split(" ")}
            .map { row -> row.filter { it.isNotBlank() } }
            .map {it[0].toInt() to it[1].toInt() }
            .unzip()
            .toList()
            .map { it.sorted() }
            .let {
                it[0].zip(it[1]) { a, b -> abs(a - b) }
            }
            .sum()
    }

    fun part2(input: List<String>): Int {
        return input
            .map { it.split(" ")}
            .map { row -> row.filter { it.isNotBlank() } }
            .map {it[0].toInt() to it[1].toInt() }
            .unzip()
            .toList()
            .let { element ->
                element[0].map { leftItem ->
                    element[1].filter { it == leftItem }
                        .size * leftItem
                }
            }
            .sum()
    }

    // Or read a large test input from the `src/Day01.txt` file:
    val testInput = readInput("Day01")

    println("part1 result: ${part1(testInput)}")
    println("part2 result: ${part2(testInput)}")
}
