package tasks.task3;

import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class Calendar {
    private final String rootSelectDate = ".//div[@id='datePickerMonthYear']/preceding-sibling::div[text()='%s']/ancestor::div[1]";
    private final String rootDateAndTime = ".//div[@id='dateAndTimePicker']/preceding-sibling::div[text()='%s']/ancestor::div[1]";

    public SelenideElement getSelectDateField(String elementName) {
        SelenideElement rootSelectDate = $x(String.format(this.rootSelectDate, elementName));
        return rootSelectDate.$x(".//input[@id='datePickerMonthYearInput']");
    }

    public void selectDate(String elementName, LocalDate date) {

        SelenideElement rootSelectDate = $x(String.format(this.rootSelectDate, elementName));
        SelenideElement year = rootSelectDate.$x(String.format(".//option[text()='%s']", date.getYear()));

        String monthFormatted = date.getMonth().toString().charAt(0) + date.getMonth().toString().substring(1).toLowerCase();
        SelenideElement month = rootSelectDate.$x(String.format(".//option[text()='%s']", monthFormatted));

        SelenideElement day = rootSelectDate.$x(String.format(".//div[text()='%s']", date.getDayOfMonth()));

        SelenideElement selectYearSelectDate = rootSelectDate.$x(".//select[@class='react-datepicker__year-select']");
        SelenideElement selectMonthSelectDate = rootSelectDate.$x(".//select[@class='react-datepicker__month-select']");

        rootSelectDate.$x(".//input[@id='datePickerMonthYearInput']").click();
        selectYearSelectDate.click();
        selectYearSelectDate.scrollIntoView(String.valueOf(date.getYear()));
        year.click();
        selectMonthSelectDate.click();
        month.click();
        day.click();
    }

    public void checkSelectDate(String elementName, LocalDate date) {
        SelenideElement rootSelectDate = $x(String.format(this.rootSelectDate, elementName));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String inputDate = rootSelectDate.$x(".//input[@id='datePickerMonthYearInput']").getValue();
        String dateMinusNDaysFormatted = dtf.format(date);
        assertThat(inputDate).isEqualTo(dateMinusNDaysFormatted);
    }

    public SelenideElement getDateAndTimeField(String elementName) {
        SelenideElement rootSelectDate = $x(String.format(this.rootSelectDate, elementName));
        return rootSelectDate.$x(".//input[@id='datePickerMonthYearInput']");
    }


    public void dateAndTime(String elementName, LocalDateTime date) {

        SelenideElement rootDateAndTime = $x(String.format(this.rootDateAndTime, elementName));
        SelenideElement yearListButton = rootDateAndTime.$x(".//span[@class='react-datepicker__year-read-view--down-arrow']");
        SelenideElement yearScrollDownButton = rootDateAndTime.$x(".//a[@class='react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-previous']");
        SelenideElement year = rootDateAndTime.$x(String.format(".//div[text()='%s']", date.getYear()));

        SelenideElement monthListButton = rootDateAndTime.$x(".//span[@class='react-datepicker__month-read-view--down-arrow']");
        String monthFormatted = date.getMonth().toString().charAt(0) + date.getMonth().toString().substring(1).toLowerCase();
        SelenideElement month = rootDateAndTime.$x(String.format(".//div[text()='%s']", monthFormatted));

        SelenideElement day = rootDateAndTime.$x(String.format(".//div[text()='%s']", date.getDayOfMonth()));
        SelenideElement time = rootDateAndTime.$x(".//li[text()='11:30']");

        rootDateAndTime.$x(".//input[@id='dateAndTimePickerInput']").click();
        yearListButton.click();
        for (int i = 0; i < LocalDate.now().getYear() - date.getYear(); i++) {
            yearScrollDownButton.click();
        }
        year.click();
        monthListButton.click();
        month.click();
        day.click();
        time.scrollIntoView(false).click();
    }

    public void checkDateAndTime(String elementName, LocalDateTime localDateTime) {
        SelenideElement rootDateAndTime = $x(String.format(this.rootDateAndTime, elementName));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy 11:30").withLocale(Locale.ENGLISH);

        String inputDate = rootDateAndTime.$x(".//input[@id='dateAndTimePickerInput']").getValue();
        String dateMinusNMonthsFormatted = String.format(dtf.format(localDateTime));
        assertThat(inputDate.substring(0, inputDate.length() - 3)).isEqualTo(dateMinusNMonthsFormatted);
    }

    public void checkDateAndTime2(String elementName, LocalDateTime localDateTime) {
        SelenideElement rootDateAndTime = $x(String.format(this.rootDateAndTime, elementName));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy 11:30 a").withLocale(Locale.ENGLISH);

        String inputDate = rootDateAndTime.$x(".//input[@id='dateAndTimePickerInput']").getValue();
        String dateMinusNMonthsFormatted = String.format(dtf.format(localDateTime));
        assertThat(inputDate).isEqualTo(dateMinusNMonthsFormatted);
    }

}
