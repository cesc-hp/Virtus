package com.virtus.elplatform.seeders

import com.virtus.elplatform.interBD.content.FileService
import com.virtus.elplatform.interBD.content.typeContent.img.ImgMutation
import com.virtus.elplatform.interBD.content.typeContent.img.ImgRepository
import org.springframework.stereotype.Component

@Component
class ImgSeeder(val imgRepository: ImgRepository, val fileService: FileService) {
    fun init() {
        if (imgRepository.count() == 0L) {
            val mutation = ImgMutation(imgRepository, fileService)
            // save company
            /*mutation.newImg("Primra", "Foto1")
            mutation.newImg("Segunda", "Foto2")
            mutation.newImg("Tercera", "Foto3")
            mutation.newImg("Cuarta", "Foto4")*/
        }
    }
}
