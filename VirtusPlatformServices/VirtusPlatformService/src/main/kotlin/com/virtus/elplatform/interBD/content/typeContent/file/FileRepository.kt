package com.virtus.elplatform.interBD.content.typeContent.file

import org.springframework.data.jpa.repository.JpaRepository

interface FileRepository : JpaRepository<FileType?, Long?>
