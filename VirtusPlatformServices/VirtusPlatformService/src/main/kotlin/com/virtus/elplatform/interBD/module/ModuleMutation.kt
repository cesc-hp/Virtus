package com.virtus.elplatform.interBD.module

import com.virtus.elplatform.interBD.content.typeContent.img.ImgRepository
import com.virtus.elplatform.interBD.course.CourseRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class ModuleMutation(val moduleRepository: ModuleRepository,
                     val courseRepository: CourseRepository,
                     val imgRepository: ImgRepository) : GraphQLMutationResolver {

    fun newModule(title: String, idImg: Long?, courseId: Long): Module {
        val img = idImg?.let { imgRepository.findById(it).get() }
        val module = if (courseRepository.existsById(courseId)) {
            Module(title, img, courseRepository.findById(courseId).get())
        } else {
            Module(title, img)
        }
        return moduleRepository.save(module)
    }

    fun deleteModule(id: Long): Boolean {
        val module = moduleRepository.findById(id)
        module.ifPresent {
            it.course = null
            moduleRepository.save(it)
        }
        moduleRepository.deleteById(id)
        return true
    }

    fun updateModule(id: Long, title: String, idImg: Long?): Module {
        val img = idImg?.let { imgRepository.findById(it).get() }
        val module = moduleRepository.findById(id)
        module.ifPresent {
            it.title = title
            it.img = img
            moduleRepository.save(it)
        }
        return module.get()
    }
}
