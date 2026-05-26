package fr.epita.bank.test;


import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.services.BankAccountService;

public class TestBankAccountService {


    //TDD
    public static void main(String[] args) {
        //checkBankAccountServiceComputeInterest();



    }

    private static void checkBankAccountServiceComputeInterest() {
        //context / hypothesis / initialization
        double initialBalance = 1000.0;
        double interestRate = 0.02;
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setBalance(initialBalance);
        savingsAccount.setInterestRate(interestRate);


        //action (this is what is under test)
        Double gain = BankAccountService.computeInterests(savingsAccount);


        //verification / assertion
        double expectedGain = initialBalance * interestRate;
        System.out.println("gain is " + gain);
        if (Math.abs(expectedGain - gain) < 0.0001 ){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        Double balance = savingsAccount.getBalance();
        if (balance == initialBalance + expectedGain){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
    }


}
