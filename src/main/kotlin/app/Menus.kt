package app
import console.Console
import model.User
import repository.UserRepository


class Menus {

    private val operator = Operations()
    private val userRep = UserRepository()


    fun loginMenu() {
        Console.showMessage("Introduzca su nombre de usuario: ")
        val username = Console.readInput()

        Console.showMessage("Introduzca su contraseña: ")
        val password = Console.readInput()

        val user: User? = userRep.login(username, password)

        if (user != null) {
            Console.showMessage("Bienvenido, ${user.username}")
            appMenu()
        } else {
            Console.showMessage("El usuario no existe")
        }

    }


    private fun appMenu() {
        var option = "hola"

        while (option != "0") {
            Console.showMessage("1. Alta producto")
            Console.showMessage("2. Baja producto")
            Console.showMessage("3. Modificar nombre producto")
            Console.showMessage("4. Modificar stock producto")
            Console.showMessage("5. Obtener producto")
            Console.showMessage("6. Obtener productos con stock")
            Console.showMessage("7. Obtener productos sin stock")
            Console.showMessage("8. Obtener proveedor de 1 producto")
            Console.showMessage("9. Obtener todos los proveedores")
            Console.showMessage("0. Salir")
            Console.showMessage("Introduzca una opcion: ")
            option = readln()
            performOption(option)
        }

    }


    private fun performOption(option: String) {
        when (option) {
            "0" -> Console.showMessage("Cerrando aplicacion...")
            "1" -> operator.addProduct01()
            "2" -> operator.deleteProduct02()
            "3" -> operator.modifyProductName03()
            "4" -> operator.modifyProductStock04()
            "5" -> operator.getProduct05()
            "6" -> operator.getProductsWithStock06()
            "7" -> operator.getProductsWithNoStock07()
            "8" -> operator.getSupplierByProductId08()
            "9" -> operator.getAllSuppliers09()
            else -> Console.showMessage("La opcion no es valida\n")
        }
    }

}