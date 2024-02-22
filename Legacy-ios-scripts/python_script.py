from appium import webdriver
from time import sleep
from selenium.webdriver.common.by import By

desired_cap = {
  "device": "iPhone 12",
  "os_version": "14",
	"real_mobile": "true",
	"browserstack.debug": "true",
	'name': 'Sample Test',
	'build': 'Sample_test',
  "nativeWebTap": True,
	'appium:automationName': 'XCUITest',
}

driver = webdriver.Remote(command_executor='https://<<username>>:<<access-key>>@hub-cloud.browserstack.com/wd/hub', desired_capabilities=desired_cap)
driver.get("https://the-internet.herokuapp.com/upload")
sleep(10)
driver.find_element_by_id('file-upload').click()
driver.switch_to.context('NATIVE_APP')
driver.find_element_by_name('Photo Library').click()
sleep(5)
elements = driver.find_elements_by_class_name("XCUIElementTypeImage")
elements[0].click() # 1 represents second element from the list of 9 preloaded images and videos
sleep(5)
driver.find_element_by_name("Choose").click()
sleep(10)
driver.switch_to.context(driver.contexts[1])
driver.find_element_by_id("file-submit").click()
driver.quit()
