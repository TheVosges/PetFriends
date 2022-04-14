# PetFriends

## Opis bazy danych

Kod: 

```sql=
create database pet_friends;
use pet_friends;

create table Places
(
    id      int auto_increment primary key,
    name    char(100),
    address char(100),
    descrip char(255)
);

CREATE USER 'Klient'@'localhost' IDENTIFIED BY 'Klient2021$';
GRANT SELECT ON Places TO 'Klient'@'localhost';

CREATE USER 'Admin'@'localhost' IDENTIFIED BY 'Admin2021$';
GRANT SELECT ON Places TO 'Admin'@'localhost';
GRANT UPDATE ON Places TO 'Admin'@'localhost';
GRANT DELETE ON Places TO 'Admin'@'localhost';
GRANT insert ON Places TO 'Admin'@'localhost';
```

Powyższa baza składa się z jednej tabeli Places, która zawiera columnty takie jak:
* id - klucz główny 
* name - nazwa miejsca
* address - adres miejsca
* descrip - opis 

Poza tabelą utworzono również dwóch użytkowników tej bazy:
* Admina - identyfikowanego przez login "Admin" i hasło "Admin2021$", posiada od dostep do wprowadzania nowych dancyh, modyfikowania ich, usuwania i wyboru danych.
* Klienta - identyfikowanego przez login "klient" i hasło "Klient2021$". Kient posiada tylko dostęp do wyboru danych. 

## Przykład działania strony

Strona główna - możliwość obejrzenia obecnych w bazie miejsc, dodania formularza nowego miejsca (funkcja tymczasowo pokazowa), oraz zalogowania się jako admin. Strona pozwala stale na przełączanie się pomiędzy innymi poprzez stały nagłówek strony - "head": 
![](https://i.imgur.com/q7CIahI.jpg)

Strona pozwalająca na wyświetlenie danych z bazy: 
![](https://i.imgur.com/aWrQR9T.jpg)

Formularz zgłoszeniowy:
![](https://i.imgur.com/AhGXGHe.jpg)

Logowanie się jako admin:
![](https://i.imgur.com/YsaCBtN.jpg)

Panel admina:
![](https://i.imgur.com/9JBmxZV.jpg)

Dodawanie nowego miejsca: 
![](https://i.imgur.com/dNGbMqG.jpg)

Update istniejącego miejsca:
![](https://i.imgur.com/SUx4CyO.jpg)

Usuwanie istniejącego miejsca:
![](https://i.imgur.com/5Nf4ypt.png)

