package com.bsu.mmf;

import com.bsu.mmf.step.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class OzByTest {
    private Step step;

    private final String SEARCH_STRING = "Рфккн Зщееук";
    private final String ADD_URL = "http://oz.by/books/more10444797.html";
    @BeforeMethod(description = "Init browser")
    public void setUp() {
        step = new Step();
        step.initBrowser();
    }

    @Test(description = "Oz By Search")
    public void searchOz() throws InterruptedException {
        step.search(SEARCH_STRING);
        Assert.assertTrue(step.searchResult());
    }
    @Test(description = "Add book")
    public void addBook() throws InterruptedException {
        step.addBook(ADD_URL);
        Assert.assertTrue(step.addResult());
    }
    @Test(description = "Del book")
    public void delBook() throws InterruptedException {
        step.delBook(ADD_URL);
        Assert.assertFalse(step.addResult());
    }
    @Test(description = "Search in a certain shop")
    public void searchShop() throws InterruptedException {
        step.searchShop();
        Assert.assertTrue(step.searchResultShop());
    }
    @Test(description = "Partners in pdf")
    public void searchPartners() throws InterruptedException {
        step.searchPartners();
        Assert.assertTrue(step.searchResultPartner());
    }
}
