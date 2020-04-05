package org.xujin.halo.plantuml.code;

import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream;
import org.apache.commons.compress.compressors.deflate.DeflateParameters;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;

public class CompressionCompressorDeflate extends CompressionCompressor {
    @Override
    protected CompressorOutputStream createCompressorOutputStream(OutputStream os) {
        try {
            DeflateParameters parameters =new DeflateParameters();
            parameters.setCompressionLevel(Deflater.BEST_COMPRESSION);
            parameters.setWithZlibHeader(false);
            return new DeflateCompressorOutputStream(os,parameters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected CompressorInputStream createCompressorInputStream(InputStream is) {
        return new DeflateCompressorInputStream(is);
    }

}
