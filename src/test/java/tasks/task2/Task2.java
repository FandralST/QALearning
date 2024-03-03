package tasks.task2;

import Core.BaseTest;
import org.junit.jupiter.api.Test;
import tasks.task2.pages.MainPageAppleInsider;

public class Task2 extends BaseTest {

    /*
     * Задание2.
     * 1. Из заголовков получить через список однотипных элементов все текстовые описания заголовков
     * 2. Результат вывести в консоль
     *
     * */
    public MainPageAppleInsider mainPageAppleInsider = new MainPageAppleInsider();

    @Test
    void task2() {
        System.out.println(mainPageAppleInsider.primaryMenuHeaders.texts());
    }
}
