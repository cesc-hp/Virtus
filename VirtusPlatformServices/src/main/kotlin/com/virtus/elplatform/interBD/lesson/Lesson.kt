package com.virtus.elplatform.interBD.lesson

import com.virtus.elplatform.interBD.content.Content
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
@Table(name = "lesson")
data class Lesson(
        var title: String? = null,
        @ManyToOne(fetch = FetchType.LAZY)
        var img: ImgType?,
        @ManyToOne(fetch = FetchType.LAZY)
        var module: Module? = null,
        @OneToMany(mappedBy = "lesson", orphanRemoval = true, cascade = [CascadeType.ALL])
        @LazyCollection(LazyCollectionOption.FALSE)
        var contents: List<Content>? = null,
        @Id
        @GeneratedValue
        @Column(name = "id")
        private var id: Long? = null
)
