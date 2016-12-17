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
}
