package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.service.FinancialTransactionService;

import java.time.LocalDate;

public class FinancialTransactionTest {

    public static void main(String[] args) throws Exception {
        User user = User.builder()
                .username("john_doe")
                .password("password123")
                .email("john.doe@example.com")
                .build();

        FinancialTransaction transaction = FinancialTransaction.builder()
                .date(LocalDate.now())
                .tracingCode(98765)
                .user(user)
                .build();

        // ذخیره تراکنش مالی
        FinancialTransactionService.getFinancialTransactionService().save(transaction);
        System.out.println(transaction);

        // مثال برای جستجو با ویژگی‌های مختلف
        System.out.println(FinancialTransactionService.getFinancialTransactionService().findById(transaction.getId()));
        System.out.println(FinancialTransactionService.getFinancialTransactionService().findByTracingCode(98765));

        // حذف تراکنش مالی
        FinancialTransactionService.getFinancialTransactionService().remove(transaction.getId());
        System.out.println("Financial Transaction removed!! " + transaction.getId());
    }
}
