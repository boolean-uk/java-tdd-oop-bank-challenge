package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface  BankStatement {
    double amount();

    LocalDate date();

    double signedAmount();



   // public LocalDate getDate(){
  //      return this.date = LocalDate.now();
 //   }

}
