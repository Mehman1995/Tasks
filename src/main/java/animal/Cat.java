package animal;

import animalsInterfаce.Animals;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.io.Serializable;
import java.util.*;

@Value
@Builder
@With
public class Cat implements Animals, Serializable {
    String name;
    int age;
    transient int id;

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
                .name("cat" + catRandom.nextInt(100))
                .age((catRandom.nextInt(100)))
                .id(catRandom.nextInt(100))
                .build();
    }

    @Override
    public String toString() {
        return "Cat:" + "Имя=" + name + ", Возраст = " + age + ";"+'}';
    }
}