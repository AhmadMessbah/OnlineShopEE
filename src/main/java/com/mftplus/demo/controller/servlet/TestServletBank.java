package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.service.BankService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/testBank", loadOnStartup = 1)
public class TestServletBank extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // ایجاد یک شیء Bank
        Bank bank = Bank.builder()
                .name("Bank of Example") // نام بانک
                .accountNumber("123456789") // شماره حساب
                .branchCode(101) // کد شعبه
                .build();

        try {
            // ذخیره بانک در پایگاه داده
            BankService.getBankService().save(bank);
            System.out.println(bank); // چاپ اطلاعات بانک
            resp.getWriter().write("Bank saved successfully: " + bank);
        } catch (Exception e) {
            System.out.println("Error Bank Loading..." + e.getMessage());
            try {
                resp.getWriter().write("Error saving bank: " + e.getMessage());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
