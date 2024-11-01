package repository
import console.Console
import jakarta.persistence.*
import model.Product
import utils.Utilities


class ProductRepository {

    fun releaseProduct(product: Product) {
        val em: EntityManager = Utilities.getEntityManager()

        try {
            em.transaction.begin()
            em.persist(product)
            em.transaction.commit()
        } catch (e: Exception) {
            em.transaction.rollback()
            Console.showMessage("Error durante la transaccion: ($e)")
        } finally {
            em.close()
        }

    }


    fun deleteProduct(productId: String) {
        val em: EntityManager = Utilities.getEntityManager()

        try {
            em.transaction.begin()

            val query = em.createQuery(
                "SELECT p FROM Product p WHERE p.id = :id",
                Product::class.java
            )

            query.setParameter("id", productId)
            val product = query.resultList.firstOrNull()
            if (product != null) {
                em.remove(product)
            } else {
                throw Exception("No existe el producto")
            }

            em.transaction.commit()
        } catch (e: Exception) {
            em.transaction.rollback()
            Console.showMessage("Error durante la transaccion: ($e)")
        } finally {
            em.close()
        }

    }


    fun modifyProductName(productId: String, newName: String) {
        val em: EntityManager = Utilities.getEntityManager()

        try {
            em.transaction.begin()

            val query = em.createQuery(
                "SELECT p FROM Product p WHERE p.id = :id",
                Product::class.java
            )

            query.setParameter("id", productId)
            val product = query.resultList.firstOrNull()
            if (product != null) {
                product.name = newName
                em.merge(product)
            } else {
                throw Exception("No existe el producto")
            }

            em.transaction.commit()
        } catch (e: Exception) {
            em.transaction.rollback()
            Console.showMessage("Error durante la transaccion: ($e)")
        } finally {
            em.close()
        }

    }


    fun modifyProductStock(productId: String, newStock: Int) {
        val em: EntityManager = Utilities.getEntityManager()

        try {
            em.transaction.begin()

            val query = em.createQuery(
                "SELECT p FROM Product p WHERE p.id = :id",
                Product::class.java
            )

            query.setParameter("id", productId)
            val product = query.resultList.firstOrNull()
            if (product != null) {
                product.stock = newStock
                em.merge(product)
            } else {
                throw Exception("No existe el producto")
            }

            em.transaction.commit()
        } catch (e: Exception) {
            em.transaction.rollback()
            Console.showMessage("Error durante la transaccion: ($e)")
        } finally {
            em.close()
        }

    }


    fun getProduct(productId: String): Product? {
        val em: EntityManager = Utilities.getEntityManager()

        try {
            val query = em.createQuery(
                "SELECT p FROM Product p WHERE p.id = :id",
                Product::class.java
            )

            query.setParameter("id", productId)
            val product = query.resultList.firstOrNull()
            return product
        } catch (e: Exception) {
            Console.showMessage("Error durante la transaccion: ($e)")
            return null
        } finally {
            em.close()
        }

    }


    fun getProductsWithStock(): List<Product>? {
        val em: EntityManager = Utilities.getEntityManager()

        try {
            val query = em.createQuery(
                "SELECT p FROM Product p WHERE p.stock > 0",
                Product::class.java
            )

            val products = query.resultList
            return products
        } catch (e: Exception) {
            Console.showMessage("Error durante la transaccion: ($e)")
            return null
        } finally {
            em.close()
        }

    }


    fun getProductsWithNoStock(): List<Product>? {
        val em: EntityManager = Utilities.getEntityManager()

        try {
            val query = em.createQuery(
                "SELECT p FROM Product p WHERE p.stock = 0",
                Product::class.java
            )

            val products = query.resultList
            return products
        } catch (e: Exception) {
            Console.showMessage("Error durante la transaccion: ($e)")
            return null
        } finally {
            em.close()
        }

    }

}