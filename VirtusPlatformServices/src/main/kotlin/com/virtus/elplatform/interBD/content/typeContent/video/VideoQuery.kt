package com.virtus.elplatform.interBD.content.typeContent.video

import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class VideoQuery internal constructor(private val videoRepository: VideoRepository) : GraphQLQueryResolver {

    fun videoById(id: Long): VideoType {
        return videoRepository.findById(id).get()
    }
    fun getAllVideo(): Iterable<VideoType?> {
        return videoRepository.findAll()
    }
}
