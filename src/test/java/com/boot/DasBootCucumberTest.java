package com.boot;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "classpath:features", glue = "com.steps", format = {
		"pretty", "json:target/cucumber/cucumber-report.json",
		"html:target/cucumber/plain-html-reports", })
public class DasBootCucumberTest {

}
