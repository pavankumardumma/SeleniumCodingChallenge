package org.selenium.coding.challenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WorldPopulation_Day1 {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.worldometers.info/world-population/");

        String xpathCurrentPop = "//div[@class='maincounter-number']//span[@class='rts-counter']";
        String xpathTodayPop = "//div[text()='Today']//parent::div//span[@class='rts-counter']";
        String xpathThisYearPop = "//div[text()='This year']//parent::div//span[@class='rts-counter']";
        String xpathTodayOrThisYearPop = "//div[text()='This year']//parent::div//span[@class='rts-counter']";

        String xpathbirthTodayPop = "(//div[text()='Today']//parent::div//span[@class='rts-counter'])[1]";

        int count = 1;
        while (count <= 2) {
            if (count == 3) break;
            System.out.println(count + " sec");

            System.out.println("--------- Current Population Count -------------");
            printPopulationData(xpathCurrentPop);

            System.out.println("--------- Today Population Count -------------");
            printPopulationData(xpathTodayPop);

            System.out.println("--------- Birth Today Population Count -------------");
            printPopulationData(xpathbirthTodayPop);

            System.out.println("---------This year Population Count -------------");
            printPopulationData(xpathThisYearPop);

            System.out.println("==================================================");
            Thread.sleep(1000);
            count++;
        }

        driver.quit();
    }

    public static void printPopulationData(String xpath) throws InterruptedException {

//        List<WebElement> populationList = driver.findElements(By.xpath(xpath));
//        for (WebElement e : populationList) {
//            System.out.println(e.getText());
//        }

        driver.findElements(By.xpath(xpath)).stream().forEach(e-> System.out.println(e.getText()));

    }
}


