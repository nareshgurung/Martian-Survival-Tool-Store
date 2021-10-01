package signingIn;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlueCode {
	@When("the user puts in a correct <username>")
	public void the_user_puts_in_a_correct_username() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user inputs a correct <password>")
	public void the_user_inputs_a_correct_password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user is redirected back to the current page")
	public void the_user_is_redirected_back_to_the_current_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the sign in option is replaced by a menu to check their account")
	public void the_sign_in_option_is_replaced_by_a_menu_to_check_their_account(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user puts in an incorrect <username>")
	public void the_user_puts_in_an_incorrect_username() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user inputs an incorrect <password>")
	public void the_user_inputs_a_incorrect_password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
