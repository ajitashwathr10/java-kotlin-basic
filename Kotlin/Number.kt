/* Number Guessing */
fun main() {
    val number = (1..100).random()
    var attempts = 0

    while(true) {
        print("Guess (1 - 100): ")
        val guess = readLine()?.toIntOrNull() ?: continue
        attempts++

        when {
            guess < number -> println("Higher!")
            guess > number -> println("Lower!")
            else -> {
                println("Correct!")
                println("Attempts: $attempts")
                break
            }
        }
    }
}