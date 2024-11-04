package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.entity.FinancialDoc;
import com.mftplus.demo.model.service.FinancialDocService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/testFinancialDoc", loadOnStartup = 1)
public class TestServletFinancialDoc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // ایجاد یک شیء FinancialDoc
        FinancialDoc financialDoc = FinancialDoc.builder()
                .docNumber(123456) // شماره سند
                .date(LocalDate.now()) // تاریخ سند
                .description("This is a sample financial document.") // توضیحات سند
                .financialTransaction(new FinancialTransaction()) // فرض کنید یک شیء FinancialTransaction موجود است
                .build();

        try {
            // ذخیره سند مالی در پایگاه داده
            FinancialDocService.getFinancialDocService().save(financialDoc);
            System.out.println(financialDoc); // چاپ اطلاعات سند مالی
            resp.getWriter().write("Financial document saved successfully: " + financialDoc);
        } catch (Exception e) {
            System.out.println("Error FinancialDoc Loading..." + e.getMessage());
            try {
                resp.getWriter().write("Error saving financial document: " + e.getMessage());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
