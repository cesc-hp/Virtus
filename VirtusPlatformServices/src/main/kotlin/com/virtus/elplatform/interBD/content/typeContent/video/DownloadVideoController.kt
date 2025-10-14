package com.virtus.elplatform.interBD.content.typeContent.video

import org.springframework.core.io.UrlResource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.MediaTypeFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/assets/video"])
class DownloadVideoController {

    @GetMapping(value = ["/{name}/full"])
    fun getVideo(@PathVariable name: String): ResponseEntity<UrlResource> {
        var videoFile = UrlResource("assets/video/$name")
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
            .contentType(
                MediaTypeFactory
                    .getMediaType(videoFile)
                    .orElse(MediaType.APPLICATION_OCTET_STREAM)
            )
            .body(videoFile)
    }
}
