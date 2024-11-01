package service
import model.Supplier


class SupplierService {

    fun createSupplier(name: String, address: String): Supplier {
        val supplier = Supplier(name, address, mutableListOf())
        return supplier
    }

}