package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;

import java.util.ArrayList;


public interface BankService extends Service<Bank> {
    Bank create(String name);

    boolean isClient(Bank bank, User user);

    Bank get(Long id);

    ArrayList<Bank> read();

    void printBankInfo(Bank bank);

}
