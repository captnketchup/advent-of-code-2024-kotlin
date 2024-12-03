fun main() {
    val input = readInput("Day03").joinToString("")
    val mulRegex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
    val numRegex = Regex("""\d+(?:,\d+)*""")
    val muls = mulRegex.findAll(input)
        .map { it.value }
        .toList()
        .map {
            numRegex.findAll(it)
                .map { it.value.split(",") }
                .toList()
        }
        .map { it.flatten() }
        .map { it.map { it.toInt() } }
        .sumOf { it.reduce { a, b -> a * b } }

    println(muls)
}