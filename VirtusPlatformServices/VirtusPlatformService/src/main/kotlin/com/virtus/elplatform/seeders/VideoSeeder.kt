package com.virtus.elplatform.seeders

import com.virtus.elplatform.interBD.content.FileService
import com.virtus.elplatform.interBD.content.typeContent.video.VideoMutation
import com.virtus.elplatform.interBD.content.typeContent.video.VideoRepository
import org.springframework.stereotype.Component

@Component
class VideoSeeder(val videoRepository: VideoRepository, val fileService: FileService) {
    fun init() {
        if (videoRepository.count() == 0L) {
            val mutation = VideoMutation(videoRepository, fileService)
            // save company
            /*mutation.newVideo("Primra", "Video1")
            mutation.newVideo("Segunda", "Video2")
            mutation.newVideo("Tercera", "Video3")*/
        }
    }
}
