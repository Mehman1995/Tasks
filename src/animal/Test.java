package animal;

public class Test {
    private String name;
    private String age;
    private boolean hasCar;//optional
    private boolean hasBike;//optional

    public Test(TestBilder testBilder) {
        this.name = testBilder.name;
        this.age = testBilder.age;
        this.hasCar = testBilder.hasCar;
        this.hasBike = testBilder.hasBike;
    }
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public boolean isHasBike() {
        return hasBike;
    }
    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", hasCar=" + hasCar +
                ", hasBike=" + hasBike +
                '}';
    }

    public static class TestBilder{
        private String name;
        private String age;
        private boolean hasCar;//optional
        private boolean hasBike;//optional

        public TestBilder(String name, String company) {
            this.name = name;
            this.age = company;
        }

        public TestBilder setHasCar(boolean hasCar) {
            this.hasCar = hasCar;
            return this;
        }

        public TestBilder setHasBike(boolean hasBike) {
            this.hasBike = hasBike;
            return this;
        }
        public Test build (){
            return new Test(this);
        }
    }
}
class tests{
    public static void main(String[] args) {
        Test test = new Test.TestBilder("vikram","ABC").setHasBike(false).setHasCar(true).build();
        System.out.println(test);
    }
}
