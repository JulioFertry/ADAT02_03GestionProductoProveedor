package service
import model.Product
import model.Supplier
import java.util.Date


class ProductService {

    private val vat = 0.21f


    fun createProduct(category: String, name: String, desc: String?, grossPrice: Float, supplier: Supplier?): Product {
        val id = generateId(category, name, supplier)
        val netPrice = calculateNetPrice(grossPrice)
        val releaseDate = getDate()

        val product = Product(category, name, desc, grossPrice, netPrice, releaseDate, 0, supplier, id)
        return product
    }


    private fun generateId(category: String, name: String, supplier: Supplier?): String {
        val categoryPart = category.take(3)
        val namePart = name.take(3)
        val supplierPart = supplier!!.name.take(3)

        return "${categoryPart}${namePart}${supplierPart}"
    }


    private fun calculateNetPrice(grossPrice: Float): Float {
        return grossPrice * (1 + vat)
    }


    private fun getDate(): Date {
        return Date()
    }

}