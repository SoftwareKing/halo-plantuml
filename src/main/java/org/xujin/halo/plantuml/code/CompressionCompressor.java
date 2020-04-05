package org.xujin.halo.plantuml.code;

import net.sourceforge.plantuml.code.Compression;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class CompressionCompressor implements Compression {

    @Override
    public byte[] compress(byte[] bytes) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CompressorOutputStream compressorOutputStream = this.createCompressorOutputStream((OutputStream)outputStream);
        try {
            StreamUtils.copy(bytes, (OutputStream)compressorOutputStream);
            compressorOutputStream.close();
        } catch (IOException e) {
        }
        byte[]  outByte = outputStream.toByteArray();
        return outByte;
    }

    @Override
    public byte[] decompress(byte[] bytes) throws IOException {
        return new byte[0];
    }


    protected abstract CompressorOutputStream createCompressorOutputStream(OutputStream os);

    protected abstract CompressorInputStream createCompressorInputStream(InputStream is);
}
