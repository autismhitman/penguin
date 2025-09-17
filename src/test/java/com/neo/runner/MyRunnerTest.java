package com.neo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
 features="src/test/resources/features",
 plugin=  { "html:target/cucumber/index.html",   }, 
 glue={"com.neo"},
 tags="@Third"
)
public class MyRunnerTest extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}
	

}
