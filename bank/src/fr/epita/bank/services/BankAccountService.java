package fr.epita.bank.services;

import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;

public class BankAccountService {


    public static Double computeInterests(SavingsAccount savingsAccount) {
        Double gain = savingsAccount.getBalance() * savingsAccount.getInterestRate();
        savingsAccount.setBalance(savingsAccount.getBalance() + gain);
        return gain;
    }

    public static StockOrder buyStock(InvestmentAccount account, Stock stock, int quantity) {
        Double currentBalance = account.getBalance();
        double totalValue = quantity * stock.getCurrentPrice();
        if (currentBalance < totalValue){
            System.out.println("cannot buy the required stock quantity");
            return new StockOrder();
        }
        StockOrder stockOrder = new StockOrder();
        stockOrder.setAccount(account);
        stockOrder.setStock(stock);
        stockOrder.setQuantity(quantity);
        stockOrder.setCurrentUnitPrice(stock.getCurrentPrice());
        account.setBalance(currentBalance - totalValue);
        return stockOrder;
    }
}
