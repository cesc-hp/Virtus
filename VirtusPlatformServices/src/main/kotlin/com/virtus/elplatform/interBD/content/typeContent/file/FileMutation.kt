package com.virtus.elplatform.interBD.content.typeContent.file

import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class FileMutation(val fileRepository: FileRepository) : GraphQLMutationResolver {

    fun newFile(url: String, name: String): FileType {
        val fileType = FileType(url, name)
        return fileRepository.save(fileType)
    }
}
