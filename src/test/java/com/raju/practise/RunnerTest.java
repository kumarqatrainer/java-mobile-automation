package com.raju.practise;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "." },tags = { "@trail1"}, dryRun = false, strict = false, monochrome = true, plugin = { "json:target/cucumber.json" })

public class RunnerTest {

}




