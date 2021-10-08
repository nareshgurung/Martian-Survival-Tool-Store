package net.revature.martiantools.gluecode;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/inventory.feature", glue="net.revature.martiantools.gluecode")
public class CucumberTestRunner {

}
