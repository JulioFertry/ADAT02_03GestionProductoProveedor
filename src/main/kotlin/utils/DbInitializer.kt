package utils
import jakarta.persistence.EntityManager
import repository.ProductRepository
import repository.SupplierRepository
import repository.UserRepository
import service.ProductService
import service.SupplierService
import service.UserService


class DbInitializer {

    private val userServ = UserService()
    private val supplierServ = SupplierService()
    private val productServ = ProductService()


    fun initialize() {
        val em: EntityManager = Utilities.getEntityManager()
        em.transaction.begin()

        val user = userServ.createUser("12345", "julio")
        em.persist(user)

        val supplier1 = supplierServ.createSupplier("juanito", "Calle Juanito")
        em.persist(supplier1)
        val supplier2 = supplierServ.createSupplier("carmela", "Calle Carmelita")
        em.persist(supplier2)

        val product1 = productServ.createProduct("comida", "atun", null, 3.75f, supplier1)
        em.persist(product1)
        val product2 = productServ.createProduct("electronica", "pc", "ordenador bueno", 850.0f, supplier1)
        em.persist(product2)
        val product3 = productServ.createProduct("comida", "sushi", null, 4.80f, supplier2)
        em.persist(product3)
        val product4 = productServ.createProduct("electronica", "ps3", null, 250.0f, supplier2)
        em.persist(product4)
    }

}