package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.enums.BankAtmStatus;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.CreditRatingException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongRequestException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.function.Function;

public class BankServiceImpl implements BankService {

    private Long currentMaxId = 0L;
    private static final Random randomGenerator = new Random();
    ServiceContainer<Bank> container = new ServiceContainerImpl<>();

    @Override
    public Bank create(String name) {

        int rating = randomGenerator.nextInt(100);
        int rate = 20 -  Math.toIntExact(Math.round(20 * rating / 100.0));
        long money = randomGenerator.nextLong(1_000_000L);
        Bank bank = new Bank(
                currentMaxId++,
                name,
                0,
                0,
                0,
                0,
                rating,
                money,
                rate
        );
        container.update(bank);

        return bank;

    }

    @Override
    public Bank get(Long id) throws WrongIdentifierHandlingException {
        return container.get(id);
    }

    @Override
    public ArrayList<Bank> read() {
        Function<Bank, Boolean> trueCondition = obj -> Boolean.TRUE;
        return container.getByCondition(trueCondition);
    }

    @Override
    public void update(Bank obj) {
        container.update(obj);
    }

    @Override
    public void delete(Bank obj) {
        container.delete(obj);
    }

    @Override
    public ArrayList<Bank> getByCondition(Function<Bank, Boolean> condition) {
        return container.getByCondition(condition);
    }

