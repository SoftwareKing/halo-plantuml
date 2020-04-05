package org.xujin.halo.plantuml.code;

import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CompressionCompressorBzip2 extends CompressionCompressor {

    @Override
    protected CompressorOutputStream createCompressorOutputStream(OutputStream os) {
        try {
            BZip2CompressorOutputStream bZip2CompressorOutputStream= new BZip2CompressorOutputStream(
                    os,
                    BZip2CompressorOutputStream.MAX_BLOCKSIZE);
            return bZip2CompressorOutputStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected CompressorInputStream createCompressorInputStream(InputStream is) {
        try {
            return new BZip2CompressorInputStream(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
