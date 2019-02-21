package structure.facade;

import java.io.*;

public class FileReader {
    public String read(String srcFile) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(srcFile);
        Reader reader = new InputStreamReader(inputStream);
        StringBuilder builder = new StringBuilder();
        char[] chars = new char[1024];
        int len;
        try {
            while ((len = reader.read(chars)) != -1) {
                builder.append(chars,0,len);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
