/* Simple Calculator */
class Calculator {
    fun add(a: Double, b: Double) = a + b
    fun subtract(a: Double, b: Double) = a - b
    fun multiply(a: Double, b: Double) = a * b
    fun divide(a: Double, b: Double): Double {
        require(b != 0.0) {"Divide by zero"}
        return a / b
    }
}

fun main() {
    val calculator = Calculator()
    println("Kotlin Simple Calculator")
    while(true) {
        println("\nEnter an operation (+, -, *, /) or 'q' to quit: ")
        val operation = readLine()  
        if(operation == 'q') {
            break
        }
        println("Enter first number: ")
        val num1 = readLine()?.toDoubleOrNull()
        println("Enter second number: ")
        val num2 = readLine()?.toDoubleOrNull()

        if(num1 == null || num2 == null) {
            println("Invalid input. Please enter valid numbers.")
            continue
        }
        val result = when(operation) {
            "+" -> calculator.add(num1, num2)
            "-" -> calculator.subtract(num1, num2)
            "*" -> calculator.multiply(num1,  num2)
            "/" -> try {
                calculator.divide(num1, num2)
            } catch(e: IllegalArgumentException) {
                println(e.message)
                continue
            }
            else -> {
                println("Invalid operation. Please enter a valid operation.")
                continue
            }
        }
        println("Result: $result")
    }
}