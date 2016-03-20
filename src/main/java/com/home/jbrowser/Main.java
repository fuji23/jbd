package com.home.jbrowser;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Canechek on 19.03.2016.
 */
public class Main {

  String env;
  String param;

  @BeforeClass
  @Parameters({"env", "param"})
  public void before(@Optional(value = "") String env, @Optional(value = "") String param){
    this.env = env;
    this.param = param;
  }

  @Test
  public void test1() {
    JBrowserDriver driver = null;
    System.out.println("ENV is " + env);
    try {

      driver = new JBrowserDriver();
      Reporter.log("Current env is " + env + " params " + param);
/*
      driver.get("https://github.com/MachinePublishers/jBrowserDriver/issues");

      driver.findElements(By.xpath("//li//a[contains(@class, 'issue-title-link')]")).stream().map(WebElement::getText).forEach(System.out::println);
*/
    } finally {
      driver.quit();
    }
  }

}
