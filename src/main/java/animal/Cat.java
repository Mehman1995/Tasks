package animal;

import animalsInterfаce.Animals;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.*;

@Value
@Builder
@With
public class Cat implements Animals  {
    String name;
    String age;
    int id;

    @Override
    public void voice() {
        System.out.println("Кошка говорит Мяу_Мяу");
    }

    @Override
    public void moveAround() {
        System.out.println("Кошка прыгает на все что видет ");
    }


    public Cat generateRandom() {  //метод для генирации случайных чисел
        Random catRandom = new Random();
        return Cat.builder()
                .name("cat № " + catRandom.nextInt(100))
                .age(("Возраст " + catRandom.nextInt(100)))
                .id(catRandom.nextInt(100))
                .build();
    }
    public static String min(ArrayList<String> list, Comparator<String> comp)
    {
        String shortest = list.get(0);

        for(String str : list) {
            if ( comp.compare(str, shortest) < 0) {
                shortest = str;
            }
        }
        return shortest;
    }


}
