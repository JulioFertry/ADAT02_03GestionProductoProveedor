package model
import jakarta.persistence.*
import java.util.Date


@Entity
@Table(name = "Producto")
data class Product(

    @Column(name = "categoria")
    val category: String,

    @Column(name = "nombre")
    val name: String,

    @Column(name = "descripcion")
    val description: String,

    @Column(name = "precio_sin_iva")
    val grossPrice: Float,

    @Column(name = "precio_con_iva")
    val netPrice: Float,

    @Column(name = "fecha_alta")
    val releaseDate: Date,

    @Column(name = "existencias")
    val stock: Int,

    @Column(name = "proveedor")
    val supplier: Supplier,

    @Id
    val id: String

)