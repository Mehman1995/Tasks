import animal.*;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Animals.txt");

        Cat cat = Cat.builder().build().generateRandom();
        Dog dog = Dog.builder().build().generateRandom();
        Bird bird = Bird.builder().build().generateRandom();
        Patyh patyh = Patyh.builder().build().generateRandom();

        Map<String, String> map = new TreeMap<>();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {   // Запись файла
            map.put(cat.getName(), cat.getAge());
            map.put(dog.getName(), dog.getAge());
            map.put(bird.getName(), bird.getAge());
            map.put(patyh.getName(), patyh.getAge());

            writer.println(map);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {   //Для чтение файла
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        boolean res = sortMethod.SortLinesInFile("Animals.txt", false);
//        if (res) {
//            System.out.println("OK");
//        } else {
//            System.out.println("Fail");
//        }
    }
}