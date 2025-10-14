package com.virtus.elplatform.seeder

import com.virtus.elplatform.seeders.ContentSeeder
import com.virtus.elplatform.seeders.CourseSeeder
import com.virtus.elplatform.seeders.FileSeeder
import com.virtus.elplatform.seeders.ImgSeeder
import com.virtus.elplatform.seeders.LessonSeeder
import com.virtus.elplatform.seeders.ModuleSeeder
import com.virtus.elplatform.seeders.VideoSeeder
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DatabaseSeeder(
    var lessonSeeder: LessonSeeder,
    var courseSeeder: CourseSeeder,
    var contentSeeder: ContentSeeder,
    var videoSeeder: VideoSeeder,
    var imgSeeder: ImgSeeder,
    var fileSeeder: FileSeeder,
    var moduleSeeder: ModuleSeeder
) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        /*videoSeeder.init()
        imgSeeder.init()
        fileSeeder.init()
        courseSeeder.init()
        moduleSeeder.init()
        lessonSeeder.init()
        contentSeeder.init()*/
    }
}
