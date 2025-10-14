package com.virtus.elplatform.interBD.content.typeContent.text

import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class TextMutation(val textRepository: TextRepository) : GraphQLMutationResolver {

    fun newText(text: String): TextType {
        var textType = TextType(text)
        textRepository.save(textType)
        return textType
    }

    fun deleteText(id: Long): Boolean {
        textRepository.deleteById(id)
        return true
    }
}
