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

    public PaymentAccountServiceImpl() {
    }

    @Override
    public PaymentAccount create(User user, Bank bank) {
        PaymentAccount paymentAccount = new PaymentAccount(
                ++currentMaxId,
                user.getId(),
                bank.getName(),
                0L
        );

        if (ServiceManager.getBankService().isClient(bank, user)) {
            bank.setNumberOfClients(bank.getNumberOfClients() + 1);
            ServiceManager.getBankService().update(bank);
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
        Function<PaymentAccount, Boolean> trueCondition = obj -> Boolean.TRUE;
        return container.getByCondition(trueCondition);
    }

    @Override
    public void update(PaymentAccount obj) {
        container.update(obj);
    }

    @Override
    public void delete(PaymentAccount obj) {

        Function<Bank, Boolean> find_bank = bank -> bank.getName().equals(obj.getBankName());

        Bank bank = ServiceManager.getBankService().getByCondition(find_bank).get(0);
        User user = ServiceManager.getUserService().get(obj.getUserId());

        container.delete(obj);
        if (ServiceManager.getBankService().isClient(bank, user)) {
            bank.setNumberOfClients(bank.getNumberOfClients() - 1);
            ServiceManager.getBankService().update(bank);
        }

        container.delete(obj);

    }

    public ArrayList<PaymentAccount> getByCondition(Function<PaymentAccount, Boolean> condition) {
        return container.getByCondition(condition);
    }


}
