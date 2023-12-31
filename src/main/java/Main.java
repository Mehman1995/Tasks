import animal.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("Animals.txt");

        Cat cat = Cat.builder().build().generateRandom();
        Dog dog = Dog.builder().build().generateRandom();
        Bird bird = Bird.builder().build().generateRandom();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));) {

            writer.write(cat.toString());
            writer.write('\n');
            writer.write(dog.toString());
            writer.write('\n');
            writer.write(bird.toString());
            writer.write('\n');

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String s = "";
            int symbol = reader.read();
            int count;
            String[] lines;

            if((char) symbol == '\n'){
                s = s.substring(0,s.length() - 1);

            }
            HashMap<String, Integer> map = new HashMap<>();
            map.put(cat.getName(), cat.getAge());
            map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


//        boolean res = sortMethod.SortLinesInFile("Animals.txt", false);   //сортировка мапы
//        if (res) {
//            System.out.println("OK");
//        } else {
//            System.out.println("Fail");
//        }
    }
}
