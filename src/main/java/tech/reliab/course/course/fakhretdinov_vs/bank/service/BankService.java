package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;


public interface BankService extends Service<Bank> {
    Bank create(String name);

    boolean isClient(Bank bank, User user);

    Bank get(Long id);

}
