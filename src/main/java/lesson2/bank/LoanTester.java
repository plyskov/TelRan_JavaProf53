package lesson2.bank;

public class LoanTester {

    public static void main(String[] args) {

        LoanTaker misha = new LoanTaker("Misha", 21_000, 70);
        LoanIssuer dina = new LoanIssuer("Dina", true, false);

        System.out.println(dina.toIssue(misha));

        LoanIssuer foma = new LoanIssuer("Foma", false, false);
        LoanTaker alex = new LoanTaker("Alex", 26_000, 30);

        System.out.println(foma.toIssue(alex));

    }

}
