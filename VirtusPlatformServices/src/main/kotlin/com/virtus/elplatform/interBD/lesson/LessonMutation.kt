package com.virtus.elplatform.interBD.lesson

import com.virtus.elplatform.interBD.content.typeContent.img.ImgRepository
import com.virtus.elplatform.interBD.module.ModuleRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class LessonMutation(
        val lessonRepository: LessonRepository,
        val moduleRepository: ModuleRepository,
        val imgRepository: ImgRepository
) :
        GraphQLMutationResolver {

    fun newLesson(title: String, idImg: Long?, moduleId: Long): Lesson {
        val img = idImg?.let { imgRepository.findById(it).get() }
        val lesson = if (moduleRepository.existsById(moduleId)) {
            Lesson(title, img, moduleRepository.findById(moduleId).get())
        } else {
            Lesson(title, img)
        }
        return lessonRepository.save(lesson)
    }

    fun deleteLesson(id: Long): Boolean {
        val lesson = lessonRepository.findById(id)
        lesson.ifPresent {
            it.module = null
            lessonRepository.save(it)
        }
        lessonRepository.deleteById(id)
        return true
    }

    fun updateLesson(id: Long, title: String, idImg: Long?): Lesson {
        val img = idImg?.let { imgRepository.findById(it).get() }
        val lesson = lessonRepository.findById(id)
        lesson.ifPresent {
            it.title = title
            it.img = img
            lessonRepository.save(it)
        }
        return lesson.get()
    }
}
