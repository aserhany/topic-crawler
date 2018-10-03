package news.utils;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GZIPUtils {
    public static byte[] compressString(String data) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             GzipCompressorOutputStream gzOut = new GzipCompressorOutputStream(out)
        ) {
            gzOut.write(data.getBytes());
            gzOut.close();
            return out.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String decompressString(byte[] compressed) {
        try (ByteArrayInputStream in = new ByteArrayInputStream(compressed);
             GzipCompressorInputStream gzIn = new GzipCompressorInputStream(in)
        ) {
            byte[] bytes = IOUtils.toByteArray(gzIn);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

