import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader {

    public static List<String> readSimpleList(String path, String delimiter) {
        ArrayList<String> result = new ArrayList<String>();
        File file = new File(path);
        Scanner s = null;
        try {
            s = new Scanner(file);
            s.useDelimiter(delimiter);
            while (s.hasNext()) {
                // remove delimiter at the end and add to list
                String str = s.next();
                str = str.substring(0, str.length() - delimiter.length());
                result.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (s != null)
                s.close();
        }
        return result;
    }

    public static List<String> readLines(String path) {
        ArrayList<String> result = new ArrayList<String>();
        Reader reader = null;
        BufferedReader breader = null;
        try {
            reader = new FileReader(path);
            breader = new BufferedReader(reader);
            String line;
            while ((line = breader.readLine()) != null) {
                char c;
                try {
                    c = line.charAt(0);
                    if (c != '-' && c != ' ') {
                        result.add(line.trim());
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    // do nothing (empty line)
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei!");
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
        return result;
    }
}
