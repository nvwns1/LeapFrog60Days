package Day3OOPSConcept;

//Inheritance
class BankAccount {
    public String accountHolderName;
    public String accountNumber;
    public double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingAccount extends BankAccount {
    int interest;

    public SavingAccount(String accountHolderName, String accountNumber, double balance, int interest) {
        super(accountHolderName, accountNumber, balance);
        this.interest = interest;
    }

    public void addInterestAmount() {
        super.balance += super.balance * interest;
    }
}


public class Day3OopsInheritance {
    public static void main(String[] args) {
        SavingAccount s1 = new SavingAccount("Ram", "2345", 1000, 2);
        s1.deposit(1000);
        s1.addInterestAmount();
        System.out.println("Balance of first Object " + s1.getBalance());

        BankAccount b1 = new SavingAccount("John Doe", "12345", 500, 5);
        b1.withdraw(200);
        System.out.println("Balance of Second Object " + b1.getBalance());
    }
}
