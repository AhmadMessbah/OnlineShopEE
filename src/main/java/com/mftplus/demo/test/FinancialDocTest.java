package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.FinancialDoc;
import com.mftplus.demo.model.entity.FinancialTransaction;
import com.mftplus.demo.model.service.FinancialDocService;

import java.time.LocalDate;

public class FinancialDocTest {

    public static void main(String[] args) throws Exception {
        FinancialTransaction financialTransaction = FinancialTransaction.builder()
                .tracingCode(12345)
                .date(LocalDate.now())
                .build();

        FinancialDoc financialDoc = FinancialDoc.builder()
                .docNumber(1001)
                .date(LocalDate.of(2024, 10, 23))
                .description("Invoice for services")
                .financialTransaction(financialTransaction)
                .build();

        // ذخیره سند مالی
        FinancialDocService.getFinancialDocService().save(financialDoc);
        System.out.println(financialDoc);

        // مثال برای جستجو با ویژگی‌های مختلف
        System.out.println(FinancialDocService.getFinancialDocService().findByDocNumber(1001));

        // حذف سند مالی
        FinancialDocService.getFinancialDocService().remove(financialDoc.getId());
        System.out.println("Financial Document removed!! " + financialDoc.getId());
    }
}
