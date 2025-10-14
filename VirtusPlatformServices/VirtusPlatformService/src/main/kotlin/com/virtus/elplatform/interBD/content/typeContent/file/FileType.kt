package com.virtus.elplatform.interBD.content.typeContent.file

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "fileType")
class FileType(
    var url: String? = null,
    var name: String? = null,
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null
)
