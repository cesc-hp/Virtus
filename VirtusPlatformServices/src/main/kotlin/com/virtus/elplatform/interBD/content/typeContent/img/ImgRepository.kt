package com.virtus.elplatform.interBD.content.typeContent.img

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate

interface ImgRepository : JpaRepository<ImgType?, Long?> {
    @Query("select i from ImgType i where i.created = :value")
    fun findAllFilteredByCreatedDate(@Param("value") value: LocalDate, pageable: Pageable): Page<ImgType?>;

    @Query("select i from ImgType i where i.id = :value")
    fun findAllFilteredById(@Param("value") value: Long, pageable: Pageable): Page<ImgType?>;
}
