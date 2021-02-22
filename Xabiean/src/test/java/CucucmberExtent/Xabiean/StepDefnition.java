package CucucmberExtent.Xabiean;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefnition {
	
	BasePage base=new BasePage();

	

	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		base.load();
	}

	@When("^user serches for \"([^\"]*)\"$")
	public void user_serches_for(String data) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		base.search(data);
	}

	@Then("^user validates the links$")
	public void user_validates_the_links() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(base.validate());
		base.closeB();
	}
	
	@Given("^user performs get$")
	public void user_get() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		base.performGet();
	}

	@Given("^user validates the response$")
	public void user_response() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		junit.framework.Assert.assertTrue(base.validateResponse());
	}

}
