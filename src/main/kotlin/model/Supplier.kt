package model
import jakarta.persistence.*


@Entity
@Table
data class Supplier(

    @Column(length = 50, nullable = false)
    val name: String,

    @Column(nullable = false)
    val address: String,

    @OneToMany(mappedBy = "supplier", cascade = [CascadeType.ALL])
    val products: MutableList<Product>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    override fun toString(): String {
        return "Proovedor: $name\n" +
                "ID: $id\n" +
                "Direccion: $address\n"
    }

}