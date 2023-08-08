import animal.Bird;
import animal.Cat;
import animal.Dog;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args)throws IOException{
        File file = new File("Animals.txt");
        Cat cat = new Cat.CatBuilder().build().generateRandom();
        Dog dog = new Dog.DogBuilder().builder().generateRandom();
        Bird bird = new Bird.BirdBuilder().build().generateRandom();
        System.out.println(cat);
        System.out.println(dog);
        System.out.println(bird);
        try {
          PrintWriter writer = new PrintWriter(new FileWriter(file,true));

            Map<String,Integer> map = new TreeMap<>();
           map.put(cat.getName(), cat.getAge());
           map.put(dog.getName(), dog.getAge());
           map.put(bird.getName(), bird.getAge());
           writer.println(map);
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }



    }


}