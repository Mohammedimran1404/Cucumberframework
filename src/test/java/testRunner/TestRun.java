package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = ".\\Features",
	glue = "stepDefinitions",
	dryRun =false,
	//monochrome = true,
	plugin={"pretty","html:test-output"}
//	tags = "@Regression"  /* this tag help to run the test cases what we want. we can write any name in feature file */
	)
	public class TestRun  {
}

	
	/* if we want to run all the fearute file present in feature folder
	 * just enter the folder path like : - features=".\\Features"
	 *  if there are 10 features file if we want to run 4 feature file then write like
	 * this features={".\\Features\\login.feature",".\\Features\\Customer.feature"}
	 * if we want to run particular feature file then feature=".\\Features\\foldername.feature"
	 * monochrome=true is write when the snippents generated in special characters we cant understand
	 * that one when monochrome=true is written its generated in correct format
	 */
	 
	 