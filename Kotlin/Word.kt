/* Simple Word Counter */
fun main() {
    println("Enter a sentence: ")

    val input = readLine() ?: ""
    val wordCount = input.trim().split("\\s+".toRegex()).count()
    val charCount = input.replace(" ", "").length

    println("Word count: $wordCount")
    println("Character count: $charCount")
}