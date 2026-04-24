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

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {

                System.out.print("Sender Name: ");
                String sender = sc.nextLine();

                System.out.print("Receiver Name: ");
                String receiver = sc.nextLine();

                System.out.print("Amount: ");
                double amount = sc.nextDouble();

                service.transferByName(sender, receiver, amount);

            } else {
                break;
            }
        }
    }
}