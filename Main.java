import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Customers");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Enter account number: ");
                    int accNo = sc.nextInt();

                    System.out.print("Enter initial balance: ");
                    double bal = sc.nextDouble();

                    BankAccount account = new BankAccount(accNo, bal);
                    Customer customer = new Customer(name, account);
                    bank.addCustomer(customer);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accNo = sc.nextInt();

                    Customer c1 = bank.findCustomer(accNo);
                    if (c1 != null) {
                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();
                        c1.getAccount().deposit(amt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accNo = sc.nextInt();

                    Customer c2 = bank.findCustomer(accNo);
                    if (c2 != null) {
                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();
                        c2.getAccount().withdraw(amt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accNo = sc.nextInt();

                    Customer c3 = bank.findCustomer(accNo);
                    if (c3 != null) {
                        System.out.println("Balance: " +
                                c3.getAccount().getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    bank.displayAllCustomers();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}