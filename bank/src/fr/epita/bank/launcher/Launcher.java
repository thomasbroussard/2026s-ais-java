package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;
import fr.epita.bank.services.BankAccountService;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Thomas");
        String name = customer.getName();

        InvestmentAccount account = new InvestmentAccount();
        account.setBalance(200.0);
        Stock stock = new Stock();
        stock.setTicker("GOLD");
        stock.setCurrentPrice(1800.0);
        int quantity = 3;

        List<StockOrder> stockOrders = new ArrayList<>();

        stockOrders.add(BankAccountService.buyStock(account, stock, quantity));
        stockOrders.add(BankAccountService.buyStock(account, stock, 3));
        stockOrders.add(BankAccountService.buyStock(account, stock, 3));

        //2 use cases:

        // 1. to involve SavingsAccount: compute the yearly gain



        // 2. to involve 1 InvestmentAccount,  3 stock orders, 1 stock


    }


}
