package main;

import java.util.Scanner;
import service.PaymentService;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PaymentService service = new PaymentService();

        while (true) {
            System.out.println("\n1. Transfer Money");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            // 🔥 Handle invalid choice input
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {

                System.out.print("Sender Name: ");
                String sender = sc.nextLine().trim();

                System.out.print("Receiver Name: ");
                String receiver = sc.nextLine().trim();

                System.out.print("Amount: ");

                // 🔥 Handle invalid amount input
                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid amount");
                    sc.nextLine();
                    continue;
                }

                double amount = sc.nextDouble();
                sc.nextLine(); // clear buffer

                // 🔥 Validate empty input
                if (sender.isEmpty() || receiver.isEmpty()) {
                    System.out.println("Names cannot be empty");
                    continue;
                }

                // 🔥 Validate amount
                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0");
                    continue;
                }

                service.transferByName(sender, receiver, amount);

            } else if (choice == 2) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}