package repository
import console.Console
import jakarta.persistence.*
import model.Supplier
import utils.Utilities


class SupplierRepository {

    fun getSupplierByProductId(productId: String): Supplier? {
        val em: EntityManager = Utilities.getEntityManager()
        val supplier: Supplier?

        try {
            val query = em.createQuery(
                "SELECT s FROM Supplier s WHERE s.productId = :productId",
                Supplier::class.java
            )

            query.setParameter("productId", productId)

            supplier = query.resultList.firstOrNull()
            return supplier
        } catch (e: Exception) {
            Console.showMessage("Error durante la transaccion: ($e)")
            return null
        } finally {
            em.close()
        }

    }


    fun getAllSuppliers(): List<Supplier>? {
        val em: EntityManager = Utilities.getEntityManager()
        val suppliers: List<Supplier>?

        try {
            val query = em.createQuery(
                "SELECT s FROM Supplier s",
                Supplier::class.java
            )

            suppliers = query.resultList
            return suppliers
        } catch (e: Exception) {
            Console.showMessage("Error durante la transaccion: ($e)")
            return null
        } finally {
            em.close()
        }
    }


    fun getSupplierById(id: String): Supplier? {
        val em: EntityManager = Utilities.getEntityManager()
        val supplier: Supplier?

        try {
            val query = em.createQuery(
                "SELECT s FROM Supplier s WHERE s.id = :id",
                Supplier::class.java
            )

            supplier = query.resultList.firstOrNull()
            return supplier
        } catch (e: Exception) {
            Console.showMessage("Error durante la transaccion: ($e)")
            return null
        } finally {
            em.close()
        }
    }

}