package com.virtus.elplatform.interBD.content

import com.virtus.elplatform.interBD.lesson.Lesson
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "content")
data class Content(
    var description: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    var lesson: Lesson? = null,
    @Enumerated(EnumType.STRING)
    var typeContent: ETypeContent? = null,
    var idType: Long? = null,
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null
)
