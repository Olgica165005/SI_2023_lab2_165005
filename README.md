# Втора лабораториска вежба по Софтверско инженерство

## Олгица Танова, бр. на индекс 165005

### Control Flow Graph

![ControlFlowGraph](https://github.com/Olgica165005/SI_2023_lab2_165005/assets/128933727/ae9aa3b9-232b-4002-b500-2b9befd14f0a)

### Цикломатска комплексност

Цикломатската комплексност на овој код е 11.
Истата ја пресметав со формулата V(G) = E - N + 2, каде што E е бројот на ребра, а N е бројот на јазли. Бидејќи во овој случај E=31 и N=22, V(G) = 31 - 22 + 2 = 11.
Цикломатската комплексност исто така може да се пресмета со формулата V(G) = P + 1, каде што P e бројот на предикантни јазли. Бидеќи имаме 10 предикантни јазли, добиваме V(G) = 10 + 1 = 11.

### Тест случаи според критериумот Every branch

**1. Test case 1: missing information**

```
user = null
```

- Ги покрива гранките 1, 2, 22

**2. Test case 2: user with same username and email already exists**

```
user = { username: null, email: "email@mail.com", password: "strongPassword" },
users = [ { username: "email@mail.com", email: "email@mail.com", password: "somePassword" } ]
```

- Ги покрива гранките 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21, 22

**3. Test case 3: password is weak**

```
user = { username: "username", email: "mail", password: "weak" }
```

- Ги покрива гранките 1, 3, 5, 6, 14, 15, 16, 22

**4. Test case 4: information is valid**

```
user = { username: "username", email: "email@mail.com", password: "VeryStrongPassword!!!" }
```

- Ги покрива гранките 1, 3, 5, 6, 7, 8, 14, 15, 17, 18, 19, 20, 22
