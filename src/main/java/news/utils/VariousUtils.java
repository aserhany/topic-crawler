package news.utils;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

public class VariousUtils {
    public static UUID generateUUIDv1() {
        return Generators.randomBasedGenerator().generate();
    }
}
