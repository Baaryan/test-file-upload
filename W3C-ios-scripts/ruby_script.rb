require 'rubygems'
require 'appium_lib'
require 'dotenv'
Dotenv.load

user_name = ENV['BROWSERSTACK_USERNAME']
access_key = ENV['BROWSERSTACK_ACCESS_KEY']

# Input capabilities
capabilities = {
	'bstack:options' => {
		"osVersion" => "14",
		"deviceName" => "iPhone 12",
		"realMobile" => "true",
		"projectName" => "Sample Test",
		"buildName" => "Sample_test",
		"debug" => "true",
	},
  "appium:nativeWebTap" => true
}

appium_driver = Appium::Driver.new({'caps' => capabilities,'appium_lib' => {:server_url => "https://#{user_name}:#{access_key}@hub-cloud.browserstack.com/wd/hub"}}, true)
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
driver.find_element(name: "Choose").click
contexts = driver.available_contexts
driver.set_context contexts[1]
driver.find_element(:id,"file-submit").click()
driver.quit()
