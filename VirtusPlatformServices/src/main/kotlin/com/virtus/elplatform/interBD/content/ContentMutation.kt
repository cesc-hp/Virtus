package com.virtus.elplatform.interBD.content

import com.virtus.elplatform.interBD.content.typeContent.file.FileRepository
import com.virtus.elplatform.interBD.content.typeContent.img.ImgRepository
import com.virtus.elplatform.interBD.content.typeContent.text.TextRepository
import com.virtus.elplatform.interBD.content.typeContent.video.VideoRepository
import com.virtus.elplatform.interBD.lesson.LessonRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class ContentMutation(
    val contentRepository: ContentRepository,
    val lessonRepository: LessonRepository,
    val videoRepository: VideoRepository,
    val imgRepository: ImgRepository,
    val fileRepository: FileRepository,
    val textRepository: TextRepository
) : GraphQLMutationResolver {

    fun newContent(typeContent: String, idType: Long?, description: String, lessonId: Long): Content {
        var content = Content()
        content.description = description
        if (lessonRepository.existsById(lessonId)) {
            content.lesson = lessonRepository.findById(lessonId).get()
        }
        when (typeContent) {
            ETypeContent.TYPE_VIDEO.name ->
                if (idType?.let { videoRepository.existsById(it) }!!) {
                    content.typeContent = ETypeContent.TYPE_VIDEO
                    content.idType = idType
                }
            ETypeContent.TYPE_FOTO.name ->
                if (idType?.let { imgRepository.existsById(it) }!!) {
                    content.typeContent = ETypeContent.TYPE_FOTO
                    content.idType = idType
                }
            ETypeContent.TYPE_FILE.name ->
                if (idType?.let { fileRepository.existsById(it) }!!) {
                    content.typeContent = ETypeContent.TYPE_FILE
                    content.idType = idType
                }
            ETypeContent.TYPE_TEXT.name ->
                if (idType?.let { textRepository.existsById(it) }!!) {
                    content.typeContent = ETypeContent.TYPE_TEXT
                    content.idType = idType
                }
        }
        return contentRepository.save(content)
    }

    fun deleteContent(id: Long): Boolean {
        val content = contentRepository.findById(id)
        content.ifPresent {
            it.lesson = null
            contentRepository.save(it)
        }
        contentRepository.deleteById(id)
        return true
    }
}
