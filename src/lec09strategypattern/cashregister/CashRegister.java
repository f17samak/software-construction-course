package lec09strategypattern.cashregister;

public class CashRegister {
    private double purchase; // total amount of product price bought
    private double payment;  // total amount of payment
    TaxCalculator taxCal;

    //private TaxCalculator taxCal;

   // public CashRegister(TaxCalculator taxCal) {
   public CashRegister() {
        purchase = 0;
        payment = 0;
        //this.taxCal = taxCal;
    }
    public void recordPurchase(double amount){
        purchase += taxCal.calculateTax(amount);
    }

    public void setTaxCal (TaxCalculator tax){
            taxCal = tax;
    }
   /* public void recordPurchase(double amount) {

        purchase += amount;
    }

    public void calculateTax() {

        purchase = purchase + taxCal.calculateTax(purchase);
    }*/

    public void enterPayment(double amount) {

        payment += amount;
    }

    public double giveChange() {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        return change;
    }
}
