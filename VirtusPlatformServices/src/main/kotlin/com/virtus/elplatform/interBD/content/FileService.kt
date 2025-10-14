package com.virtus.elplatform.interBD.content

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import javax.servlet.http.Part

@Service
class FileService(
    @Value("\${resources.url}")
    val baseUrl: String
) {

    fun uploadFile(folderName: String, file: Part): String {
        val folderUrl = Paths.get(baseUrl + "assets/$folderName")
//        si no existe la carpeta, crearla
        if (Files.notExists(folderUrl)) {
            Files.createDirectories(folderUrl)
        }
        val fileUrl = Paths.get(folderUrl.toString() + "/" + file.submittedFileName)
        if (Files.notExists(fileUrl)) {
            try {
                Files.copy(file.inputStream, fileUrl, StandardCopyOption.REPLACE_EXISTING)
            } catch (ex: FileAlreadyExistsException) {
                // lanzar excepción para notificar al usuario que ese archivo ya existe
                throw ex
            } catch (ex: IOException) {
//                TODO: tratar excepción genérica
            }
        }
        return "/" + folderName + "/" + file.submittedFileName
    }
}
