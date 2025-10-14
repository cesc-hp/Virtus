package com.virtus.elplatform.interBD.content.typeContent.img

import com.virtus.elplatform.interBD.content.FileService
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import javax.servlet.http.Part

@Component
class ImgMutation(val imgRepository: ImgRepository, val fileService: FileService) : GraphQLMutationResolver {

    fun newImg(file: Part, environment: DataFetchingEnvironment): ImgType {
        var imgURL = fileService.uploadFile("image", file)
        var imgType = ImgType(file.submittedFileName, imgURL)
        imgRepository.save(imgType)
        return imgType
    }

    fun deleteImg(id: Long): Boolean {
        imgRepository.deleteById(id)
        return true
    }
}
