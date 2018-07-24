package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://mmatyjasek.github.io/";
    private static final int SLEEP = 2000;
    private static final String XPATH_DATATABLE_ROW = "//form[@class=\"datatable__row\"]";
    private static final String XPATH_DATATABLE_FIELD = ".//p[@class=\"datatable__field-value\"]";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createNewTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        final int BOUND = 100000;

        String taskName = "Task number " + generator.nextInt(BOUND);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(SLEEP);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        final String XPATH_SELECT = "//select[1]";
        final String XPATH_CARD_CREATION = ".//button[contains(@class, \"card-creation\")]";
        driver.navigate().refresh();
        while(!driver.findElement(By.xpath(XPATH_SELECT)).isDisplayed());

        driver.findElements(By.xpath(XPATH_DATATABLE_ROW)).stream().
                filter(anyForm ->
                        anyForm.findElement(By.xpath(XPATH_DATATABLE_FIELD)).getText().equals(taskName)).
                forEach(theForm -> {
                        WebElement selectBoardElement = theForm.findElement(By.xpath("." + XPATH_SELECT));
                        Select selectBoard = new Select(selectBoardElement);
                        selectBoard.selectByIndex(1);

                        WebElement buttonCreateCard = theForm.findElement(By.xpath(XPATH_CARD_CREATION));
                        buttonCreateCard.click();
                        });
        Thread.sleep(SLEEP);
    }

    private boolean checkTasksExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        final String ID_USER = "user";
        final String USER = "marcinmatyjasek";
        final String ID_PASSWORD = "password";
        final String PASSWORD = "password1234";
        final String ID_LOGIN = "login";
        final String XPATH_BOARDS = "//a[contains(@href, \"/boards\")]/span/span";
        final String XPATH_BOARD_TILE = "//a[contains(@class, \"board-tile\")]";
        final String BOARD_NAME = "Kodilla";
        final int ZERO = 0;
        final String XPATH_CARDS = "//span[contains(@class, \"js-card-name\")]";
        boolean result;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id(ID_USER)).sendKeys(USER);
        driverTrello.findElement(By.id(ID_PASSWORD)).sendKeys(PASSWORD);
        driverTrello.findElement(By.id(ID_LOGIN)).submit();

        Thread.sleep(SLEEP);

        driverTrello.findElement(By.xpath(XPATH_BOARDS)).click();

        Thread.sleep(SLEEP);

        driverTrello.findElements(By.xpath(XPATH_BOARD_TILE)).stream()
                .filter(sp -> sp.getText().contains(BOARD_NAME)).findFirst().orElseThrow(() ->
                        new NotFoundException("Error: Cannot find board: " + BOARD_NAME))
                .click();

        Thread.sleep(SLEEP);

        result = driverTrello.findElements(By.xpath(XPATH_CARDS)).stream()
                .filter(t -> t.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > ZERO;

        driverTrello.close();

        return result;
    }

    private void cleanUp(String taskName) throws InterruptedException {
        final String XPATH_BUTTON_DELETE = ".//button";
        final String BUTTON_NAME = "Delete";

        try {
            Alert alt = driver.switchTo().alert();
            alt.accept();
        } catch(NoAlertPresentException noe) {
            noe.printStackTrace();
        }

        driver.findElements(By.xpath(XPATH_DATATABLE_ROW)).stream().
                filter(anyForm ->
                        anyForm.findElement(By.xpath(XPATH_DATATABLE_FIELD)).getText().equals(taskName)).
                forEach(theForm -> {
                    theForm.findElements(By.xpath(XPATH_BUTTON_DELETE)).stream()
                            .filter(b -> b.getText().contains(BUTTON_NAME)).findFirst().orElseThrow(() ->
                                    new NotFoundException("ERROR: Cannot find button: " + BUTTON_NAME))
                            .click();
                });
        Thread.sleep(SLEEP);
    }


    @Test
    public void shouldCreateTrelloTask() throws InterruptedException {
        String taskName = createNewTestTask();
        sendTestTaskToTrello(taskName);
        cleanUp(taskName);
        assertTrue(checkTasksExistsInTrello(taskName));

    }
}

