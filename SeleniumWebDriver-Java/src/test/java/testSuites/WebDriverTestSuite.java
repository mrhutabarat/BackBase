package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testScripts.CreateComputer;
import testScripts.DeleteComputer;
import testScripts.ReadComputer;
import testScripts.UpdateComputer;

@RunWith(Suite.class)
@SuiteClasses({
	CreateComputer.class,
	ReadComputer.class,
	UpdateComputer.class,
	DeleteComputer.class
})

public class WebDriverTestSuite {

}