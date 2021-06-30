package Common.Common;

import java.io.File;
import java.io.IOException;

public class Utilities {
    public static String getProjectPath() throws IOException {
        return new File("./").getCanonicalPath();
    }
}
