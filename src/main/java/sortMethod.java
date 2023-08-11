import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class sortMethod {
    public static int CountLinesInFile(String filename) throws IOException {   //Вычесление количество строк в символьном файле
        int count = 0;
        FileReader file = null;
        int symbol;
        ;

        try {
            file = new FileReader(filename);
            do {
                symbol = file.read();
                if ((char) symbol == '\n')
                    count++;
            } while (file.ready());
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                System.out.println("File close error");
            }
        }
        return count;
    }

    public static String[] GetLinesFromFile(String filename) throws IOException {   //Получает файл в виде массива строк
        int count;
        String lines[];
        FileReader file;
        String s;
        int symbol;
        int i;

        count = CountLinesInFile(filename);
        if (count <= 0) return null;
        lines = new String[count];
        try {
            file = new FileReader(filename);
            s = "";
            i = 0;
            do {
                symbol = file.read();
                if ((char) symbol == '\n') {
                    s = s.substring(0, s.length() - 1);
                    lines[i] = s;
                    s = "";
                    i++;
                } else
                    s = s + (char) symbol;
            } while (file.ready());
        } catch (IOException e) {
            System.out.println("File close error");
        }
        return lines;
    }


    public static void WriteLinesToFile(String filename, String lines[]) throws IOException {                          //Запись массива в файл
        FileOutputStream fs = null;
        PrintStream ps = null;

        try {
            fs = new FileOutputStream(filename);
            ps = new PrintStream(fs);
            for (int i = 0; i < lines.length; i++) {
                ps.println(lines[i]);
            }
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        } finally {
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    System.out.println("Error closing " + filename);
                }
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    public static boolean SortLinesInFile(String filename, boolean order) throws IOException {
        String s;
        String lines[] = GetLinesFromFile(filename);
        if (lines != null) {
            for (int i = 0; i < lines.length - 1; i++) {
                for (int j = i; j >= 0; j--)
                    if (order) {
                        if (lines[j].compareTo(lines[j + 1]) > 0) {
                            s = lines[j];
                            lines[j] = lines[j + 1];
                            lines[j + 1] = s;

                        }
                    } else {
                        if (lines[j].compareTo(lines[j + 1]) < 0) {
                            s = lines[j];
                            lines[j] = lines[j + 1];
                            lines[j + 1] = s;

                        }
                    }
                WriteLinesToFile(filename, lines);
            }
            return true;
        }
        return false;
    }
}