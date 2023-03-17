import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class Steps {

    private StepHelper stephelper;

    public Steps() {
        stephelper = new StepHelper();
    }

    @Given("From the home page go to contact page")
    public void fromTheHomePageGoToContactPage() {
        stephelper.goToHomePage();
        stephelper.goToContactPage();
    }

    @And("Click submit button")
    public void clickSubmitButton() {
        stephelper.clickOnSubmitbutton();
    }

    @But("Verify error messages")
    public void verifyErrorMessages() {
        stephelper.verifyErrorMessage();
    }

    @And("Populate mandatory fields")
    public void populateMandatoryFields(DataTable dataTable) {
        List<Map<String, String>> records = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> record : records) {
            stephelper.fillTheMandatoryFields(record);
        }
    }

    @Then("Validate errors are gone")
    public void validateErrorsAreGone() {
        stephelper.verifySuccessMessage();
    }

    @Then("Validate successful submission message")
    public void validateSuccessfulSubmissionMessage() {
        stephelper.verifySuccessMessage();
    }

    @And("Go to the cart page")
    public void goToTheCartPage() {
        stephelper.clickOnCart();
    }

    @Then("Verify the subtotal for each product is correct")
    public void verifyTheSubtotalForEachProductIsCorrect() {
        stephelper.calculatePriceOfEachItem();
    }

    @Then("Verify the price for each product")
    public void verifyThePriceForEachProduct() {
        stephelper.verifyThePriceForEachProduct();
    }

    @Then("Verify that total = sum\\(sub totals)")
    public void verifyThatTotalSumSubTotals() {
        stephelper.verifySubTotal();
    }

    @Given("Buy {string}")
    public void buy(String input) {
        stephelper.addToCart(input);
    }

    @Given("From the home page go to shop page")
    public void fromTheHomePageGoToShopPage() {
        stephelper.goToHomePage();
        stephelper.goToShopPage();
    }

    @Given("Run this test {string} times to ensure {int}% pass rate")
    public void runThisTestTimesToEnsurePassRate(String arg0, int arg1) {

    }

    @And("Populate mandatory fields, submit & Validate successful submission message")
    public void populateMandatoryFieldsSubmitValidateSuccessfulSubmissionMessage(DataTable dataTable) {
        List<Map<String, String>> records = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> record : records) {
            stephelper.fillTheMandatoryFields(record);
            stephelper.clickOnSubmitbutton();
            stephelper.verifySuccessMessage();
            stephelper.goBackToContactPage();
        }
    }
}
