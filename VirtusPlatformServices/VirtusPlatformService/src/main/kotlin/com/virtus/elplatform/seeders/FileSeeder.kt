package com.virtus.elplatform.seeders

import com.virtus.elplatform.interBD.content.typeContent.file.FileMutation
import com.virtus.elplatform.interBD.content.typeContent.file.FileRepository
import org.springframework.stereotype.Component

@Component
class FileSeeder(val fileRepository: FileRepository) {
    fun init() {
        if (fileRepository.count() == 0L) {
            val mutation = FileMutation(fileRepository)
            // save company
            mutation.newFile("Primra", "Archivo1")
            mutation.newFile("Segunda", "Archivo2")
            mutation.newFile("Tercera", "Archivo3")
            mutation.newFile("Cuarta", "Archivo4")
            mutation.newFile("Quinta", "Archivo5")
        }
    }
}
