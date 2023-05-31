# Втора лабораториска вежба по Софтверско инженерство

## Олгица Танова, бр. на индекс 165005

### Control Flow Graph

![ControlFlowGraph](https://github.com/Olgica165005/SI_2023_lab2_165005/assets/128933727/47b784c7-2f94-4567-bf23-82866ddfcdcf)

&ast; Во src/main/java/SILab2.java се означени линиите код со соодветниот број на јазел.

### Цикломатска комплексност

Цикломатската комплексност на овој код е 11.
Истата ја пресметав со формулата V(G) = E - N + 2, каде што E е бројот на ребра, а N е бројот на јазли. Бидејќи во овој случај E=33 и N=24, V(G) = 33 - 24 + 2 = 11.
Цикломатската комплексност исто така може да се пресмета со формулата V(G) = P + 1, каде што P e бројот на предикантни јазли. Бидеќи имаме 10 предикантни јазли, добиваме V(G) = 10 + 1 = 11.

### Тест случаи според критериумот Every branch

**1. Test case 1: missing information**

```
user = null
users = []
```

- Ја покрива патеката 1,2 - 3 - 25

**2. Test case 2: username is null (gets set to email), user with same username and email already exists**

```
user = { username: null, email: "email@mail.com", password: "strongPassword" },
users = [ { username: "email@mail.com", email: "email@mail.com", password: "somePassword^" } ]
```

- Ја покрива патеката 1,2 - 4 - 5 - 6 - 7 - 8 - 9.1 - 9.2 - 10,11 - 12 - 13 - 14 - 9.3 - 9.2 - 15,16,17 - 18 - 20 - 21.1 - 21.2 - 22 - 21.2 - 24 - 25

**3. Test case 3: email is invalid, password is weak**

```
user = { username: "username", email: "mail", password: "weak" }
users = []
```

- Ја покрива патеката 1,2 - 4 - 6 - 7 - 15,16,17 - 18 - 19 - 25

**4. Test case 4: information is valid, user with same username or email doesn't exist**

```
user = { username: "username", email: "email@mail.com", password: "VeryStrongPassword!!!" },
users = [ { username: "differentUsername", email: "differentMail@mail.com", password: "somePassword^" } ]
```

- Ја покрива патеката 1,2 - 4 - 6 - 7 - 8 - 9.1 - 9.2 - 10,11 - 13 - 9.3 - 9.2 - 15,16,17 - 18 - 20 - 21.1 - 21.2 - 22 - 23 - 25

**5. Test case 5: password contains whitespace character (" ")**

```
user = { username: "username", email: "mail", password: "my password" }
users = []
```

- Ја покрива патеката 1,2 - 4 - 6 - 7 - 15,16,17 - 18 - 20 - 24 - 25

### Тест случаи според критериумот Multiple Condition
`if (user==null || user.getPassword()==null || user.getEmail()==null)`

**1. Test case 1: user is null**

```
user = null
```

- Ја опфаќа комбинацијата TXX

**2. Test case 2: password is null**

```
user = { username: "username", email: "email@mail.com", password: null }
```

- Ја опфаќа комбинацијата FTX

**3. Test case 3: email is null**

```
user = { username: "username", email: null, password: "password" }
```

- Ја опфаќа комбинацијата FFT

**4. Test case 4: all needed information is present**

```
user = { username: "username", email: "email@mail.com", password: "password" }
```

- Ја опфаќа комбинацијата FFF

### Објаснување на напишаните unit tests

#### Every branch test cases

За секој утврден тест случај запишан во документацијата, напишав посебен сегмент во функцијата everyBranch во кој што ја повикувам функцијата SILab2.function со соодветните влезни параметри за тој тест случај. Потоа со помош на assert изрази проверувам дали излезот од така повиканата функција соодветствува на очекуваниот излез според утврдената патека.

Според утврдената патека за првиот тест случај, со вака поставените влезни параметри функцијата треба да „фрли“ исклучок. Со assertThrows проверувам дали е „фрлен“ исклучок, и потоа со assertTrue проверувам дали пораката во „фрлениот“ исклучок е еднаква на пораката во изворниот код.

Во вториот, третиот, и петтиот тест случај, патеките ни кажуваат дека резултатот од повикувањето на функцијата со дадените влезни параметри треба да е false, односно функцијата треба да врати резултат false. Со assertFalse го проверувам резултатот од повикувањето на функцијата со таквите параметри.

Четвртиот тест случај е оној со кој што проверуваме дали функцијата враќа true доколку ја повикаме со валидни податоци, односно патеката ни кажува дека функцијата треба да врати true доколку ја повикаме со дадените влезни параметри. Со assertTrue проверувам дали навистина добиваме резултат true доколку ја повикаме функцијата на ваков начин.


#### Multiple condition test cases

За секој утврден тест случај запишан во документацијата, напишав посебен сегмент во функцијата miltipleCondition во кој што ја повикувам функцијата SILab2.function со соодветните влезни параметри за тој тест случај. Потоа со помош на assert изрази проверувам дали дадените влезни параметри резултираат со влез во условот или не. Проверката ја правам со тоа што проверувам дали е „фрлен“ исклучокот во условот, и ако очекуваме да е, ја проверувам пораката во исклучокот. Во првите 3 тест случаи исклучокот треба да е присутен (assertThrows), додека во последниот тест случај функцијата не треба да „фрли“ исклучок (assertDoesNotThrow).
