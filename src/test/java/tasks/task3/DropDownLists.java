package tasks.task3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class DropDownLists {
    //TODO: Переписать на руты
    public void checkHeader(String elementName) {
        assertThat($x(String.format(".//h1[text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }

    public void performDropDownListClick(String list) {
        SelenideElement dropDownList = $x(String.format(".//div[@class=' css-2b097c-container' and @id='%s']", list));
        dropDownList.click();

    }

    public void checkValue(String elementName) {
        assertThat($x(String.format(".//div[@class=' css-yt9ioa-option' and text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }

    public void clickValue(String elementName) {
        $x(String.format(".//div[@class=' css-yt9ioa-option' and text()='%s']", elementName)).click();
    }

    public void checkSelectedValue(String elementName) {
        assertThat($x(String.format(".//div[@class=' css-1uccc91-singleValue' and text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }

    public void performMultiSelectListClick(String list) {
        SelenideElement dropDownList = $x(String.format(".//div[@class=' css-1wa3eu0-placeholder' and text()='%s']", list));
        dropDownList.click();

    }

    public void checkValueMultiSelect(String elementName) {
        SelenideElement root = $x(".//div[@class=' css-26l3qy-menu']");
        assertThat(root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }

    public void clickValueMultiSelect(String elementName) {
        SelenideElement root = $x(".//div[@class=' css-26l3qy-menu']");
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName)).click();
    }

    public void checkSelectedValueMultiSelect(String elementName) {
        assertThat($x(String.format(".//div[@class='css-12jo7m5' and text()='%s']", elementName)).should(Condition.visible).isDisplayed()).isTrue();
    }

    public void deleteValueMultiSelect(String elementName) {
        $x(String.format(".//div[@class='css-12jo7m5' and text()='%s']/following-sibling::div", elementName)).click();
        assertThat($x(String.format(".//div[@class='css-12jo7m5' and text()='%s']", elementName)).shouldNot(Condition.visible).isDisplayed()).isFalse();
    }
    ///TODO: Переписать, используя List
    public void selectFourValues(String elementName1, String elementName2, String elementName3, String elementName4) {
        SelenideElement root = $x(".//div[@class=' css-26l3qy-menu']");
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName1)).click();
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName2)).click();
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName3)).click();
        root.$x(String.format(".//div[contains(@class,'option') and text()='%s']", elementName4)).click();
    }

    public void checkFourValues() {
        assertThat($x(String.format(".//div[@class=' css-1gl4k7y' and text()='No options']")).should(Condition.visible).isDisplayed()).isTrue();
    }


}
