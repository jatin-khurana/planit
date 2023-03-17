import engine.Utilities;
import locators.CartPageLocators;
import locators.CommonLocators;
import locators.ContactLocators;
import locators.ShopPageLocators;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class StepHelper {

    private Utilities utilities;
    private CartPageLocators cartPageLocators;
    private CommonLocators commonLocators;
    private ContactLocators contactLocators;
    private ShopPageLocators shopPageLocators;
    Map<String, Integer> productQuantityMap = new HashMap<String, Integer>();
    Map<String, Float> productPriceMap = new HashMap<String, Float>();
    float Total = 0;

    public StepHelper() {
        utilities = new Utilities();
    }

    public void goToHomePage() {
        commonLocators = new CommonLocators(utilities);
        commonLocators.getHomeButton().click();
    }

    public void goToContactPage() {
        commonLocators = new CommonLocators(utilities);
        commonLocators.getContactButton().click();

    }


    public void clickOnSubmitbutton() {
        contactLocators = new ContactLocators(utilities);
        contactLocators.getSubmitButton().click();
    }

    public void verifyErrorMessage() {
        contactLocators = new ContactLocators(utilities);
        if (contactLocators.getError().isDisplayed()) {
            String errorMessage = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
            Assert.assertEquals(contactLocators.getError().getText(), errorMessage);
        }
    }

    public void verifySuccessMessage() {
        Assert.assertTrue("Couldn’t find a successful submission message.", contactLocators.getSuccess().isDisplayed());
    }

    public void clickOnCart() {
        commonLocators = new CommonLocators(utilities);
        commonLocators.getCartButton().click();
    }

    public void goToShopPage() {
        commonLocators = new CommonLocators(utilities);
        commonLocators.getShopButton().click();
    }

    public void calculatePriceOfEachItem() {
        cartPageLocators = new CartPageLocators(utilities);
        utilities.waitForElementToBeVisible(cartPageLocators.Total);
        for (Map.Entry<String, Integer> entry : productQuantityMap.entrySet()) {
            float price = Float.parseFloat(cartPageLocators.getItemPriceFromCart(entry.getKey()).getText().replace("$", ""));
            int quantity = Integer.parseInt(cartPageLocators.getQuantityOfAnItemFromCart(entry.getKey()).getAttribute("value"));
            float Subtotal = Float.parseFloat(cartPageLocators.getTotalPriceOfAnItem(entry.getKey()).getText().replace("$", ""));
            Assert.assertEquals(price * quantity, Subtotal, 0.1);
            Total = Total + (price * quantity);
        }
    }

    public void verifyThePriceForEachProduct() {
        cartPageLocators = new CartPageLocators(utilities);
        for (Map.Entry<String, Float> entry : productPriceMap.entrySet()) {
            float productPriceFromCart = Float.parseFloat(cartPageLocators.getItemPriceFromCart(entry.getKey()).getText().replace("$", ""));
            float productPriceFromShop = entry.getValue();
            Assert.assertEquals(productPriceFromCart, productPriceFromShop, 0.1);
        }

    }

    public void addToCart(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String[] itemQuantityPair = item.trim().split("-");
            int quantity = Integer.parseInt(itemQuantityPair[0]);
            String itemName = itemQuantityPair[1];
            productQuantityMap.put(itemName, quantity);
            shopPageLocators = new ShopPageLocators(utilities);
            for (int i = 0; i < quantity; i++) {
                /*This sleep is added to slow down the execution.
                 * it was way too fast.
                 * */
                utilities.sleep(1000);
                productPriceMap.put(itemName, Float.valueOf(shopPageLocators.getItemPrice(itemName).getText().replace("$", "")));
                shopPageLocators.getBuyItem(itemName).click();
            }
        }
    }

    public void verifySubTotal() {
        cartPageLocators = new CartPageLocators(utilities);
        float TotalFromUI = Float.parseFloat(cartPageLocators.getTotal().getText().replace("Total: ", "").trim());
        Assert.assertEquals(Total, TotalFromUI, 0.1);
    }

    public void fillTheMandatoryFields(Map<String, String> data) {
        contactLocators = new ContactLocators(utilities);
        contactLocators.getForename().sendKeys(data.get("Forename"));
        contactLocators.getEmail().sendKeys(data.get("Email"));
        contactLocators.getMessage().sendKeys(data.get("Message"));

    }

    public void goBackToContactPage() {
        contactLocators = new ContactLocators(utilities);
        contactLocators.getBack().click();
    }
}
