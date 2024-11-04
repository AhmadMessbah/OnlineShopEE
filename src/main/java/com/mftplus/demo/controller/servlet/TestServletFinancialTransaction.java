package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/testFinancialTransaction", loadOnStartup = 1)
public class TestServletFinancialTransaction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        User user = User.builder()
                .username("testUser") // نام کاربری
                .build();

        // ایجاد یک شیء FinancialTransaction
        FinancialTransaction financialTransaction = FinancialTransaction.builder()
                .date(LocalDate.now()) // تاریخ معامله
                .tracingCode(123456789) // کد ردیابی
                .user(user) // کاربر مرتبط
                .build();

        try {
            // ذخیره معامله مالی در پایگاه داده
            FinancialTransactionService.getFinancialTransactionService().save(financialTransaction);
            System.out.println(financialTransaction); // چاپ اطلاعات معامله مالی
            resp.getWriter().write("Financial transaction saved successfully: " + financialTransaction);
        } catch (Exception e) {
            System.out.println("Error FinancialTransaction Loading..." + e.getMessage());
            try {
                resp.getWriter().write("Error saving financial transaction: " + e.getMessage());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
