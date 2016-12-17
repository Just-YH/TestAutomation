package com.bsu.mmf.step;


import com.bsu.mmf.driver.Driver;
import com.bsu.mmf.page.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class Step {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser() {
        driver = Driver.getDriver();
    }

    public void closeDriver() {
        driver.quit();
    }

    public void search(String searchValue) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.search(searchValue);
    }

    public void addBook(String url) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.addBook(url);
    }

    public boolean searchResult() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        return (mainPage.getResult().trim().contains("Harry Potter"));
    }
    public boolean addResult() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        return (!mainPage.getBookInBag().isEmpty());
    }
}
