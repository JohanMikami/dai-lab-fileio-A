package ch.heig.dai.lab.fileio.Neroil;

import java.io.File;
import java.nio.charset.Charset;

public class EncodingSelector {

    /**
     * Get the encoding of a file based on its extension.
     * The following extensions are recognized:
     *   - .utf8:    UTF-8
     *   - .txt:     US-ASCII
     *   - .utf16be: UTF-16BE
     *   - .utf16le: UTF-16LE
     * 
     * @param file the file to get the encoding from
     * @return the encoding of the file, or null if the extension is not recognized
     */
    public Charset getEncoding(File file) {

        int lastDot = 0;

        String name = file.toString();

        for (int i = 0;i < name.length(); ++i){
            if(name.charAt(i) == '.'){
                lastDot = i;
            }
        }

        String extension = name.substring(lastDot+1);

        return switch (extension) {
            case "utf8"     -> Charset.forName("UTF-8");
            case "txt"      -> Charset.forName("US-ASCII");
            case "utf16be"  -> Charset.forName("UTF-16BE");
            case "utf16le"  -> Charset.forName("UTF-16LE");
            default         -> null;
        };
    }
}