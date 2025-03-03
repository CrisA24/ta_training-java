package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PastebinPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

    public class PastebinTest {
        private WebDriver driver;
        private PastebinPage pastebinPage;

        @BeforeEach
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://pastebin.com/");
            pastebinPage = new PastebinPage(driver);
        }

        @Test
        public void testCreateNewPaste() {
            pastebinPage.enterCode("Hello from WebDriver");
            pastebinPage.selectExpiration("10 Minutes");
            pastebinPage.enterPasteName("helloweb");
            pastebinPage.submitPaste();

            // Verifică dacă paste-ul a fost creat (verificare simplă prin titlu)
            Assertions.assertTrue(driver.getTitle().contains("helloweb"));
        }


        @AfterEach
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

