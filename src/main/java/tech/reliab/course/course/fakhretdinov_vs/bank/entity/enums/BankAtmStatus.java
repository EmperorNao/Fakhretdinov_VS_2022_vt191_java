package tech.reliab.course.course.fakhretdinov_vs.bank.entity.enums;

public enum BankAtmStatus {
    Working, NotWorking, NoMoney;

    public static BankAtmStatus getRandomStatus(Integer idx) {
        return values()[idx % (values().length)];
    }

}



