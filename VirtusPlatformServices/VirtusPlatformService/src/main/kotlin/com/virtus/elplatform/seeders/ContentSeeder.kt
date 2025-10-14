package com.virtus.elplatform.seeders

import com.virtus.elplatform.interBD.content.ContentMutation
import com.virtus.elplatform.interBD.content.ContentRepository
import com.virtus.elplatform.interBD.content.typeContent.file.FileRepository
import com.virtus.elplatform.interBD.content.typeContent.img.ImgRepository
import com.virtus.elplatform.interBD.content.typeContent.text.TextRepository
import com.virtus.elplatform.interBD.content.typeContent.video.VideoRepository
import com.virtus.elplatform.interBD.lesson.LessonRepository
import org.springframework.stereotype.Component

@Component
class ContentSeeder(
    val contentRepository: ContentRepository,
    val lessonRepository: LessonRepository,
    val videoRepository: VideoRepository,
    val imgRepository: ImgRepository,
    val fileRepository: FileRepository,
    val textRepository: TextRepository
) {
    fun init() {
        if (contentRepository.count() == 0L) {
            val mutation = ContentMutation(
                contentRepository,
                lessonRepository,
                videoRepository,
                imgRepository,
                fileRepository,
                textRepository
            )
            // save content
           /* mutation.newContent("DFDFDF", 9)
            mutation.newContent("para el", 9)*/
        }
    }
}
