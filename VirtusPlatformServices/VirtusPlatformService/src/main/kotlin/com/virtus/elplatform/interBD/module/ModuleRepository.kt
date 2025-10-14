package com.virtus.elplatform.interBD.module

import com.virtus.elplatform.interBD.course.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ModuleRepository : JpaRepository<Module?, Long?>, JpaSpecificationExecutor<Course?>
