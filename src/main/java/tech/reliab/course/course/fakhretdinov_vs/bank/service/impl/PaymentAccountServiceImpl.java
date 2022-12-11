package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.PaymentAccountService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private Long currentMaxId = 0L;
    ServiceContainer<PaymentAccount> container = new ServiceContainerImpl<>();

    public PaymentAccountServiceImpl() {
    }

    @Override
    public PaymentAccount create(User user, Bank bank) {
        PaymentAccount paymentAccount = new PaymentAccount(
                currentMaxId++,
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
    public PaymentAccount get(Long id) throws WrongIdentifierHandlingException {
        return container.get(id);
    }

    @Override
    public ArrayList<PaymentAccount> read() {
        Function<PaymentAccount, Boolean> trueCondition = obj -> Boolean.TRUE;
        return container.getByCondition(trueCondition);
    }

    @Override
    public void writeToFile(ArrayList<PaymentAccount> paymentAccounts, String fileName) throws WrongIdentifierHandlingException, IOException {

        int numberOfAccounts = paymentAccounts.size();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        //objectOutputStream.write(numberOfAccounts);

//        for (PaymentAccount paymentAccount: paymentAccounts) {
//            objectOutputStream.writeObject(paymentAccount);
//        }

        objectOutputStream.writeObject(paymentAccounts);
        objectOutputStream.flush();
        objectOutputStream.close();

    }

    @Override
    public ArrayList<PaymentAccount> readFromFile(String fileName) throws IOException, ClassNotFoundException {

        ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));
        ArrayList<PaymentAccount> paymentAccounts = (ArrayList<PaymentAccount>)in.readObject();
        in.close();

        return paymentAccounts;

    }


    @Override
    public void update(PaymentAccount obj) {
        container.update(obj);
    }

    @Override
    public void delete(PaymentAccount obj) throws WrongIdentifierHandlingException {

        Function<Bank, Boolean> findBank = bank -> bank.getName().equals(obj.getBankName());

        Bank bank = ServiceManager.getBankService().getByCondition(findBank).get(0);
        User user = ServiceManager.getUserService().get(obj.getUserId());

        container.delete(obj);
        if (!ServiceManager.getBankService().isClient(bank, user)) {
            bank.setNumberOfClients(bank.getNumberOfClients() - 1);
            ServiceManager.getBankService().update(bank);
        }

        container.delete(obj);

    }

    public ArrayList<PaymentAccount> getByCondition(Function<PaymentAccount, Boolean> condition) {
        return container.getByCondition(condition);
    }


}
