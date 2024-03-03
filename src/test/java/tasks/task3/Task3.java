package tasks.task3;

import Core.BaseTest;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import tasks.task3.pagesAndActions.ChoicePageDemoQA;
import tasks.task3.pagesAndActions.FieldsAndButtonsDemoQA;
import tasks.task3.pagesAndActions.MainPageDemoQA;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3 extends BaseTest {

MainPageDemoQA mainPageDemoQA = new MainPageDemoQA();
ChoicePageDemoQA choicePageDemoQA = new ChoicePageDemoQA();
FieldsAndButtonsDemoQA fieldsAndButtonsDemoQA = new FieldsAndButtonsDemoQA();
Faker faker = new Faker();
String UserName = "scottie.tromp";
String Password = "IK0ut5IXecdy";
    @Test
    void task3() {
        mainPageDemoQA.bookStoreApplicationHeader.scrollIntoView(true);
        assertThat(mainPageDemoQA.bookStoreApplicationHeader.should(Condition.visible).isDisplayed()).isTrue();
        mainPageDemoQA.bookStoreApplicationHeader.click();
        choicePageDemoQA.performMenuClick("Book Store Application");
        choicePageDemoQA.performSubMenuClick("Login");
        assertThat(fieldsAndButtonsDemoQA.inputUserNameField.should(Condition.visible).isDisplayed()).isTrue();
        assertThat(fieldsAndButtonsDemoQA.inputPasswordField.should(Condition.visible).isDisplayed()).isTrue();
        assertThat(fieldsAndButtonsDemoQA.loginButton.should(Condition.visible).isDisplayed()).isTrue();
        assertThat(fieldsAndButtonsDemoQA.loginNewUserButton.should(Condition.visible).isDisplayed()).isTrue();
        /*loginPageDemoQA.loginNewUserButton.click();
        assertThat(loginPageDemoQA.registerFirstNameField.should(Condition.visible).isDisplayed()).isTrue();
        loginPageDemoQA.registerFirstNameField.sendKeys(faker.name().firstName());
        loginPageDemoQA.registerLastNameField.sendKeys(faker.name().lastName());
        loginPageDemoQA.loginUserNameField.sendKeys(faker.name().username());
        UserName = loginPageDemoQA.loginUserNameField.getValue();
        loginPageDemoQA.loginPasswordField.sendKeys(faker.internet().password(8,16,true, true));
        Password = loginPageDemoQA.loginPasswordField.getValue();
        loginPageDemoQA.registerCaptcha.click();
        loginPageDemoQA.registerButton.click();
        loginPageDemoQA.registerButton.sendKeys(Keys.ENTER);
        loginPageDemoQA.backToLoginButton.click();*/

        fieldsAndButtonsDemoQA.loginButton.click();
        fieldsAndButtonsDemoQA.inputUserNameField.sendKeys(UserName);
        fieldsAndButtonsDemoQA.inputPasswordField.sendKeys(Password);
        fieldsAndButtonsDemoQA.loginButton.click();
        System.out.println("");


    }
    /*
    * Задание 3.
    * В проекте:
    * 1. Создать новый файл проперти для сайта https://demoqa.com/ (по аналогии)
    * 2. Заменить в конфиге используемые проперти на новые
    * ----- НАПОМНИ САШЕ СКИНУТЬ FAKER ДЛЯ ГЕНЕРАЦИИ СЛУЧАЙНЫХ СТРОК!!!!
    * В тесте:
    * 3. Зайти на сайт, проверить, что сайт открылся (можно по заголовку или любому элементу), пример проверки через assert isDisplayed в task1
    * 4. Перейти в раздел "BookStoreApplication", проверить, что открылась верная страница (по заголовку или любому элементу)
    * 5. Выбрать меню логин, проверить, что отобразилось окно логина (по 4 элементам - две кнопки и два инпута)
    * 6. Нажать "new user", проверить, что открылось окно регистрации
    * 7. Ввести данные для регистрации, нажать капчу, нажать "Register", проверить, что появилось алерт-окно о регистрации (окно закрыть после проверки)
    * 8. Перейти на вкладку логина, ввести верные данные, нажать "login", проверить, что вход осуществлен успешно (откроется табличка, проверять по любому элементу)
    */
}
