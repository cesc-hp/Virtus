package com.virtus.elplatform.interBD.content.typeContent.img

import com.virtus.elplatform.interBD.content.GalleryFilterInput
import com.virtus.elplatform.interBD.content.PageResponse
import com.virtus.elplatform.interBD.content.PaginationInput
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class ImgQuery internal constructor(private val imgRepository: ImgRepository) : GraphQLQueryResolver {

    fun imgById(id: Long): ImgType {
        return imgRepository.findById(id).get()
    }

    fun getAllImg(filterInput: GalleryFilterInput? = null, paginationInput: PaginationInput? = null): PageResponse {
        var result: Page<ImgType?> = Page.empty()

        val paginate = if (paginationInput != null) {
            PageRequest.of(paginationInput.page, paginationInput.size)
        } else {
            val defaultPagination = PaginationInput()
            PageRequest.of(defaultPagination.page, defaultPagination.size)
        }

        if (filterInput == null) {
            result = imgRepository.findAll(paginate)
        } else {
            if (filterInput.key == "created")
                result = imgRepository.findAllFilteredByCreatedDate(LocalDate.parse(filterInput.value), paginate)
            else if (filterInput.key == "id")
                result = imgRepository.findAllFilteredById(filterInput.value.toLong(), paginate)
        }
//        TODO("hacer manejo de excepción")
//        if (paginate.pageNumber >= result.totalPages) throw Exception("fail")

        return PageResponse(result.content, result.pageable, result.totalElements, result.totalPages)
    }
}
