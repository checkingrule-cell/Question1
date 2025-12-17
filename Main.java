public class Main {
    public static void main(String[] args) {
        // Создаём два счёта
        BankAccount account1 = new BankAccount("Иван Иванов");
        BankAccount account2 = new BankAccount("Пётр Петров");

        // Проверяем начальный баланс
        System.out.println("Начальный баланс account1: " + account1.getBalance()); // 0
        System.out.println("Начальный баланс account2: " + account2.getBalance()); // 0

        // Пополняем счёт account1
        boolean depositResult = account1.deposit(1000);
        System.out.println("Пополнение account1 на 1000: " + depositResult); // true
        System.out.println("Баланс account1 после пополнения: " + account1.getBalance()); // 1000

        // Пытаемся снять больше, чем есть на счёте
        boolean withdrawResult = account1.withdraw(1500);
        System.out.println("Снятие 1500 с account1: " + withdrawResult); // false
        System.out.println("Баланс account1 после попытки снятия: " + account1.getBalance()); // 1000

        // Снимаем допустимую сумму
        withdrawResult = account1.withdraw(500);
        System.out.println("Снятие 500 с account1: " + withdrawResult); // true
        System.out.println("Баланс account1 после снятия: " + account1.getBalance()); // 500

        // Переводим деньги на другой счёт
        boolean transferResult = account1.transfer(account2, 300);
        System.out.println("Перевод 300 с account1 на account2: " + transferResult); // true
        System.out.println("Баланс account1 после перевода: " + account1.getBalance()); // 200
        System.out.println("Баланс account2 после перевода: " + account2.getBalance()); // 300

        // Пытаемся перевести больше, чем есть на счёте
        transferResult = account1.transfer(account2, 500);
        System.out.println("Перевод 500 с account1 на account2: " + transferResult); // false
        System.out.println("Баланс account1 после неудачного перевода: " + account1.getBalance()); // 200

        // Блокируем счёт и пытаемся совершить операцию
        account1.setLocked(true);
        depositResult = account1.deposit(100);
        System.out.println("Пополнение заблокированного account1 на 100: " + depositResult); // false
    }
}
