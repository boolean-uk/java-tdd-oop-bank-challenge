package com.booleanuk.core;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<LocalDate> transactionDates = new ArrayList<>();
    private List<Deposit> credits = new ArrayList<>();
    private List<Withdraw> debits = new ArrayList<>();

    private String branch;
 //   private List<Double> balanceList = new ArrayList<>();

  //  private BankStatement bs = new BankStatement();

    public Account(String branch){
        this.transactionDates = transactionDates;
        this.debits = debits;
        this.credits = credits;
        this.branch = branch;
      //  this.balanceList = balanceList;
     //   this.bs = bs;
    }

    public List<LocalDate> getTransactionDates(){
        return this.transactionDates;
    }

    public ArrayList<Double> getCredits(){
        ArrayList<Double> creditsAmount = new ArrayList<>();
        for(int i = 0; i<this.credits.size(); i++){
            creditsAmount.add( this.credits.get(i).amount());
        }
        return creditsAmount;
    }

    public ArrayList<Double> getDebits(){
        ArrayList<Double> debitsAmount = new ArrayList<>();
        for(int i = 0; i<this.debits.size(); i++){
            debitsAmount.add( this.debits.get(i).amount());
            System.out.println(this.debits.size());
        }
        return debitsAmount;
    }


  //  public List<Double> getBalanceList(){
    //    return this.balanceList;
   // }

    public void depositAccount(double amount){
        Deposit deposit = new Deposit(amount);
        transactionDates.add(deposit.date());
        credits.add(deposit);
        debits.add(new Withdraw(0.0));
  //      balanceList.add(bs.deposit(amount));
    }

    public String withdrawAccount(double amount){
        Withdraw withdraw = new Withdraw(amount);
        if(amount > balance(debits.size())){
            return "You don´t have enough money in your account, sorry";
        }
        transactionDates.add(withdraw.date());
        credits.add(new Deposit(0.0));
        debits.add(withdraw);


        return "Thank you for using our services";
    }

    public double balance(int index){
        double balance = 0.0;
        for (int i = 0; i<index; i++){
            balance += debits.get(i).signedAmount() + credits.get(i).signedAmount();

        }
        return balance;
    }

    public String PrintAccount() {
        StringBuilder sb = new StringBuilder();
        sb.append("date       || credit  || debit  || balance" + "\n");
        for (int i = transactionDates.size() - 1; i >= 0; i--) {
            sb.append(transactionDates.get(i) + " " + "||");
            if (credits.get(i).amount() == 0.0) {
                sb.append("         ||");
            } else {
                sb.append(credits.get(i).amount()+"   $||");
            }
            if (debits.get(i).amount() == 0.0) {
                sb.append("        ||");
            } else {
                sb.append(debits.get(i).amount()+"  $||");
            }
            sb.append(balance(i)+"  $" + "\n");


        }
        return sb.toString();

    }



}
