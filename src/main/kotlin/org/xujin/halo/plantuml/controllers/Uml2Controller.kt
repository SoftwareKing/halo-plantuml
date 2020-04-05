package org.xujin.halo.plantuml.controllers

import org.xujin.halo.plantuml.services.UmlService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.net.URL

@RestController
@RequestMapping("uml2")
class Uml2Controller(
	private val umlService: UmlService
) {

	@GetMapping("{encodedSource:.*}")
	fun show(
		@PathVariable("encodedSource") encodedSource: String,
		model: Model
	): String {
		val source = umlService.decode(encodedSource)
		model.addAttribute("encodedSource", encodedSource)
		model.addAttribute("source", source)
		return "index"
	}

	@PostMapping
	fun create(
		@RequestParam("source") source: String
	): String {
		return umlService.encode(source)
	}

	@PostMapping("recover")
	fun recover(
		@RequestParam("url") url: String
	): String {
		return "redirect:${extractEncodedSource(url)}"
	}

	private fun extractEncodedSource(url: String): String {
		val path = URL(url).path
		val segments = path.split('/')
		if (segments.size > 2) {
			return segments.last()
		}
		return "SyfFKj2rKt3CoKnELR1Io4ZDoSa70000"
	}

}