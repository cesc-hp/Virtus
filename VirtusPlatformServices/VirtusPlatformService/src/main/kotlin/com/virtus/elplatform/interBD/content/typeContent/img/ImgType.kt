package com.virtus.elplatform.interBD.content.typeContent.img

import com.virtus.elplatform.interfaces.Filterable
import java.time.LocalDate
import java.time.LocalDate.now
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "imgType")
data class ImgType(
    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var url: String,

    @Column(nullable = false)
    override val created: LocalDate = now(),

    @Id
    @GeneratedValue
    val id: Long? = null
) : Filterable()
