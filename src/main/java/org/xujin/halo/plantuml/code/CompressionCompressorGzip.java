package org.xujin.halo.plantuml.code;

import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipParameters;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;

public class CompressionCompressorGzip  extends  CompressionCompressor{

    @Override
    protected CompressorOutputStream createCompressorOutputStream(OutputStream os) {
        try {
            GzipParameters gzipParameters=new GzipParameters();
            gzipParameters.setCompressionLevel(Deflater.BEST_COMPRESSION);
            return new GzipCompressorOutputStream(os, gzipParameters);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    protected CompressorInputStream createCompressorInputStream(InputStream is) {
        try {
            new GzipCompressorInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
