$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AmazonSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Google Search",
  "description": "",
  "id": "google-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Open browser",
  "description": "",
  "id": "google-search;open-browser",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@OpenBrowser"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am able to open browser as \"chrome\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter the URL as \"http://www.amazon.co.in\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Title should be \"Amazon Sign In\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 30
    }
  ],
  "location": "HomePage_TestCase.i_am_able_to_open_browser_as(String)"
});
formatter.result({
  "duration": 5249094675,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.amazon.co.in",
      "offset": 20
    }
  ],
  "location": "HomePage_TestCase.i_enter_the_URL_as(String)"
});
formatter.result({
  "duration": 7861638445,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Amazon Sign In",
      "offset": 17
    }
  ],
  "location": "HomePage_TestCase.title_should_be(String)"
});
formatter.result({
  "duration": 44413502,
  "status": "passed"
});
});