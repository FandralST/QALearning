package tasks.task3.pagesAndActions;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FieldsAndButtonsDemoQA {
    public SelenideElement registerCaptcha = $x(".//iframe[@title='reCAPTCHA']");
    public SelenideElement loginButton = $x(".//button[@id='login']");
    public SelenideElement backToLoginButton = $x(".//button[@id='gotologin']");
    public SelenideElement registerButton = $x(".//button[@id='register']");
    //переместить в класс с таблицей
    public SelenideElement loginNewUserButton = $x(".//button[@id='newUser']");


    public SelenideElement inputUserNameField = $x(".//input[@placeholder='UserName']");
    public SelenideElement inputPasswordField = $x(".//input[@placeholder='Password']");
    public SelenideElement inputAgeField = $x(".//input[@placeholder='Age']");
    public SelenideElement inputSalaryField = $x(".//input[@placeholder='Salary']");
    public SelenideElement inputDepartmentField = $x(".//input[@placeholder='Department']");
    public SelenideElement inputMailField = $x(".//input[@placeholder='name@example.com']");
    public SelenideElement inputFirstNameField = $x(".//input[@placeholder='First Name']");
    public SelenideElement inputLastNameField = $x(".//input[@placeholder='Last Name']");

    public void clickByPlaceholder(String placeholder) {
        //в степс перенести и дописать
    }

}
