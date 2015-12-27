package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 27.12.2015.
 */
public class BlockUserPAge extends AbstractPage{

    private final String BASE_URL = "https://ask.fm/login";
    private final Logger logger = Logger.getLogger(AskQuestionPage.class);
    private final String USERNAME2 = "TestingProject2";
    private final String PASSWORD2 = "testing123";


    public BlockUserPAge(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    @FindBy(xpath = "//a[@href='/account/friends']")
    private WebElement buttonFriends;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement inputFriendName;

    @FindBy(xpath = "//a[@class='askfm-avatar45']")
    private WebElement buttonFriend;

    @FindBy(xpath = "//a[@data-tooltip='Заблокировать']")
    private WebElement buttonBlock;

    @FindBy(xpath = "//a[@class='defaultListItem']")
    private WebElement buttonYesBlock;

    @FindBy(xpath = "//a[@data-action='PopupClose']")
    private WebElement buttonGood;

    @FindBy(xpath = "//ul[@class='desktop-menu']//li[@id='desktop-menu-icon']//a[@href='/account/settings/profile']")
    private WebElement buttonSettings;

    @FindBy(xpath = "//a[@data-action='CookieNoticeAccept']")
    private WebElement buttonCloseCookie;

    @FindBy(xpath = "//nav[@class='subTabBar']//a[@href='/account/settings/account']")
    private WebElement buttonAccount;

    @FindBy(xpath = "//a[@href='/account/settings/blacklist']")
    private WebElement buttonBlacklist;

    @FindBy(xpath = "//span[@dir='ltr']")
    private WebElement blockedUsername;

    @FindBy(xpath = "//a[@data-action='UserBlockDelete']")
    private WebElement buttonUserBlockDelete;

    public List<String> blockUser() throws InterruptedException {
        buttonFriends.click();
        logger.info("Open page Friends");
        inputFriendName.sendKeys(USERNAME2);
        Thread.sleep(2000);

        buttonFriend.click();
        Thread.sleep(2000);
        buttonBlock.click();
        Thread.sleep(2000);
        buttonYesBlock.click();
        Thread.sleep(2000);
        buttonGood.click();
        logger.info("User block");

        Thread.sleep(2000);
        buttonSettings.click();
        buttonSettings.click();
        Thread.sleep(2000);
        buttonCloseCookie.click();
        Thread.sleep(2000);
        buttonAccount.click();
        buttonBlacklist.click();

        List<String> bloclkist = new ArrayList<String>();
        bloclkist.add('@'+USERNAME2);
        bloclkist.add(blockedUsername.getText());

        buttonUserBlockDelete.click();
        logger.info("User unblock");
        return bloclkist;
    }
}

