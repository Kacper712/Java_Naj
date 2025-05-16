import java.util.*;
import java.io.*;
import java.util.function.*;
import java.util.stream.*;

// === 1. KLASY I OBIEKTY ===
class Animal {
    // Enkapsulacja: prywatne pola
    private String name;
    private int age;

    // Konstruktor domyślny
    public Animal() {
        this.name = "Brak imienia";
        this.age = 0;
    }

    // Konstruktor z parametrami
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Gettery i settery
    public String getName() { return name; }
    public int getAge() { return age; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    // Zwykła metoda
    public void speak() {
        System.out.println("Jestem zwierzęciem: " + name);
    }

    // Statyczna metoda
    public static void info() {
        System.out.println("Zwierzę to klasa bazowa");
    }
}

// === 2. DZIEDZICZENIE i POLIMORFIZM ===
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age); // wywołanie konstruktora klasy nadrzędnej
        this.breed = breed;
    }

    public void bark() {
        System.out.println(getName() + " szczeka!");
    }

    // Nadpisanie metody
    @Override
    public void speak() {
        System.out.println("Jestem psem: " + getName() + ", rasa: " + breed);
    }
}

// === 3. ABSTRAKCJA ===
abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void drive(); // metoda abstrakcyjna

    public void honk() {
        System.out.println("Pii pii!");
    }
}

class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }

    @Override
    public void drive() {
        System.out.println("Samochód " + brand + " jedzie!");
    }
}

// === 4. INTERFEJSY ===
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

// Klasa może implementować wiele interfejsów
class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Kaczka leci!");
    }

    public void swim() {
        System.out.println("Kaczka pływa!");
    }
}

// === 5. KOLEKCJE (KONTENERY) ===
class CollectionsDemo {
    public void run() {
        // List
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Celina");

        for (String name : names) {
            System.out.println("Imię: " + name);
        }

        // Set
        Set<Integer> uniqueNumbers = new HashSet<>(Arrays.asList(1, 2, 2, 3));
        System.out.println("Set: " + uniqueNumbers); // bez duplikatów

        // Map
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Matematyka", 5);
        grades.put("Fizyka", 4);
        grades.put("Polski", 3);

        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Queue
        Queue<String> queue = new LinkedList<>();
        queue.offer("Pierwszy");
        queue.offer("Drugi");
        System.out.println("Z kolejki: " + queue.poll());

        // Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Ze stosu: " + stack.pop());
    }
}

// === 6. PLIKI (ZAPIS I ODCZYT) ===
class FileManager {
    public void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Błąd zapisu: " + e.getMessage());
        }
    }

    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Z pliku: " + line);
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu: " + e.getMessage());
        }
    }
}

// === 7. WYJĄTKI ===
class ExceptionDemo {
    public void causeException() {
        try {
            int[] arr = new int[2];
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Przekroczono rozmiar tablicy: " + e);
        } catch (Exception e) {
            System.out.println("Inny wyjątek: " + e);
        } finally {
            System.out.println("Zawsze się wykonuje (finally).");
        }
    }
}

// === 8. PROGRAMOWANIE FUNKCYJNE ===
class FunctionalDemo {
    public void run() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Stream API
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Kwadraty: " + squared);

        // Predicate + filter
        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> evens = numbers.stream().filter(isEven).toList();
        System.out.println("Parzyste: " + evens);

        // Consumer
        Consumer<String> printer = s -> System.out.println("Wartość: " + s);
        printer.accept("Hello functional!");

        // Function
        Function<String, Integer> length = s -> s.length();
        System.out.println("Długość słowa: " + length.apply("Java"));

        // BiFunction
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println("Suma: " + sum.apply(2, 3));
    }
}

// === 9. PROGRAMOWANIE GENERYCZNE ===
class GenericBox<T> {
    private T value;

    public void setValue(T value) { this.value = value; }
    public T getValue() { return value; }

    public void printType() {
        System.out.println("Typ przechowywany: " + value.getClass().getName());
    }
}

class Utils {
    // Metoda generyczna
    public static <T> void printArray(T[] array) {
        for (T elem : array) {
            System.out.println(elem);
        }
    }

    // Ograniczenia typów generycznych
    public static <T extends Number> double sumNumbers(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}
