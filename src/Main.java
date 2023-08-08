import animal.Bird;
import animal.Cat;
import animal.Dog;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Animals.txt");

        Cat cat = new Cat.CatBuilder().build().generateRandom();
        Dog dog = new Dog.DogBuilder().builder().generateRandom();
        Bird bird = new Bird.BirdBuilder().build().generateRandom();

//        System.out.println(cat);
//        System.out.println(dog);
//        System.out.println(bird);

        PrintWriter writer = new PrintWriter(new FileWriter(file, true)); //Запись в файл
        Map<String, Integer> map = new TreeMap<>();
        map.put(cat.getName(), cat.getAge());
        map.put(dog.getName(), dog.getAge());
        map.put(bird.getName(), bird.getAge());
        writer.println(map);
        writer.close();

        BufferedReader reader = Files.newBufferedReader(Paths.get("Animals.txt")); // чтение из файла
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}