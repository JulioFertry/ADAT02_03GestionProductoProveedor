package app
import console.Console
import repository.ProductRepository
import repository.SupplierRepository
import service.ProductService


class Operations {

    private val supplierRep = SupplierRepository()
    private val productRep = ProductRepository()
    private val productServ = ProductService()
    private val errorMssge = "Error en la operacion"




    fun addProduct01() {
        try {
            Console.showMessage("Categoria: ")
            val category = Console.readInput()

            Console.showMessage("Nombre: ")
            val name = Console.readInput()

            Console.showMessage("Descripcion: ")
            val description = Console.readInput()

            Console.showMessage("Precio sin IVA: ")
            val grossPrice = Console.readInput().toFloat()

            Console.showMessage("ID del proveedor: ")
            val supplierId = Console.readInput()
            val supplier = supplierRep.getSupplierById(supplierId)

            if (supplier != null) {
                val product = productServ.createProduct(category, name, description, grossPrice, supplier)
                productRep.releaseProduct(product)
                Console.showMessage("Producto creado")
            } else {
                Console.showMessage("Error al crear el producto")
            }
        } catch (e: Exception) {
            Console.showMessage("$errorMssge: ($e)")
        }

    }


    fun deleteProduct02() {
        try {
            Console.showMessage("ID del producto: ")
            val id = Console.readInput()

            productRep.deleteProduct(id)
            Console.showMessage("Producto eliminado")
        } catch (e: Exception) {
            Console.showMessage("$errorMssge: ($e)")
        }

    }


    fun modifyProductName03() {
        try {
            Console.showMessage("ID del producto: ")
            val id = Console.readInput()

            Console.showMessage("Nuevo nombre: ")
            val newName = Console.readInput()

            productRep.modifyProductName(id, newName)
            Console.showMessage("Cambio realizado")
        } catch (e: Exception) {
            Console.showMessage("$errorMssge: ($e)")
        }

    }


    fun modifyProductStock04() {
        try {
            Console.showMessage("ID del producto: ")
            val id = Console.readInput()

            Console.showMessage("Nuevo stock: ")
            val newStock = Console.readInput().toInt()

            productRep.modifyProductStock(id, newStock)
            Console.showMessage("Cambio realizado")
        } catch (e: Exception) {
            Console.showMessage("$errorMssge: ($e)")
        }

    }


    fun getProduct05() {
        try {
            Console.showMessage("ID del producto: ")
            val id = Console.readInput()

            val product = productRep.getProduct(id)

            if (product != null) {
                Console.showMessage(product.toString())
            } else {
                Console.showMessage("Producto no encontrado")
            }
        } catch (e: Exception) {
            Console.showMessage("$errorMssge: ($e)")
        }

    }


    fun getProductsWithStock06() {
        try {
            val products = productRep.getProductsWithStock()

            if (products.isNullOrEmpty()) {
                Console.showMessage("No hay productos con stock")
            } else {
                products.forEach { Console.showMessage(it.toString()) }
            }
        } catch (e: Exception) {
            Console.showMessage("$errorMssge: ($e)")
        }

    }


    fun getProductsWithNoStock07() {
        try {
            val products = productRep.getProductsWithNoStock()

            if (products.isNullOrEmpty()) {
                Console.showMessage("No hay productos sin stock")
            } else {
                products.forEach { Console.showMessage(it.toString()) }
            }
        } catch (e: Exception) {
            Console.showMessage("$errorMssge: ($e)")
        }

    }


    fun getSupplierByProductId08() {
        try {
            Console.showMessage("ID del producto:")
            val id = Console.readInput()

            val supplier = supplierRep.getSupplierByProductId(id)

            if (supplier != null) {
                Console.showMessage(supplier.toString())
            } else {
                Console.showMessage("Proveedor no encontrado")
            }
        } catch (e: Exception) {
            Console.showMessage("$errorMssge: ($e)")
        }

    }


    fun getAllSuppliers09() {
        try {
            val suppliers = supplierRep.getAllSuppliers()

            if (suppliers.isNullOrEmpty()) {
                Console.showMessage("No hay proveedores")
            } else {
                suppliers.forEach { Console.showMessage(it.toString()) }
            }
        } catch (e: Exception) {
            Console.showMessage("$errorMssge: ($e)")
        }

    }

}