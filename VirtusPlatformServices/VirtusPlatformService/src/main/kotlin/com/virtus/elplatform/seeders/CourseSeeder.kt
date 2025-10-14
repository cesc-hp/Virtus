package com.virtus.elplatform.seeders

import com.virtus.elplatform.interBD.content.typeContent.img.ImgRepository
import com.virtus.elplatform.interBD.course.CourseMutation
import com.virtus.elplatform.interBD.course.CourseRepository
import org.springframework.stereotype.Component

@Component
class CourseSeeder(val courseRepository: CourseRepository, val imgRepository: ImgRepository) {
    fun init() {
        if (courseRepository.count() == 0L) {
            val mutation = CourseMutation(courseRepository, imgRepository)
            // save course
            /*mutation.newCourse(
                "RRHH",
                "Descripcion plates, salads & sandwiches in an intimate setting.",
                "team_14.jpg"
            )
            mutation.newCourse(
                "Otro Mas",
                "Descripcion plates, salads & sandwiches in an intimate setting.",
                "team_15.jpg"
            )*/
        }
    }
}
