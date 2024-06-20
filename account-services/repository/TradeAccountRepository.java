package repository;

import java.util.HashMap;
import java.util.Map;

import pojo.TradeAccount;

public class TradeAccountRepository {

    private Map<String, TradeAccount> datastore = new HashMap<>();

    /**
     * Method Name: createTradeAcccount
     *  1. Creates an account
     * @param account
     */
    public void createTradeAccount(TradeAccount account) {
        this.datastore.put(account.getId(), account.clone());
    }

    /**
     * Method Name: retrieveTradeAccount
     *  1. retrieves a copy the trade account.
     *  2. 'if statement' implemented to prevent NullPointerException if id returns null and clones it.
     * @param id
     * @return null or trade account object.
     */
    public TradeAccount retrieveTradeAccount(String id) {
        return this.datastore.get(id) == null ? null : this.datastore.get(id).clone();    
    }


    /**
     * Method Name: updateTradeAccount
     *  1. updates trade account with account parameter.
     * @param account
     */
    public void updateTradeAccount(TradeAccount account) {
        this.datastore.put(account.getId(), account.clone());
    }

    /**
     * Method Name: deleteTradeAccount
     *  1. deletes Trade Account
     * @param id
     */
    public void deleteTradeAccount(String id) {
        this.datastore.remove(id);
    }
}
