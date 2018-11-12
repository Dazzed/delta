package com.delta.cru.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/delta/cru/cucumber/features",
        glue = "com.delta.cru.cucumber.stepdefs",
        format = {
                "pretty",
                "html:cucumber-reports/cucumber-pretty",
                "json:cucumber-reports/CucumberTestReport.json",
                "rerun:cucumber-reports/rerun.txt"
        })
public class CucumberTest {

}