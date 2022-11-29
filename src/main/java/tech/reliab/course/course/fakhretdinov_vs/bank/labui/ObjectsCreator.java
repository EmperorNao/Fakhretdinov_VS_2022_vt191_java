package tech.reliab.course.course.fakhretdinov_vs.bank.labui;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Math.min;

public class ObjectsCreator {

    /**
     * Создание заданного количества связанных друг с другом объектов
     * @param numberOfBanks - количестов банков, которое необходимо создать
     * @param numberOfOffices - количество офисов для каждого банка, которое необходимо создать
     * @param numberOfAtms - количество банкоматов для каждого офиса, которое необходимо создать
     * @param numberOfEmployees - количестов сотрудников для каждого офиса, которое необходимо создать
     * @param numberOfUsers - количество клиентов для каждого банка, которое необходимо создать
     * @param numberOfCreditAccounts - количество кредитных счетов для каждого клиента, которое необходимо создать
     * @param numberOfPaymentAccounts - количество платёжных счетов для каждого клиента, которое необходимо создать
     */
    public static void createObjects(
            int numberOfBanks,
            int numberOfOffices,
            int numberOfAtms,
            int numberOfEmployees,
            int numberOfUsers,
            int numberOfCreditAccounts,
            int numberOfPaymentAccounts
    ) {

        BankService bankService = ServiceManager.getBankService();
        BankAtmService atmService = ServiceManager.getBankAtmService();
        BankOfficeService bankOfficeService = ServiceManager.getBankOfficeService();
        EmployeeService employeeService = ServiceManager.getEmployeeService();
        UserService userService = ServiceManager.getUserService();
        CreditAccountService creditAccountService = ServiceManager.getCreditAccountService();
        PaymentAccountService paymentAccountService = ServiceManager.getPaymentAccountService();

        //
        for (int bankIndex = 0; bankIndex < numberOfBanks; ++bankIndex) {


            Bank bank = bankService.create("Банк #" + bankIndex);

            ArrayList<Employee> employees = new ArrayList<>();
            for (int officeIndex = 0; officeIndex < numberOfOffices; ++officeIndex) {


                BankOffice office = bankOfficeService.create(
                        "Офис #" + officeIndex,
                        bank,
                        "Улица #" + officeIndex + ", дом #" + bankIndex,
                        10000L - 1000L * min(officeIndex, 9));
                office.setAtmCanBePlaced(true);
                bankOfficeService.update(office);

                for (int employeeIndex = 0; employeeIndex < numberOfEmployees; ++employeeIndex) {

                    Employee employee = employeeService.create(
                            "Сотрудник Сотрудникович #" + (employeeIndex + numberOfEmployees * officeIndex),
                            "Ответственный за компоненту #" + (employeeIndex + numberOfEmployees * officeIndex),
                            bank,
                            LocalDate.of(1990 + min(employeeIndex, 10), 1, 20),
                            office,
                            1000L - 100L * min(officeIndex, 9)
                    );
                    employees.add(employee);

                }


                for (int atmIndex = 0; atmIndex < numberOfAtms; ++atmIndex) {

                    atmService.create(
                            "Банкомат #" + (atmIndex + numberOfAtms * officeIndex),
                            bank,
                            office,
                            employees.get(min(atmIndex, numberOfEmployees - 1))
                    );

                }


            } // end office for


            for (int userIndex = 0; userIndex < numberOfUsers; ++userIndex) {

                User user = userService.create(
                        "Клиент #" + userIndex,
                        LocalDate.of(1985 + min(userIndex, 10), 3, 22),
                        "Государственная компания #" + userIndex
                );

                ArrayList<PaymentAccount> paymentAccounts = new ArrayList<>();
                for (int paymentAccountIndex = 0; paymentAccountIndex < numberOfPaymentAccounts; ++paymentAccountIndex) {

                    PaymentAccount paymentAccount = paymentAccountService.create(
                            user,
                            bank
                    );
                    paymentAccounts.add(paymentAccount);

                }

                for (int creditAccountIndex = 0; creditAccountIndex < numberOfCreditAccounts; ++creditAccountIndex) {

                    creditAccountService.create(
                            user,
                            bank,
                            LocalDate.of(2022, 1 + min(creditAccountIndex, 10), 22),
                            LocalDate.of(2024, 1 + min(creditAccountIndex, 10), 22),
                            1000 + 100 * min(10, creditAccountIndex),
                            employees.get((322 + creditAccountIndex + userIndex) % numberOfEmployees),
                            paymentAccounts.get((1337 + creditAccountIndex + userIndex) % numberOfPaymentAccounts)
                    );

                }

            } // end user for


        } // end bank for

    }

}