    @Override
    public boolean isClient(Bank bank, User user) {

        Function<PaymentAccount, Boolean> checkPaymentAcc = acc -> acc.getBankName().equals(bank.getName());
        Function<CreditAccount, Boolean> checkCreditAcc = acc -> acc.getBankName().equals(bank.getName());

        ArrayList<PaymentAccount> paymentAccounts = ServiceManager.getPaymentAccountService().getByCondition(checkPaymentAcc);
        ArrayList<CreditAccount> creditAccounts = ServiceManager.getCreditAccountService().getByCondition(checkCreditAcc);

        for (PaymentAccount acc: paymentAccounts) {
            if (acc.getUserId().equals(user.getId())) {
                return Boolean.TRUE;
            }
        }

        for (CreditAccount acc: creditAccounts) {
            if (acc.getUserId().equals(user.getId())) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;

    }

    public void printBankInfo(Bank bank) {

        Function<BankOffice, Boolean> checkOffice = office -> office.getBankId().equals(bank.getId());
        ArrayList<BankOffice> offices = ServiceManager.getBankOfficeService().getByCondition(checkOffice);

        Function<BankAtm, Boolean> checkAtm = atm -> atm.getBankId().equals(bank.getId());
        ArrayList<BankAtm> atms = ServiceManager.getBankAtmService().getByCondition(checkAtm);

        Function<Employee, Boolean> checkEmployee = employee -> employee.getBankId().equals(bank.getId());
        ArrayList<Employee> employees = ServiceManager.getEmployeeService().getByCondition(checkEmployee);

        ArrayList<User> users = new ArrayList<>();
        ArrayList<User> allUsers = ServiceManager.getUserService().read();

        for (User user: allUsers) {

            if (this.isClient(bank, user)) {
                users.add(user);
            }

        }

        System.out.println("Bank:");
        System.out.println(bank);

        System.out.println();
        System.out.println("Offices:");
        for (BankOffice office: offices) {
            System.out.println(office);
        }

        System.out.println();
        System.out.println("Atms:");
        for (BankAtm atm: atms) {
            System.out.println(atm);
        }

        System.out.println();
        System.out.println("Employees:");
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.println("Users:");
        for (User user: users) {
            System.out.println(user);
        }

    }

    private CreditRequest isBankSatisfiesRequest(Bank bank, CreditRequest request) {

        CreditRequest emptyRequest = request;
        if (bank.getNumberOfMoney() <= emptyRequest.getNumberOfMoney()
                || !isUserRatingSatisfiesBankRating(bank.getBankRating(), request.getUserCreditRating())) {
            return null;
        }

        Function<BankOffice, Boolean> findOffice = office -> office.getBankId().equals(bank.getId());
        ArrayList<BankOffice> offices = ServiceManager.getBankOfficeService().getByCondition(findOffice);

        for (BankOffice office: offices) {
            emptyRequest = isOfficeSatisfiesRequest(office, request);
            if (emptyRequest != null) {
                emptyRequest.setBankId(bank.getId());
                return emptyRequest;
            }
        }

        return null;

    }

    private boolean isUserRatingSatisfiesBankRating(int bankRating, int userCreditRating) {
        return bankRating < 50 || userCreditRating > 5000;
    }

    private CreditRequest isAtmSatisfiesRequest(BankAtm atm, CreditRequest request) {

        if (atm.getStatus() == BankAtmStatus.Working
                && atm.getPaymentingMoney()
                && (atm.getNumberOfMoney() >= request.getNumberOfMoney())
        ) {
            request.setAtmId(atm.getId());
            return request;
        }

        return null;

    }

    private CreditRequest isEmployeeSatisfiesRequest(Employee employee, CreditRequest request) {

        if (employee.getCreditCanBeIssued()) {
           request.setEmployeeId(employee.getId());
           return request;
        }
        return null;

    }

    private CreditRequest isOfficeSatisfiesRequest(BankOffice office, CreditRequest request) {

        if (!office.getCreditCanBeIssued() || office.getNumberOfMoney() < request.getNumberOfMoney()) {
            return null;
        }

        CreditRequest emptyRequest = request;

        Function<BankAtm, Boolean> findAtm = atm -> atm.getAddress().equals(office.getAddress());
        ArrayList<BankAtm> atms = ServiceManager.getBankAtmService().getByCondition(findAtm);

        for (BankAtm atm: atms) {
            emptyRequest = isAtmSatisfiesRequest(atm, request);
            if (emptyRequest != null) {
                request = emptyRequest;
                break;
            }
        }

        if (emptyRequest == null) {
            return null;
        }

        Function<Employee, Boolean> checkEmployee = employee -> employee.getBankOfficeId().equals(office.getId());
        ArrayList<Employee> employees = ServiceManager.getEmployeeService().getByCondition(checkEmployee);

        for (Employee employee: employees) {
            emptyRequest = isEmployeeSatisfiesRequest(employee, request);
            if (emptyRequest != null) {
                request = emptyRequest;
                break;
            }
        }

        if (emptyRequest == null) {
            return null;
        }

        request.setOfficeId(office.getId());
        return request;

    }

    @Override
    public CreditRequest createOptimalCreditRequest(long numberOfMoney, int numberOfMonths, int userCreditRating) {

        CreditRequest emptyRequest = new CreditRequest(
                null,
                null,
                null,
                null,
                null,
                numberOfMoney,
                numberOfMonths,
                userCreditRating
        );
        CreditRequest tmpRequest;

        ArrayList<Bank> banks = ServiceManager.getBankService().read();
        Collections.sort(banks);

        for (Bank bank: banks) {
            tmpRequest = isBankSatisfiesRequest(bank, emptyRequest);
            if (tmpRequest != null) {
                return tmpRequest;
            }
        }
        return null;

    }

    @Override
    public CreditAccount getCredit(CreditRequest request) throws WrongRequestException, CreditRatingException, WrongIdentifierHandlingException {

        if (request.getNumberOfMoney() <= 0) {
            throw new WrongRequestException("Выбранная сумма для кредита должна быть больше нуля, а не " +
                    request.getNumberOfMoney(), null);
        }

        if (request.getNumberOfMonths() <= 0) {
            throw new WrongRequestException("Выбранное количество месяцев для кредита должно быть больше нуля, а не " +
                    request.getNumberOfMonths(), null);
        }

        Bank bank = ServiceManager.getBankService().get(request.getBankId());
        if (isBankSatisfiesRequest(bank, request) == null) {
            throw new WrongRequestException("Выбранный банк " + bank.getId() +
                    " не соответствует переданному запросу на кредит", null);
        }

        if (!isUserRatingSatisfiesBankRating(bank.getBankRating(), request.getUserCreditRating())) {
            throw new CreditRatingException(bank.getBankRating(),
                    ServiceManager.getUserService().get(request.getUserId()).getCreditRating(), null);
        }

        BankOffice office = ServiceManager.getBankOfficeService().get(request.getOfficeId());
        if (isOfficeSatisfiesRequest(office, request) == null) {
            throw new WrongRequestException("Выбранный офис " + office.getId() +
                    " не соответствует переданному запросу на кредит", null);
        }

        Employee employee = ServiceManager.getEmployeeService().get(request.getEmployeeId());
        if (isEmployeeSatisfiesRequest(employee, request) == null) {
            throw new WrongRequestException("Выбранный сотрудник " + employee.getId() +
                    "не соответствует переданному запросу на кредит", null);
        }

        BankAtm atm = null;
        if (request.getAtmId() == null) {

            Function<BankAtm, Boolean> findAtm = atm_item -> atm_item.getAddress().equals(office.getAddress());
            ArrayList<BankAtm> atms = ServiceManager.getBankAtmService().getByCondition(findAtm);

            CreditRequest tmpRequest = null;
            for (BankAtm atm_item: atms) {
                tmpRequest = isAtmSatisfiesRequest(atm_item, request);
                if (tmpRequest != null) {
                    request = tmpRequest;
                    break;
                }
            }

            throw new WrongRequestException("В выбраном офисе " + office.getId() + " отсутствуют банкоматы, " +
                    "соответствующие переданному запросу на кредит", null);

        }
        else {
            atm = ServiceManager.getBankAtmService().get(request.getAtmId());
        }
        if (isAtmSatisfiesRequest(atm, request) == null) {
            throw new WrongRequestException("Выбранный банкомат " + atm.getId() +
                    "не соответствует переданному запросу на кредит", null);
        }

        User user = ServiceManager.getUserService().get(request.getUserId());
        PaymentAccount userPaymentAccount;

        if (!ServiceManager.getBankService().isClient(bank, user)) {
            userPaymentAccount = ServiceManager.getPaymentAccountService().create(user, bank);
        } else {
            Function<PaymentAccount, Boolean> findAccount = paymentAccount -> paymentAccount.getUserId().equals(user.getId());
            userPaymentAccount = ServiceManager.getPaymentAccountService().getByCondition(findAccount).get(0);
        }

        LocalDate creditStart = LocalDate.now();
        CreditAccount creditAccount = ServiceManager.getCreditAccountService().create(
                user,
                bank,
                creditStart,
                creditStart.plusMonths(request.getNumberOfMonths()),
                request.getNumberOfMoney(),
                employee,
                userPaymentAccount
        );

        atm.setNumberOfMoney(atm.getNumberOfMoney() - request.getNumberOfMoney());
        office.setNumberOfMoney(office.getNumberOfMoney() - request.getNumberOfMoney());
        bank.setNumberOfMoney(bank.getNumberOfMoney() - request.getNumberOfMoney());

        return creditAccount;

    }


}
