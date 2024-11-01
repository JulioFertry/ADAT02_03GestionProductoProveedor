package model
import jakarta.persistence.*


@Entity
@Table
data class User (

    @Column(nullable = false, length = 20)
    val password: String,

    @Id
    val username: String
)