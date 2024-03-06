using System;
using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.iOS;
using dotenv.net;

namespace SampleTests
{
    class UploadFile
    {
        static void Main(string[] args)
        {
            AppiumDriver driver;
            AppiumOptions capabilities = new AppiumOptions();
            Dictionary<string, object> browserstackOptions = new Dictionary<string, object>();

            browserstackOptions.Add("osVersion", "14");
            browserstackOptions.Add("deviceName", "iPhone 12");
            browserstackOptions.Add("realMobile", "true");
            browserstackOptions.Add("projectName", "Sample Test");
            browserstackOptions.Add("buildName", "Sample_test");
            browserstackOptions.Add("debug", "true");
            capabilities.AddAdditionalAppiumOption("bstack:options", browserstackOptions);
            capabilities.AutomationName = "XCUITest";
            capabilities.AddAdditionalAppiumOption("appium:nativeWebTap", true);

            DotEnv.Load();
            string? userName = Environment.GetEnvironmentVariable("BROWSERSTACK_USERNAME");
            string? accessKey = Environment.GetEnvironmentVariable("BROWSERSTACK_ACCESS_KEY");

            Uri serverUri = new Uri($"https://{userName}:{accessKey}@hub-cloud.browserstack.com/wd/hub/");
            
            driver.Navigate().GoToUrl("https://the-internet.herokuapp.com/upload");
            Thread.Sleep(10000);
            driver.FindElement(By.Id("file-upload")).Click();
            driver.Context = "NATIVE_APP";
            driver.FindElement(By.XPath("//XCUIElementTypeButton[@name='Photo Library']")).Click();
            Thread.Sleep(5000);
            IWebElement element = driver.FindElements(By.XPath("//XCUIElementTypeImage"))[0];
            element.Click();
            Thread.Sleep(5000);
            driver.FindElement(By.XPath("//XCUIElementTypeButton[@name='Choose']")).Click();
            Thread.Sleep(5000);
            driver.Context = driver.Contexts[1];
            Console.WriteLine(driver.Title);
            driver.FindElement(By.Id("file-submit")).Click();
            driver.Quit();
        }
    }
}