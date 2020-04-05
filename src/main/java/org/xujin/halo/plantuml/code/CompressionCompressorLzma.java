package org.xujin.halo.plantuml.code;

import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CompressionCompressorLzma extends CompressionCompressor {

    @Override
    protected CompressorOutputStream createCompressorOutputStream(OutputStream os) {
        try {
            new LZMACompressorOutputStream(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected CompressorInputStream createCompressorInputStream(InputStream is) {
        try {
            new LZMACompressorInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}





