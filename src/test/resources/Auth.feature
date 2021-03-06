# language: ru
@test @auth
Функционал: Авторизация

  Предыстория:
    Пусть пользователь заходит на сайт "http://www.otus.ru"

  @positive
  Сценарий: Авторизация пользователя позитивный сценарий
    Когда пользователь логинится в личном кабинете
    Тогда на верхней панеле отображается имя пользователя "Ivan"

  @negative
  Сценарий: Авторизация пользователя негативный сценарий
    Когда Вася логинится с некорректным паролем
    Тогда Вася видит на попапе авторизации сообщение "Такая пара логин/пароль не существует"