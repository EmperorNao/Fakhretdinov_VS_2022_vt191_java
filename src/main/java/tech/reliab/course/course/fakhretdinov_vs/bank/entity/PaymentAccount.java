package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

public class PaymentAccount {

    private Long id;
    private User user;
    private String bankName;
    private long amountOfMoney;

    public PaymentAccount(Long id, User user, String bankName, Long amountOfMoney) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

}
