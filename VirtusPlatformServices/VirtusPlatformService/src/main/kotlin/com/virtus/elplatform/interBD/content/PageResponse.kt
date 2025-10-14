package com.virtus.elplatform.interBD.content

import com.virtus.elplatform.interBD.content.typeContent.img.ImgType
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class PageResponse(
    content: List<ImgType?>,
    pageable: Pageable,
    totalElements: Long,
    totalPages: Int
) : PageImpl<ImgType>(content, pageable, totalElements) {
}