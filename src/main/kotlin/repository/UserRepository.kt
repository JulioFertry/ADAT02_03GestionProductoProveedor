package repository
import console.Console
import jakarta.persistence.*
import model.User
import utils.Utilities


class UserRepository {

    fun login(userInput: String, passInput: String): User? {
        val em: EntityManager = Utilities.getEntityManager()
        val user: User?

        try {
            val query = em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username and u.password = :password",
                User::class.java
            )

            query.setParameter("username", userInput)
            query.setParameter("password", passInput)

            user = query.resultList.firstOrNull()
            return user
        } catch (e: Exception) {
            Console.showMessage("Error durante el login: ($e)")
            return null
        } finally {
            em.close()
            Console.showMessage("CERRADO")
        }

    }


    fun addUser() {

    }

}