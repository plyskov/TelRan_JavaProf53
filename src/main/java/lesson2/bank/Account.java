package lesson2.bank;

public class Account {

    private String id;
    private String owner;
    private int balance; // Деньги храним в целых, для точности вычислений (с кратностью копеек). Double не подходит, он не точный.

    // ДЗ
    // Добавить конструктор, геттеры (сеттеры для банк счетов НЕ НУЖНЫ)
    // Дописать методы

    public Account(String id, String owner, int balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    // добавление денег на счет и возвращение полученного баланса
    public int debit(int money) {
        if (money < 0) {
            System.out.println("Non-positive debit amount");
        } else {
            balance += money;
        }
        return balance;
    }

    // удаление денег со счета и возвращение полученного баланса
    // нельзя удалить больше имеющегося остатка
    // еслит пытаемся удалить больше, не нужно менять баланс, но нужно напечатать об этом сообщение
    public int credit(int money) {
        if (money > balance) {
            System.out.println("Credit amount more than balanse!");
            return 0;
        }
        balance -= money;
        return balance;
    }

    // Перевод со счета на счет
    // кредитуем свой счет и дебитуем account
    // возвращаем баланс счета
    // при попытке списать больше чем есть на счете - печатать сообщение
    public int transfer(Account account, int amount) {

    }

}
