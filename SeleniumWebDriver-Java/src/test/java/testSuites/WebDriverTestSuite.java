package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testScripts._01_CreateComputer;
import testScripts._04_DeleteComputer;
import testScripts._02_ReadComputer;
import testScripts._03_UpdateComputer;

@RunWith(Suite.class)
@SuiteClasses({
	_01_CreateComputer.class,
	_02_ReadComputer.class,
	_03_UpdateComputer.class,
	_04_DeleteComputer.class
})

public class WebDriverTestSuite {

}