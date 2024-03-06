require 'rubygems'
require 'appium_lib'
require 'dotenv'
Dotenv.load

user_name = ENV['BROWSERSTACK_USERNAME']
access_key = ENV['BROWSERSTACK_ACCESS_KEY']

# Input capabilities
caps = {}
caps['device'] = 'iPhone 12'
caps['os_version'] = '14'
caps['realMobile'] = 'true'
caps['name'] = 'BStack-[Ruby] Sample Test' # test name
caps['build'] = 'BStack Build Number 1' # CI/CD job or build name
caps['nativeWebTap'] = 'true'
caps['appium:automationName'] = 'XCUITest'

appium_driver = Appium::Driver.new({'caps' => caps,'appium_lib' => {:server_url => "https://#{user_name}:#{access_key}@hub-cloud.browserstack.com/wd/hub"}}, true)
driver = appium_driver.start_driver

driver.navigate.to "https://the-internet.herokuapp.com/upload"
sleep(5)
driver.find_element(xpath: "//*[@id='file-upload']").click
driver.set_context('NATIVE_APP')
sleep(10)
driver.find_element(name: "Photo Library").click
sleep(5)
elements=driver.find_elements(:class_name,"XCUIElementTypeImage")
elements[0].click
sleep(5)
driver.find_element(name: "Choose").click
sleep(5)
contexts = driver.available_contexts
driver.set_context contexts[1]
driver.find_element(:id,"file-submit").click()
driver.quit()
