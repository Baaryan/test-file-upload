using System;
using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.iOS;

namespace SampleTests
{
    class UploadFile
    {
        static void Main(string[] args)
        {
            AppiumDriver<IWebElement> driver;
            AppiumOptions capability = new AppiumOptions();
            capability.AddAdditionalCapability("browserName", "iPhone");
            capability.AddAdditionalCapability("device", "iPhone 12");
            capability.AddAdditionalCapability("realMobile", "true");
            capability.AddAdditionalCapability("os_version", "14");
            capability.AddAdditionalCapability("browserstack.debug", "true");
            capability.AddAdditionalCapability("nativeWebTap", "true");
            driver = new IOSDriver<IWebElement>(
              new Uri("https://<<username>>:<access-key>>@hub-cloud.browserstack.com/wd/hub/"), capability
            );
            driver.Navigate().GoToUrl("https://the-internet.herokuapp.com/upload");
            Thread.Sleep(10000);
            driver.FindElementById("file-upload").Click();
            driver.Context = "NATIVE_APP";
            driver.FindElement(By.Name("Photo Library")).Click();
            Thread.Sleep(5000);
            IWebElement element = driver.FindElementsByClassName("XCUIElementTypeImage")[0];
            element.Click();
            Thread.Sleep(5000);
            driver.FindElementByName("Choose").Click();
            Thread.Sleep(5000);
            driver.Context = driver.Contexts[1];
            Console.WriteLine(driver.Title);
            driver.FindElementById("file-submit").Click();
            driver.Quit();
        }
    }
}