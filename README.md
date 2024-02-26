# Test-file-upload
Selenium -> test-file-upload

## Documentation

[Link](https://www.browserstack.com/docs/automate/selenium/test-file-upload)

## Jira

[Link](https://browserstack.atlassian.net/browse/APS-9830)

## Public Sessions to see results:

### Selenium 4 W3C test scripts to test on iOS devices

1. [Ruby](https://automate.browserstack.com/builds/7c3e0bf186848b3400e9cb4f263eb9ef67fcaf9a/sessions/c50e762833a8c84bf133049bd49e29b27cf4f4bf?auth_token=38aa42556076d2028d7d97d26d606a0cdd7a673514db6162d9bdee256f7cbd77)

2. [Python](https://automate.browserstack.com/builds/7c3e0bf186848b3400e9cb4f263eb9ef67fcaf9a/sessions/fa07830ceb5527b6abd980c9b80c298b0266ddf9?auth_token=281d6cda1d01fc97fa978548fde3498e2a56346f372b61ec43ff49ea3d83bbe4)
   
3. [Java](https://automate.browserstack.com/builds/f12ad5ffdaa78cda479d52352b4030be2e11802a/sessions/d3737ca905083630e5fa34fdc632ae03aa1ef610?auth_token=c88e007afe15fca93c0bf09152c8abd5182cb20e5270b13bb0f8885c21f7103c)

4. [C#](https://automate.browserstack.com/builds/7c3e0bf186848b3400e9cb4f263eb9ef67fcaf9a/sessions/736fbd17db11893af28993c705098e10468cff6d?auth_token=2910fe5a0845a1fa57b4a31dcdf310576f163b0957b1b4c8642efbdf1f889d12)

5. [NodeJS](https://automate.browserstack.com/builds/7c3e0bf186848b3400e9cb4f263eb9ef67fcaf9a/sessions/888d027918ea347162de83064223f22007eed306?auth_token=5a0444aa6158b56873e08a6b97edab7bf780217b7d6ffc57ce09a7e0305adf02)

### Selenium Legacy JSON test scripts to test on iOS devices

1. [Ruby](https://automate.browserstack.com/builds/2f18512e248860fa123b747b27c46b90ad43079d/sessions/8768b0b1fb97083e2657ba2fe5d25f242b24b827?auth_token=2d6dc4f9ae1067e712dae48f27862cd0faae7beeda05d656a8ceb09ba8a9a03d)

2. [Python](https://automate.browserstack.com/builds/c8d3ee09bf752e26d03c156d69520a328f41c476/sessions/57e1d24ec4de63d65da1ade3fef7f53caf885aa5?auth_token=73a45ebd5a28920a7f29c4590d7f84dc73e1f721da4bb93ea44032b6b0d4a5b5)

3. [Java](https://automate.browserstack.com/builds/b5ede2e0bf812fad3c3e18f8eff115930d4e3e57/sessions/eb73b08b5a0dd94b9a31de67a16ba94fa8f35b4f?auth_token=60893b55853a76c648a2d0bf62ee466b00a9236dfec2c37418d44b29ceb9d4a8)

4. [C#](https://automate.browserstack.com/builds/c72a91edb31ab94cfc3401f85a879529def6e1d8/sessions/ae9ce2bd138afc8433f80b3f045580bafc462693?auth_token=32aae679bad9417c3fe6f2243f964de105f282f8f0d10865e1347c362280da58)

5. [NodeJS](https://automate.browserstack.com/builds/2f18512e248860fa123b747b27c46b90ad43079d/sessions/c5ebd8ba2d08228e6d731876cae4facbb3c82a2b?auth_token=167ad2c63139481297e7fb226de6e3c4ae926752a16c05921b0ea8181db85612)

Note:
1. Python: Only Appium v1 supports Legacy JSON, therefore for those scripts to work use the following versions:
  - Appium-Python-Client==1.3.0
  - urllib3==1.26.16

2. C#: Dependency versions that support Legacy JSON:
    ```
    <PackageReference Include="Appium.WebDriver" Version="4.4.5" />
    <PackageReference Include="Castle.Core" Version="4.4.1" />
    <PackageReference Include="Newtonsoft.Json" Version="13.0.3" />
    <PackageReference Include="Selenium.Support" Version="3.141.0" />
    <PackageReference Include="Selenium.WebDriver" Version="3.141.0" />
    ```
