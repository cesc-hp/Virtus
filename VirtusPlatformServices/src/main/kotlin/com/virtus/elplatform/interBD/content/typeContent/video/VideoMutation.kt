package com.virtus.elplatform.interBD.content.typeContent.video

import com.virtus.elplatform.interBD.content.FileService
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import javax.servlet.http.Part

@Component
class VideoMutation(val videoRepository: VideoRepository, val fileService: FileService) : GraphQLMutationResolver {

    fun newVideo(file: Part, title: String, description: String, environment: DataFetchingEnvironment): VideoType {
        val videoURL = fileService.uploadFile("video", file)
        val videoType = if (title.isBlank()) {
            VideoType(file.submittedFileName, file.submittedFileName, videoURL, description)
        } else {
            VideoType(file.submittedFileName, title, videoURL, description)
        }

        videoRepository.save(videoType)
        return videoType
    }

    fun updateVideo(id: Long, title: String, description: String): VideoType {
        val video = videoRepository.findById(id)

        video.ifPresent {
            it.title = title
            it.description = description
            videoRepository.save(it)
        }
        return video.get()
    }

    fun deleteVideo(id: Long): Boolean {
        videoRepository.deleteById(id)
        return true
    }
}
