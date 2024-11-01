package console

object Console {

    fun showMessage(message: Any) {
        println(message.toString())
    }

    fun readInput(): String {
        return readln()
    }

}