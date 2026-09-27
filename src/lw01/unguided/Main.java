import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
     public static void main(String[] args) {
        List<washService> jobs = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("washes.txt"))) {
            while (scanner.hasNext()) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                if (type.equals("MotorCycle")) {
                    jobs.add(new MotorcycleWash(id, days));
                } else if (type.equals("Car")) {
                    jobs.add(new CarWash(id, days));
                } else {
                    throw new IllegalArgumentException("Unknown job type: " + type);
                }
            }
}
catch (FileNotFoundException e) {
            System.err.println("washes.txt not found in the working directory.");
            return;
        }
    }
}