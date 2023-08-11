import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class sortMethod {
    // Вычислить количество строк в файле
    public static int CountLinesInFile(String filename) { // количество строк в файле
        // 1. Объявить внутренние переменные
        int count = 0; // количество строк в файле - результат
        FileReader fr = null;
        int symbol;
        try {
            // 2. Попытка открыть файл для чтения
            fr = new FileReader(filename);
            // Цикл чтения символов из файла и подсчета их количества
            do {
                // Считать символ из файла
                symbol = fr.read();

                // Проверить, есть ли символ конца строки
                if ((char) symbol == '\n')
                    count++; // Увеличить количество строк в файле на 1
            } while (fr.ready()); // Проверка на конец файла
        } catch (IOException e) {
            // 3. Если файл не открыт, то вывести соответствующее сообщение
            System.out.println("I/O error: " + e);
        } finally {

            // 4. Закрыть файл, если он был открыт
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("File close error.");
            }
        }
        // 5. Вернуть результат
        return count;
    }

    // Получить строки файла в виде массива String[]
    public static String[] GetLinesFromFile(String filename) throws IOException {
        // 1. Объявить внутренние переменные
        int count; // количество строк в файле
        String[] lines; // массив строк - результат
        FileReader fr = null;
        String s; // дополнительная переменная - строка
        int symbol;
        int i;
        // 2. Получить кооличество строк в файле - вызвать функцию CountLinesInFile()
        count = CountLinesInFile(filename);
        // 3. Проверка, есть ли в файле строки
        if (count <= 0) return null;
        // 4. Выделить память для count строк
        lines = new String[count];
        // 5. Чтение данных из файла и создание массива lines[]
        try {
            // 5.1. Попытка открыть файл для чтения
            fr = new FileReader(filename);
            // 5.2. Цикл чтения символов из файла и создание массива lines
            s = "";
            i = 0;
            do {
                // Считать символ из файла
                symbol = fr.read();
                // Проверить на символ конца строки
                if (((char) symbol == '\n')) {
                    // удалить из s символ '\n'
                    s = s.substring(0, s.length() - 1);

                    // Добавить в массив строк строку s
                    lines[i] = s;
                    s = "";
                    i++; // Увеличить количество строк в файле на 1
                } else {
                    // добавить символ к строке
                    s += (char) symbol;
                }
            } while (fr.ready()); // Проверка на конец файла
        } catch (IOException e) {
            // 5.3. Если файл не открыт, то вывести соответствующее сообщение
            System.out.println("I/O error: " + e);
        } finally {
            // 5.4. Закрыть файл, если он был открыт
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("File close error.");
            }
        }

        // 6. Вернуть результат
        return lines;
    }

    // Записать массив типа String[] в файл
    public static void WriteLinesToFile(String filename, String[] lines) throws IOException {
        FileOutputStream fs = null;
        PrintStream ps = null;

        try {
            fs = new FileOutputStream(filename);
            ps = new PrintStream(fs);
            for (String line : lines) {
                ps.println(line);
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

    // Записать массив типа String[] в файл
    public static void WriteLinesToFile(String[] lines, String filename) throws IOException {

        // 1. Объявить внутренние переменные
        FileOutputStream fs = null;
        PrintStream ps = null;
        try {
            // 2. Создать экземпляры классов FileOutputStream, PrintStream
            fs = new FileOutputStream(filename); // создать файловый поток
            ps = new PrintStream(fs); // связать файловый поток с потоком вывода PrintStream

            // 3. Цикл записи массива lines[] в файл
            for (int i = 0; i < lines.length; i++)
                ps.println(lines[i]);
        } catch (IOException e) {
            // Если ошибка открытия файла или другая ошибка
            System.out.println("I/O error: " + e);
        } finally {
            if (fs != null) {
                try {
                    fs.close();
                } catch (IOException e2) {
                    System.out.println("Error closing " + filename);
                }
            }

            if (ps != null) {
                ps.close();
            }
        }
    }
    // Сортировка строк в файле.
    public static boolean SortLinesInFile(String filename, boolean order)
            throws IOException {

        String s;

        // 1. Получить строки файла в виде массива String[]
        String lines[] = GetLinesFromFile(filename);

        // 2. Если в файле есть строки, то посортировать их
        if (lines!=null) {

            // цикл сортировки методом вставки
            for (int i=0; i<lines.length-1; i++)
                for (int j=i; j>=0; j--)
                    if (order) {
                        if (lines[j].compareTo(lines[j+1])>0) {
                            s = lines[j];
                            lines[j] = lines[j+1];
                            lines[j+1] = s;
                        }
                    }
                    else {
                        if (lines[j].compareTo(lines[j+1])<0) {
                            s = lines[j];
                            lines[j] = lines[j+1];
                            lines[j+1] = s;
                        }
                    }

            // 3. Записать посортированные строки в файл
            WriteLinesToFile(lines, filename);

            // 4. Вернуть результат
            return true;
        }

        return false;
    }
}