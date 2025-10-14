package com.virtus.elplatform.interBD.lesson

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface LessonRepository : JpaRepository<Lesson, Long?>, JpaSpecificationExecutor<Lesson?>
