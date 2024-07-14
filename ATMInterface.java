
import java.util.Scanner;

public class ATMInterface {

        private static Scanner scanner = new Scanner(System.in);
        private static ATMOperations atmOperations = new ATMOperations();

        public static void main(String[] args) {
            System.out.println("Welcome to the ATM");

            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (atmOperations.authenticateUser(userId, pin)) {
                boolean exit = false;
                while (!exit) {
                    System.out.println("\nATM Menu:");
                    System.out.println("1. Transaction History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            atmOperations.showTransactionHistory(userId);
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            atmOperations.withdraw(userId, withdrawAmount);
                            break;
                        case 3:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            atmOperations.deposit(userId, depositAmount);
                            break;
                        case 4:
                            System.out.print("Enter recipient User ID: ");
                            String recipientId = scanner.next();
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            atmOperations.transfer(userId, recipientId, transferAmount);
                            break;
                        case 5:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid User ID or PIN.");
            }
            System.out.println("Thank you for using the ATM.");
        }
    }


