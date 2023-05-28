package es.uca.dss;

import java.util.Date;

public class CreditCard 
{
    private String cardNumber;
    private String cardHolderName;
    private Date expirationDate;
    private int cvv;
    private double creditLimit;
    private double currentBalance;
    
    public CreditCard(String cardNumber, String cardHolderName, Date expirationDate, int cvv, double creditLimit) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
        this.currentBalance = 0.0;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public String getCardHolderName() {
        return cardHolderName;
    }
    
    public Date getExpirationDate() {
        return expirationDate;
    }
    
    public boolean isExpired() {
        Date currentDate = new Date();
        return expirationDate.compareTo(currentDate) < 0;
    }
    
    public boolean isValidCvv(int cvv) {
        return this.cvv == cvv;
    }
    
    public double getCreditLimit() {
        return creditLimit;
    }
    
    public double getCurrentBalance() {
        return currentBalance;
    }
    
    public void makePayment(double amount) {
        currentBalance -= amount;
    }
    
    public boolean charge(double amount) {
        if (currentBalance + amount <= creditLimit) {
            currentBalance += amount;
            return true;
        } else {
            return false;
        }
    }
}
