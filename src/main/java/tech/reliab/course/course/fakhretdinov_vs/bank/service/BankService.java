package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;

import java.util.Random;

public interface BankService {

    Bank create(String name);
    Bank read();
    void update(Bank bank);
    void delete(Bank bank);

}
