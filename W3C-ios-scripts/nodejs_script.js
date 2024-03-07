
const { remote, By } = require('webdriverio');
require('dotenv').config();

const username = process.env.BROWSERSTACK_USERNAME;
const accessKey = process.env.BROWSERSTACK_ACCESS_KEY;

const desiredCapabilities = {
    'bstack:options': {
        'osVersion': '14',
        'deviceName': 'iPhone 12',
        'realMobile': 'true',
        'projectName': 'Sample Test',
        'buildName': 'Sample_test',
        'debug': 'true',
        'userName': username,
        'accessKey': accessKey,
    },
};

const options = {
  hostname: 'hub.browserstack.com',
  port: 443,
  protocol: 'https',
};

const capabilities = {
  'appium:nativeWebTap': true,
  'appium:automationName': 'XCUITest',
  'bstack:options': desiredCapabilities['bstack:options'],
};

async function runTest() {
  const driver = await remote({
    ...options,
    capabilities,
    path: '/wd/hub',
});

    try {
        await driver.url('https://the-internet.herokuapp.com/upload');
        await driver.pause(10000); 

        const fileUpload = await driver.$('#file-upload'); //find by id
        await fileUpload.click();
        await driver.pause(5000);

        await driver.switchContext('NATIVE_APP');
        const photoLibraryButton = await driver.$('[name="Photo Library"]');
        await photoLibraryButton.click();

        await driver.pause(5000); 

        const elements = await driver.$$('//XCUIElementTypeImage');
        await elements[0].click(); // 1 represents the second element from the list of 9 preloaded images and videos

        await driver.pause(10000); 

        const chooseButton = await driver.$('[name="Choose"]');
        await chooseButton.click();

        await driver.pause(5000); 

        const contexts = await driver.getContexts();
        await driver.switchContext(contexts[1]);
        await driver.pause(5000); 
        
        const fileSubmitButton = await driver.$('#file-submit');
        await fileSubmitButton.click();
    } finally {
        await driver.deleteSession();
    }
}

runTest();
