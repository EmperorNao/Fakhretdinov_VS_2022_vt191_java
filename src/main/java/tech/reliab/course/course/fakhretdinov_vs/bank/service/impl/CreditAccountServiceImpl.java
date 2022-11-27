package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.CreditAccountService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.function.Function;

public class CreditAccountServiceImpl implements CreditAccountService {


    private static Long currentMaxId = 0L;
    ServiceContainer<CreditAccount> container = new ServiceContainerImpl<>();

    @Override
    public CreditAccount create(User user,
                                Bank bank,
                                LocalDate creditStart,
                                LocalDate creditEnd,
                                Long amountOfMoney,
                                Employee creditEmployee,
                                PaymentAccount paymentAccount) {

        int duration = (int)ChronoUnit.MONTHS.between(creditStart, creditEnd);
        Long monthly_payment = amountOfMoney / duration;
        CreditAccount creditAccount = new CreditAccount(
                ++currentMaxId,
                user.getId(),
                bank.getName(),
                creditStart,
                creditEnd,
                duration,
                amountOfMoney,
                monthly_payment,
                bank.getInterestRate(),
                creditEmployee.getId(),
                paymentAccount.getId()
        );

        if (ServiceManager.getBankService().isClient(bank, user)) {
            bank.setNumberOfClients(bank.getNumberOfClients() + 1);
            ServiceManager.getBankService().update(bank);
        }

        container.update(creditAccount);
        return creditAccount;

    }

    @Override
    public CreditAccount get(Long id) {
        return container.get(id);
    }

    @Override
    public ArrayList<CreditAccount> read() {
        Function<CreditAccount, Boolean> trueCondition = obj -> Boolean.TRUE;
        return container.getByCondition(trueCondition);
    }

    @Override
    public void update(CreditAccount obj) {
        container.update(obj);
    }

    @Override
    public void delete(CreditAccount obj) {

        Function<Bank, Boolean> find_bank = bank -> bank.getName().equals(obj.getBankName());

        Bank bank = ServiceManager.getBankService().getByCondition(find_bank).get(0);
        User user = ServiceManager.getUserService().get(obj.getUserId());

        container.delete(obj);
        if (ServiceManager.getBankService().isClient(bank, user)) {
            bank.setNumberOfClients(bank.getNumberOfClients() - 1);
            ServiceManager.getBankService().update(bank);
        }

    }

    public ArrayList<CreditAccount> getByCondition(Function<CreditAccount, Boolean> condition) {
        return container.getByCondition(condition);
    }


}
