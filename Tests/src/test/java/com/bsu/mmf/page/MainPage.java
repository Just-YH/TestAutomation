package com.bsu.mmf.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends Page {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "http://oz.by/";

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-s\"]")
    private WebElement searchInput;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/form/div/span[2]/button")
    private WebElement buttonSubmit;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/ul/li/h1/span")
    private WebElement searchResult;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div[1]/div/div[2]/div[3]/div/div/div[2]/div/div/form/button")
    private WebElement buttonAdd;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/ul/li[3]/a/span")
    private WebElement bookInBag;


    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }


    public void search(String searchValue) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"top-s\"]")));
        searchInput.sendKeys(searchValue);
        buttonSubmit.click();

        logger.info("Login performed");
    }

    public void addBook(String url) throws InterruptedException {
        driver.navigate().to(url);

        Thread.sleep(2000);

        buttonAdd.click();

        logger.info("add performed");
    }


    public String getResult() throws InterruptedException {
        Thread.sleep(2000);
        return searchInput.getText();
    }

    public String getBookInBag() throws InterruptedException {
        Thread.sleep(2000);
        return bookInBag.getText();
    }
}
