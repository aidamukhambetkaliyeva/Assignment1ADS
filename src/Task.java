import java.util.*;

public class Task {
    static LinkedList<BankAccount1> accounts = new LinkedList<>();
    static Stack<String> history = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount1> accountRequests = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        accounts.add(new BankAccount1(1, "Ali", 150000));
        accounts.add(new BankAccount1(2, "Sara", 220000));
        accounts.add(new BankAccount1(3, "Dana", 180000));

        while (true) {
            System.out.println("\n1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> bankMenu();
                case 2 -> atmMenu();
                case 3 -> adminMenu();
                case 4 -> System.exit(0);
            }
        }
    }

    static void bankMenu() {
        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Submit account opening request");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Add bill payment");
            System.out.println("5. Back");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> submitAccountRequest();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> addBillPayment();
                case 5 -> {
                    return;
                }
            }
        }
    }

    static void atmMenu() {
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Balance enquiry");
            System.out.println("2. Withdraw");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> balanceEnquiry();
                case 2 -> withdraw();
                case 3 -> {
                    return;
                }
            }
        }
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View pending account requests");
            System.out.println("2. Process next account request");
            System.out.println("3. View bill payment queue");
            System.out.println("4. Process next bill payment");
            System.out.println("5. View last transaction");
            System.out.println("6. Undo last transaction");
            System.out.println("7. View all accounts");
            System.out.println("8. Back");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> showAccountRequests();
                case 2 -> processAccountRequest();
                case 3 -> showBillQueue();
                case 4 -> processBillPayment();
                case 5 -> showLastTransaction();
                case 6 -> undoTransaction();
                case 7 -> displayAccounts();
                case 8 -> {
                    return;
                }
            }
        }
    }

    static void submitAccountRequest() {
        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        accountRequests.add(new BankAccount1(number, username, balance));
        System.out.println("Account opening request submitted");
    }

    static void deposit() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        BankAccount1 acc = findAccount(username);

        if (acc != null) {
            System.out.print("Deposit amount: ");
            double amount = sc.nextDouble();
            acc.balance += amount;
            history.push("Deposit " + amount + " to " + acc.username);
            System.out.println("New balance: " + acc.balance);
        }
    }

    static void withdraw() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        BankAccount1 acc = findAccount(username);

        if (acc != null) {
            System.out.print("Withdraw amount: ");
            double amount = sc.nextDouble();
            if (acc.balance >= amount) {
                acc.balance -= amount;
                history.push("Withdraw " + amount + " from " + acc.username);
                System.out.println("New balance: " + acc.balance);
            }
        }
    }

    static void addBillPayment() {
        sc.nextLine();
        System.out.print("Enter bill name: ");
        String bill = sc.nextLine();
        billQueue.add(bill);
        history.push("Bill payment request added: " + bill);
        System.out.println("Added: " + bill);
    }

    static void balanceEnquiry() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        BankAccount1 acc = findAccount(username);

        if (acc != null) {
            System.out.println("Balance: " + acc.balance);
        }
    }

    static void showAccountRequests() {
        if (accountRequests.isEmpty()) {
            return;
        }

        System.out.println("Pending requests:");
        for (BankAccount1 acc : accountRequests) {
            System.out.println(acc.accountNumber + " - " + acc.username + " - " + acc.balance);
        }
    }

    static void processAccountRequest() {
        if (!accountRequests.isEmpty()) {
            BankAccount1 acc = accountRequests.poll();
            accounts.add(acc);
            System.out.println("Processed and added account: " + acc.username);
        }
    }

    static void showBillQueue() {
        if (billQueue.isEmpty()) {
            return;
        }

        System.out.println("Bill payment queue:");
        for (String bill : billQueue) {
            System.out.println(bill);
        }
    }

    static void processBillPayment() {
        if (!billQueue.isEmpty()) {
            String bill = billQueue.poll();
            history.push("Processed bill payment: " + bill);
            System.out.println("Processing: " + bill);
        }
    }

    static void showLastTransaction() {
        if (!history.isEmpty()) {
            System.out.println("Last transaction: " + history.peek());
        }
    }

    static void undoTransaction() {
        if (!history.isEmpty()) {
            System.out.println("Undo -> " + history.pop());
        }
    }

    static void displayAccounts() {
        if (accounts.isEmpty()) {
            return;
        }

        System.out.println("Accounts List:");
        int i = 1;
        for (BankAccount1 acc : accounts) {
            System.out.println(i + ". " + acc.username + " - Balance: " + acc.balance);
            i++;
        }
    }

    static BankAccount1 findAccount(String username) {
        for (BankAccount1 acc : accounts) {
            if (acc.username.equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }
}