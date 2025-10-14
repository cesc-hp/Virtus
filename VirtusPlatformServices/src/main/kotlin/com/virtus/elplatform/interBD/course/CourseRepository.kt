package com.virtus.elplatform.interBD.course

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface CourseRepository : JpaRepository<Course?, Long?>, JpaSpecificationExecutor<Course?>
