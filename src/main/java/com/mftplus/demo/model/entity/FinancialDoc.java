package com.mftplus.demo.model.entity;

import java.time.LocalDate;

public class FinancialDoc {
    long id ;
    long docNumber;
    LocalDate date;
    String description;
    FinancialTransaction financialTransaction;
}
