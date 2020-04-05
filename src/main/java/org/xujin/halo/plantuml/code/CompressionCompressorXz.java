package org.xujin.halo.plantuml.code;

import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

import java.io.InputStream;
import java.io.OutputStream;

public class CompressionCompressorXz extends  CompressionCompressor{


    @Override
    protected CompressorOutputStream createCompressorOutputStream(OutputStream os) {
        return null;
    }

    @Override
    protected CompressorInputStream createCompressorInputStream(InputStream is) {
        return null;
    }
}
