package main.java.animal;

import main.java.animalsInterfаce.Animals;
import lombok.Data;
import java.util.*;

@Data
public class Cat implements Animals {
    private String name;
    private int age;
    private int id;

    public Cat(CatBuilder catBuilder) {
        this.name = catBuilder.name;
        this.age = catBuilder.age;
        this.id = catBuilder.id;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }


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
        return new CatBuilder()
                .setName("cat №" + catRandom.nextInt(100))
                .setAge(catRandom.nextInt(100))
                .setId(catRandom.nextInt(100))
                .build();
    }


    public static class CatBuilder {
        private String name;
        private int age;
        private int id;

        public CatBuilder(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }

        public CatBuilder() {
        }

        public CatBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public CatBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CatBuilder setName(String name) {
            this.name = name;
            return this;
        }


        public Cat build() {
            return new Cat(this);
        }
    }
}