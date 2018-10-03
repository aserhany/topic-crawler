package news.utils;

import java.io.IOException;
import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import org.apache.tika.Tika;
import org.apache.tika.mime.MimeTypes;

public class ByteArrayToStringConverter {

    private CharsetDetector detector;
    private Tika defaultTika;
    private Tika mimeTika;


    public ByteArrayToStringConverter() {
        this.detector = new CharsetDetector();
        this.defaultTika = new Tika();
        this.mimeTika = new Tika(new MimeTypes());
    }


    /**
     * This function takes a byte array, uses some libraries to determine the content type and encoding and returns
     * a string. If the content is not considered as a string, null will be returned.
     */
    public Result convert(byte[] bytes) {
        // Use tika for file type detection
        if (!defaultTika.detect(bytes).startsWith("text") || !mimeTika.detect(bytes).startsWith("text")) {
            return null;
        }

        // Use ICU for text encoding detection
        this.detector.setText(bytes);
        CharsetMatch match = detector.detect();
        if (match == null) {
            return null;
        }
        try {
            return new Result(match.getName(), match.getString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public class Result {
        private String encoding;
        private String content;


        private Result(String encoding, String content) {
            this.encoding = encoding;
            this.content = content;
        }


        public String getEncoding() {
            return encoding;
        }


        public String getContent() {
            return content;
        }
    }
}
