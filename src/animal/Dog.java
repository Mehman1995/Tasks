package animal;

import animalsInterfаce.Animals;

import java.util.Random;

public class Dog implements Animals {
    private String name;
    private int age;
    private int id;

    public Dog(DogBuilder dogBuilder) {
        this.name = dogBuilder.name;
        this.age = dogBuilder.age;
        this.id = dogBuilder.id;
    }

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public void voice() {
        System.out.println("Собака говорит Гаф-Гаф");
    }

    @Override
    public void moveAround() {
        System.out.println("Собака бегает куда глаза глядят ");
    }

    @Override
    public String toString() {
        return "Собака " +
                "с именем = " + name  +
                ", возростом = " + age +
                "лет, id=" + id;
    }
    public Dog generateRandom(){
        Random dogRandom = new Random();
        return new DogBuilder()
                .setName("dog №" + dogRandom.nextInt(100))
                .setAge(dogRandom.nextInt(100))
                .setId(dogRandom.nextInt(100))
                .builder();
    }

    public static class DogBuilder {
        private String name;
        private int age;
        private int id;

        public DogBuilder(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }

        public DogBuilder() {
        }

        public DogBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public DogBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DogBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public Dog builder() {
            return new Dog(this);
        }
    }
}
