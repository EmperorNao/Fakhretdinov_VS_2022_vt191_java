package tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions;


public class CreditRatingException extends Exception {
    public CreditRatingException(int bankRating, int userCreditRating, Throwable err) {
        super("Пользователь имеет слишком низкий кредитный рейтинг " + userCreditRating + " для банка с рейтингом " + bankRating, err);
    }
}

