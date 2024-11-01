package utils
import jakarta.persistence.*


object Utilities {

    private val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("GestionProdProv")

    fun getEntityManager(): EntityManager {
        return emf.createEntityManager()
    }

}