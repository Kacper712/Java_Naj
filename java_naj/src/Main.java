public class Main {
    public static void main(String[] args) {
        System.out.println("--- Klasy i obiekty ---");
        Animal a = new Animal("Tygrys", 5);
        a.speak();
        Animal.info();

        System.out.println("--- Dziedziczenie ---");
        Dog d = new Dog("Reksio", 3, "Owczarek");
        d.speak();
        d.bark();

        System.out.println("--- Abstrakcja i interfejsy ---");
        Car car = new Car("Toyota");
        car.drive();
        car.honk();

        Duck duck = new Duck();
        duck.fly();
        duck.swim();

        System.out.println("--- Kolekcje ---");
        new CollectionsDemo().run();

        System.out.println("--- Pliki ---");
        FileManager fileManager = new FileManager();
        fileManager.writeToFile("output.txt", "To jest zapisane z Javy.");
        fileManager.readFromFile("output.txt");

        System.out.println("--- Wyjątki ---");
        new ExceptionDemo().causeException();

        System.out.println("--- Programowanie funkcyjne ---");
        new FunctionalDemo().run();

        System.out.println("--- Generyki ---");
        GenericBox<String> strBox = new GenericBox<>();
        strBox.setValue("Test");
        strBox.printType();

        Integer[] intArray = {1, 2, 3};
        Utils.printArray(intArray);

        double sum = Utils.sumNumbers(10, 20);
        System.out.println("Suma liczb: " + sum);
    }
}