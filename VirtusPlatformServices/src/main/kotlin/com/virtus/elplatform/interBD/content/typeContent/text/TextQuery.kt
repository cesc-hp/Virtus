package com.virtus.elplatform.interBD.content.typeContent.text

import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class TextQuery internal constructor(private val textRepository: TextRepository) : GraphQLQueryResolver {

    fun textById(id: Long): TextType {
        return textRepository.findById(id).get()
    }
}
