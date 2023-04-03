package lesson2.bank;

public class LoanIssuer {
    // Кредитный офицер

    private String name;
    private boolean isLazy; // Ленивый
    private boolean isKind; // Добрый

    public LoanIssuer(String name, boolean isLazy, boolean isKind) {
        this.name = name;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }

    public boolean toIssue(LoanTaker taker) {

        // Если работник ленивый, он одобрит кредит, если доход заемщика больше 20_000
        // Еси работник не денивый, но добрый, он одобрит кредит, если доход > 25_000 и возраст < 60
        // Ели работник не ленивый и злой, то он одобрит кредит, если доход > 28_000 и возраст < 50 лет

        if (isLazy) {
            return (taker.getYearlyIncome() > 20_000);
        } else if (isKind) {
            return (taker.getYearlyIncome() > 25_000 && taker.getAge() < 60);
        } else {
            return (taker.getYearlyIncome() > 28_000 && taker.getAge() < 50);
        }
    }
}
