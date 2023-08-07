package animal;

import animalsInterfаce.Animals;

public class Cat implements Animals {
    private String name;
    private int age;
    private int id;

    public Cat(CatBuilder catBuilder) {
        this.name = catBuilder.name;
        this.age = catBuilder.age;
        this.id = catBuilder.id;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public int isAge(){
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

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public static class CatBuilder {
        private String name;
        private int age;
        private int id;

        public CatBuilder(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public CatBuilder() {
        }


        public CatBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Cat build(){
            return new Cat(this);
        }
    }
}
