import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //default variables
        String admin_username = "admin";
        String admin_password = "admin";
        int balance = 10000;
        String pin = "1234";
        int count_tries = 5;

        System.out.println("Welcome to Hussam's bank");
        String user_username, user_password;
        // login progress is true while the username or password is not correct
        boolean login_progress = true;
        // login loop start
        do {
            System.out.print("Enter username: ");
            user_username = scn.next();
            System.out.print("Enter password: ");
            user_password = scn.next();
            // check if username or password are correct start
            if (!user_username.equals(admin_username) || (!user_password.equals(admin_password))) {
                System.out.println("username or password is not correct try again");
            }else {
                System.out.printf("welcome %s again\n", user_username);
                login_progress = false;
            }
        }while(login_progress);
        //bank progress is true while you do not chose exit, or you are not out of tries
        boolean bank_progress = true;
        //check pin if correct do bank operations
        System.out.print("Enter PIN for your card: ");
        String user_pin = scn.next();
        if (!user_pin.equals(pin)){
            System.out.println("you entered wrong pin");
        }else {
            // banking process
            while (bank_progress) {
                System.out.println("""
                        Welcome to Hussam's bank
                        chose which operation do you want? 1 - 5
                        1- Balance Inquiry
                        2- Cash Withdrawal
                        3- Cash Deposit
                        4- PIN Change
                        5- Exit
                        """);
                int user_chose = scn.nextInt();
                switch (user_chose) {
                    case 1: // Balance Inquiry
                        System.out.printf("your balance: %d\n", balance);
                        break;
                    case 2: // Cash Withdrawal
                        System.out.print("how much do you want to withdrawal: ");
                        int withdrawal_money = scn.nextInt();
                        // check your balance
                        if (withdrawal_money > balance) {
                            System.out.printf("you reached your account limit your balance: %d\n", balance);
                        } else {
                            balance -= withdrawal_money;
                            System.out.printf("your balance: %d\n", balance);
                        }
                        break;
                    case 3: // Cash Deposit
                        System.out.print("how much do you want to deposit: ");
                        int deposit_money = scn.nextInt();
                        balance += deposit_money;
                        System.out.printf("your new balance: %d\n", balance);
                        break;
                    case 4: // PIN Change
                        System.out.print("Enter old PIN: ");
                        String old_pin = scn.next();
                        // check the old pin
                        if (!old_pin.equals(pin)) {
                            count_tries--;
                            System.out.printf("please enter correct PIN you have %d tries\n", count_tries);
                            if (count_tries == 0){
                                bank_progress = false;
                                System.out.println("you reached max tries try again");
                            }else {
                                continue;
                            }
                        } else {
                            System.out.print("Enter the new pin it must be digits and only accepted four digits: ");
                            String new_pin = scn.next();
                            // regex for only digits accepted
                            if (!new_pin.matches("\\d+")) {
                                System.out.println("please write only digits");
                            } else if (new_pin.length() != 4) {
                                System.out.println("your new pin is longer than 4 digits it must be 4 digits");
                            } else {
                                pin = new_pin;
                                System.out.printf("your new pin is: %s\n", pin);
                            }
                        }
                        break;
                    case 5:
                        bank_progress = false;
                        System.out.println("Thank you for using our bank have good day");
                        break;
                    default:
                        System.out.println("Enter correct number");

                }

            }
        }

    }
}