package model
import jakarta.persistence.*


@Entity
@Table(name = "Proveedor")
data class Supplier(

    @Column(name = "nombre")
    val name: String,

    @Column(name = "direccion")
    val address: String,

    @Column(name = "productos")
    val products: List<Product>,

    @Id
    val id: Long

)