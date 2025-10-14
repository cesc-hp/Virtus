package com.virtus.elplatform.seeders

import com.virtus.elplatform.interBD.content.typeContent.img.ImgRepository
import com.virtus.elplatform.interBD.lesson.LessonMutation
import com.virtus.elplatform.interBD.lesson.LessonRepository
import com.virtus.elplatform.interBD.module.ModuleRepository
import org.springframework.stereotype.Component

@Component
class LessonSeeder(val lessonRepository: LessonRepository,
                   val moduleRepository: ModuleRepository,
                   val imgRepository: ImgRepository) {
    fun init() {
        /*if (lessonRepository.count() == 0L) {
            val mutation = LessonMutation(lessonRepository, moduleRepository, imgRepository)
            // save lesson
            mutation.newLesson("Lesson 1", "sdsd", 8)
            /*mutation.newLesson("Ramon",7)
            mutation.newLesson("Pelayo",7)
            mutation.newLesson("Juliio",7)
            mutation.newLesson("Cesc",7)
            mutation.newLesson("Otro",8)
            mutation.newLesson("Estudent",8)*/
        }*/
    }
}
