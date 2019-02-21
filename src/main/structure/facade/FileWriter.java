package structure.facade;

import java.io.*;

public class FileWriter {
    public void write(String data, String dest) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(dest);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        try {
            writer.write(data, 0, data.length());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
