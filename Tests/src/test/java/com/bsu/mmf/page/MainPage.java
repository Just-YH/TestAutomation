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

    @FindBy(xpath = "//*[@id=\"goods-block\"]/table/tbody/tr[2]/td[1]/div/div[1]/label/span/span/input[1]")
    private WebElement addBasket;

    @FindBy(xpath = "//*[@id=\"goods-block\"]/table/tbody/tr[3]/td/div/div[2]/div/div/div[2]/button")
    private WebElement buttonDel;

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[1]/div[2]/div/ul/li[4]/a/span")
    private WebElement Basket;

    @FindBy(xpath = "//*[@id=\"goods-block\"]/table/tbody/tr[3]/td/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[1]/button")
    private WebElement buttonDelFromBasket;

    @FindBy(xpath = "//*[@id=\"fform\"]/div[11]/div[1]/div/span[2]")
    private WebElement FiltetTitle;

    @FindBy(xpath = "//*[@id=\"ul_id_store\"]/li[9]/label/i")
    private WebElement FiltetCheck;

    @FindBy(xpath = "//*[@id=\"f-results\"]")
    private WebElement buttonFilter;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div[2]/div/div[1]/ul/li[2]/ul/li[4]/span")
    private WebElement ResultFilter;

    @FindBy(xpath = "//*[@id=\"title\"]")
    private WebElement ResultPartner;

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[3]/div[4]/div/div/dl[3]/dd[3]/a")
    private WebElement partner;

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[3]/div/div[1]/div/div[2]/div[2]/div/a")
    private WebElement downloadPartner;



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

    public void delBook(String url) throws InterruptedException {


        driver.navigate().to("http://oz.by/checkout/#");

        Thread.sleep(2000);

        addBasket.click();

        Thread.sleep(2000);

        buttonDel.click();

        Thread.sleep(2000);

        buttonDelFromBasket.click();

        logger.info("del performed");
    }


    public String getResult() throws InterruptedException {
        Thread.sleep(2000);
        return searchInput.getText();
    }

    public String getBookInBag() throws InterruptedException {
        Thread.sleep(2000);
        return bookInBag.getText();
    }

    public String getResultShop() throws InterruptedException {
        Thread.sleep(2000);
        return ResultFilter.getText();
    }

    public String getResultPartner() throws InterruptedException {
        Thread.sleep(2000);
        return driver.getTitle();
    }

    public void searchShop() throws InterruptedException {
        driver.navigate().to("http://oz.by/books/bestsellers");

        Thread.sleep(2000);

        FiltetTitle.click();

        Thread.sleep(2000);

        FiltetCheck.click();

        Thread.sleep(2000);

        buttonFilter.click();


    }

    public void searchPartners() throws InterruptedException {
        driver.navigate().to("http://oz.by");

        Thread.sleep(2000);

        partner.click();

        Thread.sleep(2000);

        downloadPartner.click();

        Thread.sleep(2000);
    }

}
