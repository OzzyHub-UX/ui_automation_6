package automation_projects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project3Page;
import scripts.Base;
import utils.DropdownHandler;
import utils.Waiter;


public class Project03 extends Base{


    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-3");
        Project3Page project3Page = new Project3Page();
        actions = new Actions(driver);


    }

    /**
     * TEST CASE 1
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Validate that the “One way” radio button is displayed enabled and selected by default
     * Validate that the “Round trip” radio button is displayed enabled and not selected by default
     * Validate that the “Cabin Class” label and dropdown are displayed
     * Validate that the “From” label and dropdown are displayed
     * Validate that the “To” label and dropdown are displayed
     * Validate that the “Depart” label and date picker is displayed
     * Validate that the “Return” label and date picker is displayed and disabled
     * Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
     * Validate that the “Passenger 1” category label and dropdown are displayed and “Adult (16-64)” is the default
     * Validate that the “BOOK” button is displayed and enabled
     */
    @Test
    public void validateDefaultBookTripForm() {
        Assert.assertTrue(project3Page.radioButtonOneWay.isDisplayed());
        Assert.assertTrue(project3Page.radioButtonOneWay.isEnabled());
        Assert.assertTrue(project3Page.radioButtonOneWay.isSelected());

        Assert.assertTrue(project3Page.radioButtonRoundTrip.isDisplayed());
        Assert.assertTrue(project3Page.radioButtonRoundTrip.isEnabled());
        Assert.assertFalse(project3Page.radioButtonRoundTrip.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());


        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isEnabled());


        Assert.assertTrue(project3Page.nrOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.nrOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.nrOfPassengersDropdown.getAttribute("value"), "1");


        Assert.assertTrue(project3Page.passengerLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerDropdown.isDisplayed());
        Assert.assertEquals(project3Page.passengerDropdown.getText(), "Adult (16-64)");

        Assert.assertTrue(project3Page.submitButton.isDisplayed());
        Assert.assertTrue(project3Page.submitButton.isEnabled());

    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Click on the “Round trip” radio button and validate it is selected
     * Validate that the “One way” radio button is not selected
     * Validate that the “Cabin Class” label and dropdown are displayed
     * Validate that the “From” label and dropdown are displayed
     * Validate that the “To” label and dropdown are displayed
     * Validate that the “Depart” label and date picker is displayed
     * Validate that the “Return” label and date picker is displayed
     * Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
     * Validate that the “Passenger 1” label and dropdown are displayed and “Adult (16-64)” is the default
     * Validate that the “BOOK” button is displayed and enabled
     */
    @Test
    public void validateRoundTripFormElements() {
        project3Page.radioButtonRoundTrip.click();

        Assert.assertTrue(project3Page.radioButtonRoundTrip.isSelected());
        Assert.assertFalse(project3Page.radioButtonOneWay.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departDatePicker.isDisplayed());


        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isDisplayed());
        Assert.assertTrue(project3Page.returnDatePicker.isEnabled());

        Assert.assertTrue(project3Page.nrOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.nrOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.nrOfPassengersDropdown.getAttribute("value"), "1");


        Assert.assertTrue(project3Page.passengerLabel.isDisplayed());
        Assert.assertTrue(project3Page.passengerDropdown.isDisplayed());
        Assert.assertEquals(project3Page.passengerDropdown.getText(), "Adult (16-64)");

        Assert.assertTrue(project3Page.submitButton.isDisplayed());
        Assert.assertTrue(project3Page.submitButton.isEnabled());


    }

    /**
     * Navigate to https://techglobal-training.com/frontend/project-3
     * Select the “One way” radio button
     * Select “Business” for the “Cabin Class” dropdown
     * Select “Illinois” for the “From” dropdown
     * Select “Florida” for the “To” dropdown
     * Select the next week for the ”Depart”
     * Select “1” for the “Number of passengers” dropdown
     * Select “Senior (65+)” for the Passenger 1 dropdown
     * Click on the “BOOK” button
     * Validate the booking information displayed below
     * DEPART
     * IL to FL
     * {dynamic date}
     * Number of passengers: 1
     * Passenger 1: Senior (65+)
     * Cabin Class: Business
     */


    @Test(priority = 3, description = "Validate booking a trip one way")
    public void validateBookingOneWay() {

        project3Page.radioButtonOneWay.click();

        DropdownHandler.clickDropdownOption(project3Page.cabinClassDropdown, project3Page.dropdownClassOptions, "Business");
        DropdownHandler.clickDropdownOption(project3Page.fromDropdown, project3Page.fromLabelOptions, "Illinois");
        DropdownHandler.clickDropdownOption(project3Page.toDropdown, project3Page.toLabelOptions, "Florida");

        /*
        actions.moveToElement(project3Page.getDepartDatePicker)
                .click()
                .sendKeys("6", "18", "2023")
                .sendKeys(Keys.RETURN)
                .perform();

        Waiter.pause(3);

         */


        DropdownHandler.clickDropdownOption(project3Page.nrOfPassengersLabel, project3Page.getNrOfPassengersDropdown, "1");
        DropdownHandler.clickDropdownOption(project3Page.passengerLabel, project3Page.getPassengerDropdown, "Senior (65+)");

        project3Page.submitButton.click();

        Assert.assertTrue(project3Page.departText.isDisplayed());
        Assert.assertTrue(project3Page.statesText.isDisplayed());
        Assert.assertTrue(project3Page.dateText.isDisplayed());

    }

    @Test(priority = 4, description = "Validate booking a round trip")
    public void validateBookingRoundTrip() {

        project3Page.radioButtonRoundTrip.click();

        DropdownHandler.clickDropdownOption(project3Page.cabinClassDropdown, project3Page.dropdownClassOptions, "First");
        DropdownHandler.clickDropdownOption(project3Page.fromDropdown, project3Page.fromLabelOptions, "California");
        DropdownHandler.clickDropdownOption(project3Page.toDropdown, project3Page.toLabelOptions, "Illinois");


        actions.moveToElement(project3Page.getDepartDatePicker)
                .click()
                .sendKeys("7", "18", "2023")
                .sendKeys(Keys.RETURN)
                .perform();

        Waiter.pause(3);


        DropdownHandler.clickDropdownOption(project3Page.nrOfPassengersLabel, project3Page.getNrOfPassengersDropdown, "1");
        DropdownHandler.clickDropdownOption(project3Page.passengerLabel, project3Page.getPassengerDropdown, "Adult (16-64)");

        project3Page.submitButton.click();

        Assert.assertTrue(project3Page.departText.isDisplayed());
        Assert.assertTrue(project3Page.statesText.isDisplayed());
        Assert.assertTrue(project3Page.dateText.isDisplayed());

    }

    @Test(priority = 5, description = "Validate booking a one way trip for two")
    public void validateBookingRoundTripForTwo() {

        project3Page.radioButtonOneWay.click();

        DropdownHandler.clickDropdownOption(project3Page.cabinClassDropdown, project3Page.dropdownClassOptions, "Premium Economy");
        DropdownHandler.clickDropdownOption(project3Page.fromDropdown, project3Page.fromLabelOptions, "New York");
        DropdownHandler.clickDropdownOption(project3Page.toDropdown, project3Page.toLabelOptions, "Texas");


        actions.moveToElement(project3Page.getDepartDatePicker)
                .click()
                .sendKeys("7", "19", "2023")
                .sendKeys(Keys.RETURN)
                .perform();

        Waiter.pause(3);


        DropdownHandler.clickDropdownOption(project3Page.nrOfPassengersLabel, project3Page.getNrOfPassengersDropdown, "1");
        DropdownHandler.clickDropdownOption(project3Page.passengerLabel, project3Page.getPassengerDropdown, "Adult (16-64)");

        project3Page.submitButton.click();

        Assert.assertTrue(project3Page.departText.isDisplayed());
        Assert.assertTrue(project3Page.statesText.isDisplayed());
        Assert.assertTrue(project3Page.dateText.isDisplayed());
    }

}