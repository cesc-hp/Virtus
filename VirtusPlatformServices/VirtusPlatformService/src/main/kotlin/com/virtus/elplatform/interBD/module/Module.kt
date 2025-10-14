package com.virtus.elplatform.interBD.module

import com.virtus.elplatform.interBD.content.typeContent.img.ImgType
import com.virtus.elplatform.interBD.course.Course
import com.virtus.elplatform.interBD.lesson.Lesson
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
@Table(name = "module")
data class Module(
        var title: String? = null,
        @ManyToOne(fetch = FetchType.LAZY)
        var img: ImgType?,
        @ManyToOne(fetch = FetchType.LAZY)
        var course: Course? = null,
        @OneToMany(mappedBy = "module", orphanRemoval = true, cascade = [CascadeType.ALL])
        @LazyCollection(LazyCollectionOption.FALSE)
        var lessons: List<Lesson>? = null,
        @Id
        @GeneratedValue
        @Column(name = "id")
        private var id: Long? = null
)
