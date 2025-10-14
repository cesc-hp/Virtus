package com.virtus.elplatform.seeders

import com.virtus.elplatform.interBD.content.typeContent.img.ImgRepository
import com.virtus.elplatform.interBD.course.CourseRepository
import com.virtus.elplatform.interBD.module.ModuleMutation
import com.virtus.elplatform.interBD.module.ModuleRepository
import org.springframework.stereotype.Component

@Component
class ModuleSeeder(val moduleRepository: ModuleRepository,
                   val courseRepository: CourseRepository,
                   val imgRepository: ImgRepository) {
    fun init() {
        /*if (moduleRepository.count() == 0L) {
            val mutation = ModuleMutation(moduleRepository, courseRepository, imgRepository)
            // save course
            mutation.newModule(
                "Capitulo 1",
                "Descripcion plates, salads & sandwiches in an intimate setting.",
                6
            )
            mutation.newModule(
                "Capitulo 2",
                "Descripcion plates, salads & sandwiches in an intimate setting.",
                6
            )
        }*/
    }
}
