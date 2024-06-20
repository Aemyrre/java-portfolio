package service;

import java.math.BigDecimal;

import pojo.MarginAccount;
import repository.TradeAccountRepository;

public class MarginAccountService implements TradeAccountService{

    private TradeAccountRepository repository;


    public MarginAccountService(TradeAccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public void deposit(String id, BigDecimal amount) {
        MarginAccount account = retrieveTradeAccount(id);
        account.setMargin(account.getMargin().add(amount));
        updateTradeAccount(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        MarginAccount account = retrieveTradeAccount(id);
        account.setMargin(account.getMargin().subtract(amount));
        updateTradeAccount(account);
    }

    /**
     * Method Name: createTradeAcccount
     *  1. calls createTradeAccount in TradeAccountRepository
     *  2. creates an account
     * @param account
     */
    public void createTradeAccount(MarginAccount account) {
        this.repository.createTradeAccount(account);
    }

    /**
     * Method Name: retrieveTradeAccount
     *  1. calls retrieveTradeAccount in TradeAccountRepository
     *  2. retrieves account
     * @param id
     * @return null or trade account object.
     */
    public MarginAccount retrieveTradeAccount(String id) {
        return (MarginAccount) this.repository.retrieveTradeAccount(id);   
    }


    /**
     * Method Name: updateTradeAccount
     *  1. calls updateTradeAccount in TradeAccountRepository
     *  2. updates account
     * @param account
     */
    public void updateTradeAccount(MarginAccount account) {
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