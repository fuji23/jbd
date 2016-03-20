package com.home.jbrowser;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Canechek on 19.03.2016.
 */
public class Main {

  String env;

  @BeforeClass
  @Parameters("env")
  public void before(String env){
    this.env = env;
  }

  @Test
  public void test1() {
    JBrowserDriver driver = null;
    System.out.println(env);
    try {

      // You can optionally pass a Settings object here,
      // constructed using Settings.Builder
      driver = new JBrowserDriver();

      // This will block for the page load and any
      // associated AJAX requests
      driver.get("https://github.com/MachinePublishers/jBrowserDriver/issues");

/*
      driver.findElement(By.id("lst-ib")).sendKeys("robot");
      driver.findElement(By.xpath("/*/
/*[@name='btnK']")).click();
*/
      driver.findElements(By.xpath("//li//a[contains(@class, 'issue-title-link')]")).stream().map(WebElement::getText).forEach(System.out::println);
    } finally {
      driver.quit();
    }
  }

}
