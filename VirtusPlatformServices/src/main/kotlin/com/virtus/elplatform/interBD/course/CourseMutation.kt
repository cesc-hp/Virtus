package com.virtus.elplatform.interBD.course

import com.virtus.elplatform.interBD.content.typeContent.img.ImgRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class CourseMutation(val courseRepository: CourseRepository, val imgRepository: ImgRepository) : GraphQLMutationResolver {

    fun newCourse(name: String, description: String?, idImg: Long?): Course {
        val img = idImg?.let { imgRepository.findById(it).get() }
        val course = Course(name, description, img)
        return courseRepository.save(course)
    }

    fun deleteCourse(id: Long): Boolean {
        courseRepository.deleteById(id)
        return true
    }

    fun updateCourse(id: Long, name: String, description: String, idImg: Long?): Course {
        val course = courseRepository.findById(id)
        val img = idImg?.let { imgRepository.findById(it).get() }

        course.ifPresent {
            it.name = name
            it.description = description
            it.img = img
            courseRepository.save(it)
        }
        return course.get()
    }
}
