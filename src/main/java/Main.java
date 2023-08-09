import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import animal.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Animals.txt");

        Cat cat = Cat.builder().build().generateRandom();
        Dog dog = Dog.builder().build().generateRandom();
        Bird bird = Bird.builder().build().generateRandom();
        Patyh patyh = Patyh.builder().build().generateRandom();

//        System.out.println(cat);
//        System.out.println(dog);
//        System.out.println(bird);

        PrintWriter writer = new PrintWriter(new FileWriter(file, true)); //Запись в файл
        Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a.compareTo(b));
            }
        });
        map.put(cat.getName(), cat.getAge());
        map.put(dog.getName(), dog.getAge());
        map.put(bird.getName(), bird.getAge());
        map.put(patyh.getName(), patyh.getAge());
//        writer.println(map);
        writer.close();

        BufferedReader reader = Files.newBufferedReader(Paths.get("Animals.txt")); // чтение из файла
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);

        }
    }
}