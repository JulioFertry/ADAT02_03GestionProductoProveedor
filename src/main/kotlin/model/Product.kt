package model
import jakarta.persistence.*
import java.util.Date


@Entity
@Table
data class Product(

    @Column(length = 50, nullable = false)
    val category: String,

    @Column(length = 50, nullable = false)
    var name: String,

    @Column(length = 80, nullable = true)
    val description: String?,

    @Column(nullable = false)
    val grossPrice: Float,

    @Column(nullable = false)
    val netPrice: Float,

    @Column(nullable = false)
    val releaseDate: Date,

    @Column(nullable = false)
    var stock: Int,

    @ManyToOne
    @JoinColumn(name = "id_supplier", nullable = false)
    val supplier: Supplier?,

    @Id
    val id: String? = null
) {

    override fun toString(): String {
        return "Producto: $name\n" +
                "ID: $id\n" +
                "Categoria: $category\n" +
                "Descripcion: $description\n" +
                "Precio sin IVA: $grossPrice\n" +
                "Precio final: $netPrice\n" +
                "Fecha de alta: $releaseDate\n" +
                "Existencias: $stock\n" +
                "Proveedor: $supplier"
    }

}