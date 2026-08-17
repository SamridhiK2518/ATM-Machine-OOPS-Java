// removed package declaration to match file location

import java.util.Scanner;

class ATM{

    float Balance;
    int pin= 1825;
    Scanner sc = new Scanner(System.in);

    public void checkpin()
    {
        System.out.println("Enter your pin: ");
        int enteredpin= sc.nextInt();
        if(enteredpin==pin) {
            menu();
        }
        else{
            System.out.println("Enter a valid pin");
            checkpin();
        }
    }
    public void menu()
    {
        System.out.println("Enter your choice: ");
        System.out.println("1: Check A/C Balance");
        System.out.println("2: Withdraw Money");
        System.out.println("3: Deposit Money");
        System.out.println("4: Exit");

        int opt= sc.nextInt();

        switch(opt) {
            case 1 -> checkbalance();
            case 2 -> withdrawmoney();
            case 3 -> depositmoney();
            case 4 -> System.out.println("Thank you for using our ATM service");
            default -> System.out.println("Invalid Choice");
        }
    }

    public void checkbalance(){
        System.out.println("Balance: "+ Balance);
        menu();
    }
    public void withdrawmoney(){
        System.out.println("Enter amount to withdraw: ");
        float amt= sc.nextFloat();
        if(amt>Balance){
            System.out.println("Insufficient Balance");
        }
        else{
            Balance= Balance- amt;
            System.out.println("Money Withdrawn successfully");
        }
        menu();
    }
    public void depositmoney(){
        System.out.println("Enter amount to deposit: ");
        float depamt= sc.nextFloat();
        Balance= Balance+ depamt;
        System.out.println("Money Deposited successfully");
        menu();
    }

    public void closeScanner() {
        sc.close();
    }
}
public class Machine{
    public static void main(String[]args){
        ATM obj= new ATM();
        obj.checkpin();
        obj.closeScanner();
    }
}