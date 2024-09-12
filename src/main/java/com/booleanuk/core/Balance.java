package com.booleanuk.core;
public class Balance {
    private int intPart, decimalPart;
    public Balance(int intPart, int decimalPart){
        this.intPart = intPart;
        int temp;
        if(decimalPart<0){
            temp = -decimalPart;
        }else{
            temp = decimalPart;
        }
        while(temp>100){
            temp /=100;
            this.intPart++;
        }
        this.decimalPart = temp;

    }
    public int getIntPart(){
        return this.intPart;
    }
    public int getDecimalPart(){
        return this.decimalPart;
    }
    @Override
    public String toString(){
        return this.getIntPart()+","+this.getDecimalPart();
    }
    //the interact method will either add or remove(if the balance is positive or negative) balances
    public void interact(Balance balance){
        this.intPart += balance.getIntPart();
        if(balance.getDecimalPart()>this.getDecimalPart() && balance.getIntPart()<=0){
            this.intPart--;
            this.decimalPart +=100;
            this.decimalPart -= balance.getDecimalPart();
        }
        if(this.getDecimalPart()>=100){
            this.decimalPart -= 100;
            this.intPart++;
        }
    }

}
