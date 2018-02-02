package com.khospodarysko;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Scroll to button 50 and click on it.
 * Just click on button 50.
 * Also scroll moved entire DOM, but location of element is not changed as "viewport" is moved, i.e our look on page,
 * but no elements in the page, that is why element's location is not changed.
 */
public class DragBelowTest extends BaseTest {
    @Test
    public void testBrokenScroll() {
        driver.get("file://" + absoluteFilePath("drag-below"));

        Assertions.assertThat(driver.findElement(By.id("clicked")).getText())
            .isEqualTo("Button 50");
    }

    @Test
    public void testFixedScroll_JS() {
        driver.get("file://" + absoluteFilePath("drag-below"));

        Assertions.assertThat(driver.findElement(By.id("clicked")).getText())
            .isEqualTo("Button 200");
    }

    @Test
    public void testFixedScroll_Actions() {

    }

    @Test
    public void testFixedScroll_SlowMotions() {

    }

    @Test
    public void testMultipleScrolls() {
        driver.get("file://" + absoluteFilePath("drag-below"));

        // scroll to 50
        // click
        // assert

        // scroll to 10
        // click
        // assert
    }

    @Test
    public void test() {
        driver.get("file://" + absoluteFilePath("drag-below"));

        WebElement element = driver.findElement(By.xpath("//*[text()='Button 50']"));

        Actions move = new Actions(driver);
        move.moveToElement(element).perform();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scroll(0, 250);", element);


        System.out.println(1);
    }
}