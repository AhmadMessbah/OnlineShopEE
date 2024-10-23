package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.service.BankService;

public class BankTest {

    public static void main(String[] args) throws Exception {
        Bank bank1 = Bank.builder()
                .name("Bank of America")
                .accountNumber("1234567890")
                .branchCode(101)
                .build();

        Bank bank2 = Bank.builder()
                .name("Chase Bank")
                .accountNumber("0987654321")
                .branchCode(202)
                .build();

        // ذخیره بانک‌ها
        BankService.getBankService().save(bank1);
        BankService.getBankService().save(bank2);

        // نمایش اطلاعات بانک‌ها
        System.out.println(bank1);
        System.out.println(bank2);

        // حذف یک بانک
        BankService.getBankService().remove(bank1.getId());
        System.out.println("Bank removed!! " + bank1.getId());
    }
}
