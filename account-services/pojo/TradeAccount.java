package pojo;

public abstract class TradeAccount {

    private String id;

    public TradeAccount(String id) {
        setId(id);
    }

    public abstract TradeAccount clone();

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}