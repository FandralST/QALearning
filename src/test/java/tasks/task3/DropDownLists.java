package tasks.task3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class DropDownLists {
    public void checkHeader(String elementName) {
        assertThat($x(String.format(".//h1[text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }

    public void performDropDownListClick(String rootName, String list) {
        SelenideElement root = $x(String.format(".//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        root.$x(String.format(".//div[@id='%s']", list)).click();
    }

    public void checkValue(String rootName, String elementName) {
        SelenideElement root = $x(String.format(".//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        assertThat(root.$x(String.format(".//div[text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }

    public void clickValue(String rootName, String elementName) {
        SelenideElement root = $x(String.format(".//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        root.$x(String.format(".//div[text()='%s']", elementName)).click();
    }

    public void checkSelectedValue(String rootName, String elementName) {
        SelenideElement root = $x(String.format(".//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        assertThat($x(String.format(".//div[contains(@class, 'singleValue') and text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }



    public void performMultiSelectListClick(String rootName, String list) {
        SelenideElement root = $x(String.format(".//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        SelenideElement dropDownList = $x(String.format(".//div[text()='%s']", list));
        dropDownList.click();

    }

    public void checkValueMultiSelect(String rootName, String elementName) {
        SelenideElement root = $x(String.format(".//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        assertThat(root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }

    public void clickValueMultiSelect(String rootName, String elementName) {
        SelenideElement root = $x(String.format(".//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName)).click();
    }

    public void checkSelectedValueMultiSelect(String rootName, String elementName) {
        SelenideElement root = $x(String.format(".//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        assertThat(root.$x(String.format(".//div[@class='css-12jo7m5' and text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }

    public void deleteValueMultiSelect(String rootName, String elementName) {
        SelenideElement root = $x(String.format(" .//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        root.$x(String.format(".//div[@class='css-12jo7m5' and text()='%s']/following-sibling::div", elementName)).click();
        assertThat(root.$x(String.format(".//div[@class='css-12jo7m5' and text()='%s']", elementName)).shouldNot(Condition.visible).isDisplayed()).isFalse();
    }
    ///TODO: Переписать, используя List
    public void selectFourValues(String rootName, String elementName1, String elementName2, String elementName3, String elementName4) {
        SelenideElement root = $x(String.format(" .//div[contains(@class,'placeholder') and text()='%s']//ancestor::div[4]", rootName));
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName1)).click();
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName2)).click();
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName3)).click();
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName4)).click();
    }

    public void checkFourValues() {
        assertThat($x(String.format(".//div[@class=' css-1gl4k7y' and text()='No options']")).should(Condition.visible).isDisplayed()).isTrue();
    }


}
