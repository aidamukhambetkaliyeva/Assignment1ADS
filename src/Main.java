import java.util.*;

public class Main {
    static LinkedList<BankAccount1> accounts = new LinkedList<>();
    static Stack<String> history = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount1> accountRequests = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add account");
            System.out.println("2. Display accounts");
            System.out.println("3. Search by username");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Bill payment");
            System.out.println("7. Last transaction");
            System.out.println("8. Undo transaction");
            System.out.println("9. Add bill to queue");
            System.out.println("10. Process next bill");
            System.out.println("11. Show bill queue");
            System.out.println("12. Request new account");
            System.out.println("13. Process account request");
            System.out.println("14. Show account requests");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addAccount();
                case 2 -> displayAccounts();
                case 3 -> searchAccount();
                case 4 -> deposit();
                case 5 -> withdraw();
                case 6 -> billPayment();
                case 7 -> peekHistory();
                case 8 -> undo();
                case 9 -> addBill();
                case 10 -> processBill();
                case 11 -> showQueue();
                case 12 -> addRequest();
                case 13 -> processRequest();
                case 14 -> showRequests();
                case 0 -> System.exit(0);
            }
        }
    }

    static void addAccount() {
        System.out.print("Enter account number: ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        System.out.print("Enter balance: ");
        double bal = sc.nextDouble();

        accounts.add(new BankAccount1(num, name, bal));
        System.out.println("Account added successfully");
    }

    static void displayAccounts() {
        System.out.println("Accounts List:");
        int i = 1;
        for (BankAccount1 acc : accounts) {
            System.out.println(i + ". " + acc.username + " – Balance: " + acc.balance);
            i++;
        }
    }

    static void searchAccount() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        for (BankAccount1 acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) {
                System.out.println("Found: " + acc.username + " – Balance: " + acc.balance);
                return;
            }
        }
    }

    static BankAccount1 findAccount(String name) {
        for (BankAccount1 acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) {
                return acc;
            }
        }
        return null;
    }

    static void deposit() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        BankAccount1 acc = findAccount(name);
        if (acc != null) {
            System.out.print("Deposit: ");
            double amount = sc.nextDouble();
            acc.balance += amount;
            history.push("Deposit " + amount + " to " + acc.username);
            System.out.println("New balance: " + acc.balance);
        }
    }

    static void withdraw() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        BankAccount1 acc = findAccount(name);
        if (acc != null) {
            System.out.print("Withdraw: ");
            double amount = sc.nextDouble();
            if (acc.balance >= amount) {
                acc.balance -= amount;
                history.push("Withdraw " + amount + " from " + acc.username);
                System.out.println("New balance: " + acc.balance);
            }
        }
    }

    static void billPayment() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        BankAccount1 acc = findAccount(name);
        if (acc != null) {
            System.out.print("Payment: ");
            double amount = sc.nextDouble();
            if (acc.balance >= amount) {
                acc.balance -= amount;
                history.push("Bill payment " + amount + " from " + acc.username);
                System.out.println("New balance: " + acc.balance);
            }
        }
    }

    static void peekHistory() {
        if (!history.isEmpty()) {
            System.out.println("Last transaction: " + history.peek());
        }
    }

    static void undo() {
        if (!history.isEmpty()) {
            System.out.println("Undo -> " + history.pop());
        }
    }

    static void addBill() {
        sc.nextLine();
        System.out.print("Enter bill name: ");
        String bill = sc.nextLine();
        billQueue.add(bill);
        System.out.println("Added: " + bill);
    }

    static void processBill() {
        if (!billQueue.isEmpty()) {
            System.out.println("Processing: " + billQueue.poll());
        }
    }

    static void showQueue() {
        if (!billQueue.isEmpty()) {
            System.out.println("Remaining:");
            for (String bill : billQueue) {
                System.out.println(bill);
            }
        }
    }

    static void addRequest() {
        System.out.print("Enter account number: ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();
        System.out.print("Enter balance: ");
        double bal = sc.nextDouble();

        accountRequests.add(new BankAccount1(num, name, bal));
        System.out.println("Request added");
    }

    static void processRequest() {
        if (!accountRequests.isEmpty()) {
            BankAccount1 acc = accountRequests.poll();
            accounts.add(acc);
            System.out.println("Account approved: " + acc.username);
        }
    }

    static void showRequests() {
        if (!accountRequests.isEmpty()) {
            System.out.println("Pending requests:");
            for (BankAccount1 acc : accountRequests) {
                System.out.println(acc.username);
            }
        }
    }
}