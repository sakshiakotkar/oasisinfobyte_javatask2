import java.util.HashMap;
import java.util.Map;

public class ATMOperations {


        private Map<String, User> users;

        public ATMOperations() {
            users = new HashMap<>();
            users.put("user1", new User("user1", "1234", 1000.0));
            users.put("user2", new User("user2", "5678", 2000.0));
        }

        public boolean authenticateUser(String userId, String pin) {
            User user = users.get(userId);
            return user != null && user.getPin().equals(pin);
        }

        public void showTransactionHistory(String userId) {
            User user = users.get(userId);
            if (user != null) {
                System.out.println("Transaction History:");
                for (Transaction transaction : user.getAccount().getTransactionHistory()) {
                    System.out.println(transaction);
                }
            }
        }

        public void withdraw(String userId, double amount) {
            User user = users.get(userId);
            if (user != null) {
                user.getAccount().withdraw(amount);
                System.out.println("Withdraw successful. Current balance: $" + user.getAccount().getBalance());
            }
        }

        public void deposit(String userId, double amount) {
            User user = users.get(userId);
            if (user != null) {
                user.getAccount().deposit(amount);
                System.out.println("Deposit successful. Current balance: $" + user.getAccount().getBalance());
            }
        }

        public void transfer(String userId, String recipientId, double amount) {
            User user = users.get(userId);
            User recipient = users.get(recipientId);
            if (user != null && recipient != null) {
                if (user.getAccount().getBalance() >= amount) {
                    user.getAccount().withdraw(amount);
                    recipient.getAccount().deposit(amount);
                    System.out.println("Transfer successful. Current balance: $" + user.getAccount().getBalance());
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Invalid User ID.");
            }
        }
    }


