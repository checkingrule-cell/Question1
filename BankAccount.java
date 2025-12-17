import java.time.LocalDateTime;
public class BankAccount {
private String ownerName;
private int balance;
private LocalDateTime openingDate;
private boolean isLocked;
// Конструктор, принимающий только имя владельца
public BankAccount(String ownerName) {
this.ownerName = ownerName;
this.balance = 0; // начальный баланс 0
this.openingDate = LocalDateTime.now(); // текущая дата и время
this.isLocked = false; // по умолчанию счёт не заблокирован
}
// Метод пополнения счёта
public boolean deposit(int amount) {
if (amount <= 0) {
return false; // Сумма пополнения должна быть положительной
}
if (isLocked) {
return false; // Если счёт заблокирован, операция невозможна
}
this.balance += amount;
return true;
}
// Метод снятия денег
public boolean withdraw(int amount) {
if (amount <= 0) {
return false; // Сумма снятия должна быть положительной
}
if (isLocked) {
return false; // Если счёт заблокирован, операция невозможна
}
if (amount > this.balance) {
return false; // Нельзя снять больше, чем есть на счёте
}
this.balance -= amount;
return true;
}
// Метод перевода денег на другой счёт
public boolean transfer(BankAccount otherAccount, int amount) {
if (otherAccount == null) {
return false; // Другой счёт не должен быть null
}
if (amount <= 0) {
return false; // Сумма перевода должна быть положительной
}
if (isLocked || otherAccount.isLocked) {
return false; // Если любой из счетов заблокирован, операция невозможна
}
if (amount > this.balance) {
return false; // Нельзя перевести больше, чем есть на текущем счёте
}
// Сначала снимаем с текущего счёта
this.balance -= amount;
// Затем зачисляем на другой счёт
otherAccount.balance += amount;
return true;
}
// Геттеры для полей (опционально, для тестирования и отладки)
public String getOwnerName() {
return ownerName;
}
public int getBalance() {
return balance;
}
public LocalDateTime getOpeningDate() {
return openingDate;
}
public boolean isLocked() {
return isLocked;
}
// Сеттер для поля isLocked (опционально)
public void setLocked(boolean locked) {
this.isLocked = locked;
}
}
