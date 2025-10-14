package com.virtus.elplatform.interBD.content.typeContent.video

import com.virtus.elplatform.interfaces.Filterable
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "videoType")
data class VideoType(
    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var url: String,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    override val created: LocalDate = LocalDate.now(),

    @Id
    @GeneratedValue
    val id: Long? = null
) : Filterable()
