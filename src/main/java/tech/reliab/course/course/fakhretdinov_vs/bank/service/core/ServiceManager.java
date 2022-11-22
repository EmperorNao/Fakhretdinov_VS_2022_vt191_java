package tech.reliab.course.course.fakhretdinov_vs.bank.service.core;

import tech.reliab.course.course.fakhretdinov_vs.bank.service.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.*;

public class ServiceManager {

    public ServiceManager(BankService bankService,
                          BankAtmService bankAtmService,
                          BankOfficeService bankOfficeService,
                          EmployeeService employeeService,
                          UserService userService,
                          CreditAccountService creditAccountService,
                          PaymentAccountService paymentAccountService) {

        this.bankService = bankService;
        this.bankAtmService = bankAtmService;
        this.bankOfficeService = bankOfficeService;
        this.employeeService = employeeService;
        this.userService = userService;
        this.creditAccountService = creditAccountService;
        this.paymentAccountService = paymentAccountService;

    }

    public static BankService bankService;
    public static BankAtmService bankAtmService;
    public static BankOfficeService bankOfficeService;
    public static EmployeeService employeeService;
    public static UserService userService;
    public static CreditAccountService creditAccountService;
    public static PaymentAccountService paymentAccountService;

}
