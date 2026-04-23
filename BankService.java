import java.util.ArrayList;

public class BankService {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully!");
    }

    public Customer findCustomer(int accountNumber) {
        for (Customer c : customers) {
            if (c.getAccount().getAccountNumber() == accountNumber) {
                return c;
            }
        }
        return null;
    }

    public void displayAllCustomers() {
        for (Customer c : customers) {
            System.out.println("Name: " + c.getName() +
                    ", Account No: " + c.getAccount().getAccountNumber() +
                    ", Balance: " + c.getAccount().getBalance());
        }
    }
}