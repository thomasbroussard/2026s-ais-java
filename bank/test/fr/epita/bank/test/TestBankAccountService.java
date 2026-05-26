package fr.epita.bank.test;


import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;
import fr.epita.bank.services.BankAccountService;

public class TestBankAccountService {


    //TDD
    public static void main(String[] args) {
        checkBankAccountServiceComputeInterest();
        checkBankAccountServiceBuyStock();


    }

    private static void checkBankAccountServiceBuyStock() {
        //initialization
        InvestmentAccount account = new InvestmentAccount();
        account.setBalance(10000.0);
        Stock stock = new Stock();
        stock.setTicker("GOLD");
        stock.setCurrentPrice(1800.0);
        int quantity = 3;

        //action
        StockOrder stockorder = BankAccountService.buyStock(account, stock, quantity);

        //verification
        if (Math.abs(account.getBalance() - 4600) < 0.0001){
            System.out.println("checkBankAccountServiceBuyStock: test passed");
        }else {
            System.out.println("checkBankAccountServiceBuyStock: test failed");
        }
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
            System.out.println("checkBankAccountServiceComputeInterest#gainCheck: test passed");
        }else{
            System.out.println("checkBankAccountServiceComputeInterest#gainCheck: test failed");
        }

        Double balance = savingsAccount.getBalance();
        if (balance == initialBalance + expectedGain){
            System.out.println("checkBankAccountServiceComputeInterest#balanceCheck: test passed");
        }else {
            System.out.println("checkBankAccountServiceComputeInterest#balanceCheck: test failed");
        }
    }


}
