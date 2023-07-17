package com.booleanuk.core;

import java.time.LocalDate;

public class Current {
    Currency currentAmount;
    LocalDate date;

    public Current(Currency currentAmount, LocalDate date){
      this.currentAmount = currentAmount;
      this.date = date;
    }

}
