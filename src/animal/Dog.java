package animal;

import animalsInterfаce.Animals;

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
    public int isAge(){
        return age;
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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public static class DogBuilder{
        private String name;
        private int age;
        private int id;

        public DogBuilder(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public DogBuilder() {
        }

        public DogBuilder setAge(int age){
            this.age = age;
            return this;
        }
        public Dog builder(){
            return new Dog(this);
        }
    }
}
