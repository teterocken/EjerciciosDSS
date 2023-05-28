package es.uca.dss;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CreditCardTest 
{
    private CreditCard creditCard;

    @Before
    public void setup() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate = dateFormat.parse("2025-12-31");
        creditCard = new CreditCard("1234567890123456", "John Doe", expirationDate, 123, 1000.0);
    }

    @Test
    public void testGetCardNumber() {
        assertEquals("1234567890123456", creditCard.getCardNumber());
    }

    @Test
    public void testGetCardHolderName() {
        assertEquals("John Doe", creditCard.getCardHolderName());
    }

    @Test
    public void testGetExpirationDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedExpirationDate = dateFormat.parse("2025-12-31");
        assertEquals(expectedExpirationDate, creditCard.getExpirationDate());
    }

    @Test
    public void testIsExpired() throws ParseException {
        assertFalse(creditCard.isExpired());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expiredDate = dateFormat.parse("2022-01-01");
        creditCard = new CreditCard("1234567890123456", "John Doe", expiredDate, 123, 1000.0);
        assertTrue(creditCard.isExpired());
    }

    @Test
    public void testIsValidCvv() {
        assertTrue(creditCard.isValidCvv(123));
        assertFalse(creditCard.isValidCvv(456));
    }

    @Test
    public void testGetCreditLimit() {
        assertEquals(1000.0, creditCard.getCreditLimit(), 0.001);
    }

    @Test
    public void testGetCurrentBalance() {
        assertEquals(0.0, creditCard.getCurrentBalance(), 0.001);
    }

    @Test
    public void testMakePayment() {
        creditCard.makePayment(200.0);
        assertEquals(-200.0, creditCard.getCurrentBalance(), 0.001);
    }

    @Test
    public void testCharge() {
        boolean success = creditCard.charge(500.0);
        assertTrue(success);
        assertEquals(500.0, creditCard.getCurrentBalance(), 0.001);

        success = creditCard.charge(600.0);
        assertFalse(success);
        assertEquals(500.0, creditCard.getCurrentBalance(), 0.001);
    }
}
