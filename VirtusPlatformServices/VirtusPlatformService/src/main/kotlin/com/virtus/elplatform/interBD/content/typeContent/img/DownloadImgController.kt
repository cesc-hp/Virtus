package com.virtus.elplatform.interBD.content.typeContent.img

import org.springframework.http.MediaType
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.io.File
import javax.activation.FileTypeMap
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping(value = ["/assets"], method = [RequestMethod.GET])
class DownloadImgController {

    @RequestMapping(value = ["{folder}/{name}"], method = [RequestMethod.GET], produces = [MediaType.IMAGE_PNG_VALUE])
    fun getImg(response: HttpServletResponse, @PathVariable folder: String, @PathVariable name: String) {
        if (File("src/main/resources/assets/$folder/$name").exists()) {
            var imgFile = File("src/main/resources/assets/$folder/$name")
            var type = MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(imgFile))
            response.contentType = type.toString()
            StreamUtils.copy(imgFile.inputStream(), response.outputStream)
        }
    }
}
