package service
import model.User


class UserService() {

    fun createUser(name: String, password: String): User {
        val user = User(name, password)
        return user
    }

}