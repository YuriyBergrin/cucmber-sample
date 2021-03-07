# language: ru
@test @account
Функционал: Личный кабинет

  @positive
  Структура сценария:
    Пусть пользователь заходит на сайт "http://www.otus.ru"
    Когда пользователь логинится в личном кабинете
    И затем пользователь переходит в личный кабинет
    И затем переходит на вкладку "<вкладка>"
    Тогда текущий url будет "<url>"

    Примеры:
      | вкладка            | url                                    |
      | О себе             | https://otus.ru/lk/biography/personal/ |
      | Мои курсы          | https://otus.ru/learning/              |
      | Оплата             | https://otus.ru/lk/payment/            |
      | Приведи друга      | https://otus.ru/lk/invite/             |
      | Работа в компаниях | https://otus.ru/lk/employment/         |
      | Настройки          | https://otus.ru/lk/settings/auth/      |
      | Документы          | https://otus.ru/lk/documents/          |

