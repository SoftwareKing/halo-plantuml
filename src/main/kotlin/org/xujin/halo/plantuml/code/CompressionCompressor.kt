package org.xujin.halo.plantuml.code

import org.apache.commons.compress.compressors.CompressorInputStream
import org.apache.commons.compress.compressors.CompressorOutputStream
import org.springframework.util.StreamUtils
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream

abstract class CompressionCompressor : net.sourceforge.plantuml.code.Compression {

	override fun compress(bytes: ByteArray): ByteArray {
		val outputStream =  ByteArrayOutputStream()
		val compressorOutputStream = createCompressorOutputStream(outputStream)
		StreamUtils.copy(bytes, compressorOutputStream)
		compressorOutputStream.close()
		return outputStream.toByteArray()
	}

	override fun decompress(bytes: ByteArray): ByteArray {
		val inputStream = ByteArrayInputStream(bytes)
		val compressorInputStream = createCompressorInputStream(inputStream)
		return StreamUtils.copyToByteArray(compressorInputStream)
	}

	protected abstract fun createCompressorOutputStream(outputStream: OutputStream): CompressorOutputStream

	protected abstract fun createCompressorInputStream(inputStream: InputStream): CompressorInputStream
}