package com.virtus.elplatform.interBD.course

import com.virtus.elplatform.interBD.content.typeContent.img.ImgType
import com.virtus.elplatform.interBD.module.Module
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "course")
data class Course(
    var name: String,
    var description: String?,
    @ManyToOne(fetch = FetchType.LAZY)
    var img: ImgType?,
    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = [CascadeType.ALL])
    @LazyCollection(LazyCollectionOption.FALSE)
    var modules: List<Module>? = null,
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null
)
