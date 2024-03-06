from appium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common import action_chains, keys
from time import sleep
from selenium.webdriver.common.by import By
from appium.options.ios import XCUITestOptions
from dotenv import load_dotenv   
import os 

load_dotenv()   

user_name = os.environ.get('BROWSERSTACK_USERNAME')
access_key = os.environ.get('BROWSERSTACK_ACCESS_KEY')

desired_cap = {
	'bstack:options' : {
		"osVersion" : "14",
		"deviceName" : "iPhone 12",
		"realMobile" : "true",
		"projectName" : "Sample Test",
		"buildName" : "Sample_test",
		"debug" : "true",
		"userName": user_name,
    "accessKey": access_key
	},
}
options = XCUITestOptions()
options.set_capability('appium:nativeWebTap', True)
options.set_capability('appium:automationName', 'XCUITest')
options.set_capability('bstack:options', desired_cap['bstack:options'])

driver = webdriver.Remote(
    command_executor='https://hub.browserstack.com/wd/hub',
    options=options)

driver.get("https://the-internet.herokuapp.com/upload")
sleep(10)
driver.find_element(By.ID, 'file-upload').click()
driver.switch_to.context('NATIVE_APP')
driver.find_element(By.NAME, 'Photo Library').click()
sleep(5)
elements = driver.find_elements(By.CLASS_NAME, "XCUIElementTypeImage")
elements[0].click() # 1 represents second element from the list of 9 preloaded images and videos
sleep(10)
driver.find_element(By.NAME, 'Choose').click()
sleep(10)
driver.switch_to.context(driver.contexts[1])
driver.find_element(By.ID, "file-submit").click()
driver.quit()
