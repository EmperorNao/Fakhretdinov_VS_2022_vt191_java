package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.PaymentAccountService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.function.Function;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private static Long currentMaxId = 0L;
    ServiceContainer<PaymentAccount> container = new ServiceContainerImpl<>();
    ServiceManager manager;

    public PaymentAccountServiceImpl() {
    }

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }

    @Override
    public PaymentAccount create(User user, Bank bank) {
        PaymentAccount paymentAccount = new PaymentAccount(
                ++currentMaxId,
                user.getId(),
                bank.getName(),
                0L
        );

        if (manager.bankService.isClient(bank, user)) {
            bank.setNumberOfClients(bank.getNumberOfClients() + 1);
            manager.bankService.update(bank);
        }

        container.update(paymentAccount);
        return paymentAccount;
    }

    @Override
    public PaymentAccount get(Long id) {
        return container.get(id);
    }

    @Override
    public ArrayList<PaymentAccount> read() {
        Function<PaymentAccount, Boolean> always_true = obj -> Boolean.TRUE;
        return container.grep(always_true);
    }

    @Override
    public void update(PaymentAccount obj) {
        container.update(obj);
    }

    @Override
    public void delete(PaymentAccount obj) {

        Function<Bank, Boolean> find_bank = bank -> bank.getName().equals(obj.getBankName());

        Bank bank = manager.bankService.grep(find_bank).get(0);
        User user = manager.userService.get(obj.getUserId());

        container.delete(obj);
        if (manager.bankService.isClient(bank, user)) {
            bank.setNumberOfClients(bank.getNumberOfClients() - 1);
            manager.bankService.update(bank);
        }

        container.delete(obj);

    }

    public ArrayList<PaymentAccount> grep(Function<PaymentAccount, Boolean> func) {
        return container.grep(func);
    }


}
