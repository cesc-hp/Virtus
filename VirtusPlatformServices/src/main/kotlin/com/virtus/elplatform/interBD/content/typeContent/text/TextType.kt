package com.virtus.elplatform.interBD.content.typeContent.text

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "textType")
data class TextType(
    var text: String? = null,
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null
)
