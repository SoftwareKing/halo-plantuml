package org.xujin.halo.plantuml.controllers

import org.xujin.halo.plantuml.services.RenderService
import org.xujin.halo.plantuml.services.UmlService
import net.sourceforge.plantuml.FileFormat
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/txt")
class TxtController(
	umlService: UmlService,
	renderService: RenderService
): AbstractRenderController(umlService, renderService) {

	companion object {
		@JvmStatic
		private val CONTENT_TYPE = MediaType.valueOf(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	}

	override val format: FileFormat
		get() = FileFormat.UTXT

	override val contentType: MediaType
		get() = CONTENT_TYPE
}