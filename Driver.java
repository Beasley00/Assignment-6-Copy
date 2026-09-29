// Carter Beasley | Assignment 6 | Driver.java

// testing github collaboration

import java.util.Scanner;

public class Driver 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many training sessions would you like to enter?");
        int sessionCount = scanner.nextInt();
        scanner.nextLine();

        TrainingSessions[] sessions = new TrainingSessions[sessionCount];

        for (int sessionIndex = 0; sessionIndex < sessionCount; sessionIndex++)
        {
            System.out.println("\nEnter information for session #" + (sessionIndex + 1));
            System.out.print("Session type (normal, workout, or long run): ");
            String sessionType = scanner.nextLine().trim().toLowerCase();
            System.out.print("Date: ");
            String date = scanner.nextLine();
            System.out.print("Start time: ");
            String startTime = scanner.nextLine();

            if (sessionType.equals("normal"))
            {
                System.out.print("Miles: ");
                double miles = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Is there a double run? (yes/no): ");
                boolean hasDoubleRun = scanner.nextLine().trim().equalsIgnoreCase("yes");
                double doubleMileage = 0.0;

                if (hasDoubleRun)
                {
                    System.out.print("Double-run miles: ");
                    doubleMileage = scanner.nextDouble();
                    scanner.nextLine();
                }

                sessions[sessionIndex] = new NormalPractice(startTime, date, miles, hasDoubleRun, doubleMileage);
            }
            else if (sessionType.equals("workout"))
            {
                System.out.print("Workout description: ");
                String workout = scanner.nextLine();
                System.out.print("Miles: ");
                double miles = scanner.nextDouble();
                scanner.nextLine();
                sessions[sessionIndex] = new Workout(startTime, date, workout, miles);
            }
            else if (sessionType.equals("long run") || sessionType.equals("longrun"))
            {
                System.out.print("Miles: ");
                double miles = scanner.nextDouble();
                scanner.nextLine();
                sessions[sessionIndex] = new LongRun(startTime, date, miles);
            }
            else
            {
                System.out.println("Invalid session type. Please restart and choose normal, workout, or long run.");
                scanner.close();
                return;
            }
        }

        scanner.close();

        System.out.println("==================================================");
        System.out.println("           WEEKLY TRAINING SESSIONS LOG           ");
        System.out.println("==================================================");

        // Variables used to process information about the objects
        double totalMileage = 0.0;
        int normalPracticeCount = 0;
        int workoutCount = 0;
        int longRunCount = 0;
        int doubleRunCount = 0;

        // Loop that processes and displays information about the objects
        for (int i = 0; i < sessions.length; i++) 
        {
            TrainingSessions session = sessions[i];

            // 1. Display information about the current object
            System.out.println("Session #" + (i + 1) + ": " + session);

            // 2. Process information about the current object
            if (session instanceof NormalPractice) 
            {
                NormalPractice practice = (NormalPractice) session;
                totalMileage += practice.getMiles(true);
                normalPracticeCount++;

                if (practice.hasDoubleRun()) 
                {
                    doubleRunCount++;
                }
            } 
            else if (session instanceof Workout) 
            {
                Workout workout = (Workout) session;
                totalMileage += workout.getMiles();
                workoutCount++;
            } 
            else if (session instanceof LongRun) 
            {
                LongRun longRun = (LongRun) session;
                totalMileage += longRun.getMiles();
                longRunCount++;
            }
        }

        // Display summary of processed information
        System.out.println("\n==================================================");
        System.out.println("            PROCESSED TRAINING SUMMARY            ");
        System.out.println("==================================================");
        System.out.println("Total Sessions Completed : " + sessions.length);
        System.out.println("Normal Practices         : " + normalPracticeCount);
        System.out.println("  - Double Run Days      : " + doubleRunCount);
        System.out.println("Workouts                 : " + workoutCount);
        System.out.println("Long Runs                : " + longRunCount);
        System.out.printf("Total Mileage Logged     : %.1f miles\n", totalMileage);
        System.out.println("==================================================");
    }
}

