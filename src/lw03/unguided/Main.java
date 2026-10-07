import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Event Check-In Results =====");

        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Set<String> registrations = new LinkedHashSet<>();
        while (sc1.hasNextLine()) {
            registrations.add(sc1.nextLine().trim());
        }
        int total = registrations.size();

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        Set<String> checkedIn = new LinkedHashSet<>();
        int successCheck = 0;
        int rejectCheck = 0;

        while (sc2.hasNextLine()) {
            String checkin = sc2.nextLine().trim();

            if (checkedIn.contains(checkin)) {
                rejectCheck++;
                System.out.println(checkin + " - Rejected (already checked in)");
            } else if (registrations.contains(checkin)) {
                checkedIn.add(checkin);
                successCheck++;
                System.out.println(checkin + " - Checked in");
            } else {
                rejectCheck++;
                System.out.println(checkin + " - Rejected (not registered)");
            }
        }

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + total);
        System.out.println("Successful check-ins: " + successCheck);
        System.out.println("Absent students: " + (total - successCheck));
        System.out.println("Rejected attempts: " + rejectCheck);
    }
}