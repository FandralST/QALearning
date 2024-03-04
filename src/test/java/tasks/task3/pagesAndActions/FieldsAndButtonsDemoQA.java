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

    public void clickByPlaceholder(String placeholder, String keys) {

        $x(String.format(".//input[@placeholder='%s']",placeholder)).sendKeys(keys);
    }

    public void inputValueByElementName(String placeholder, String value){
        $x(String.format(".//input[@placeholder='%s']",placeholder)).clear();
        $x(String.format(".//input[@placeholder='%s']",placeholder)).sendKeys(value);

    }

}
