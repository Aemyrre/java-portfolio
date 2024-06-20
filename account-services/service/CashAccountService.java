package service;

import java.math.BigDecimal;

import pojo.CashAccount;
import repository.TradeAccountRepository;

public class CashAccountService implements TradeAccountService {

    private TradeAccountRepository repository;


    public CashAccountService(TradeAccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public void deposit(String id, BigDecimal amount) {
        CashAccount account = retrieveTradeAccount(id);
        account.setCashBalance(account.getCashBalance().add(amount));
        updateTradeAccount(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        CashAccount account = retrieveTradeAccount(id);
        account.setCashBalance(account.getCashBalance().subtract(amount));
        updateTradeAccount(account);
    }

    /**
     * Method Name: createTradeAcccount
     *  1. calls createTradeAccount in TradeAccountRepository
     *  2. creates an account
     * @param account
     */
    public void createTradeAccount(CashAccount account) {
        this.repository.createTradeAccount(account);
    }

    /**
     * Method Name: retrieveTradeAccount
     *  1. calls retrieveTradeAccount in TradeAccountRepository
     *  2. retrieves account
     * @param id
     * @return null or trade account object.
     */
    public CashAccount retrieveTradeAccount(String id) {
        return (CashAccount) this.repository.retrieveTradeAccount(id);   
    }


    /**
     * Method Name: updateTradeAccount
     *  1. calls updateTradeAccount in TradeAccountRepository
     *  2. updates account
     * @param account
     */
    public void updateTradeAccount(CashAccount account) {
        this.repository.updateTradeAccount(account);
    }

    /**
     * Method Name: deleteTradeAccount
     *  1. calls deleteTradeAccount in TradeAccountRepository
     *  2. deletes Trade Account
     * @param id
     */
    public void deleteTradeAccount(String id) {
        this.repository.deleteTradeAccount(id);
    }

}
