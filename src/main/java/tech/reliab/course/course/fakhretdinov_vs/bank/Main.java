package tech.reliab.course.course.fakhretdinov_vs.bank;


import tech.reliab.course.course.fakhretdinov_vs.bank.service.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;

import java.time.Instant;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ServiceManager manager = new ServiceManager(new BankServiceImpl(),
                new BankAtmServiceImpl(),
                new BankOfficeServiceImpl(),
                new EmployeeServiceImpl(),
                new UserServiceImpl(),
                new CreditAccountServiceImpl(),
                new PaymentAccountServiceImpl());


        BankService bankService = manager.bankService;
        BankAtmService atmService = manager.bankAtmService;
        BankOfficeService bankOfficeService = manager.bankOfficeService;
        EmployeeService employeeService = manager.employeeService;
        UserService userService = manager.userService;
        CreditAccountService creditAccountService = manager.creditAccountService;
        PaymentAccountService paymentAccountService = manager.paymentAccountService;

        var bank = bankService.create("Сбербанк");

        var bankOffice = bankOfficeService.create("Главный офис", bank, "ул. Пушкина, д. Колотушкина", 100L);

        var employee = employeeService.create("А.А.А",
                "Главный директор",
                bank,
                LocalDate.of(1980, 3, 10),
                bankOffice,
                1L);

        var atm = atmService.create("Банкомат #1", bank, bankOffice, employee);

        var user = userService.create("Б.Б.Б", LocalDate.of(2000, 1, 1), "Каменщик");

        var paymentAccount = paymentAccountService.create(user, bank);

        var creditAccount = creditAccountService.create(user, bank,
                LocalDate.of(2021, 5, 20),
                LocalDate.of(2023, 5, 20),
                100000L,
                employee,
                paymentAccount);

        System.out.println("Bank: " + bank);
        System.out.println("BankOffice: " + bankOffice);
        System.out.println("Employee: " + employee);
        System.out.println("BankAtm: " + atm);
        System.out.println("User: " + user);
        System.out.println("CreditAccount: " + creditAccount);
        System.out.println("PaymentAccount: " + paymentAccount);

    }

}
