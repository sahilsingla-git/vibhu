$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Functional/PracticeLogin.feature");
formatter.feature({
  "line": 3,
  "name": "Practice Login",
  "description": "\r\nVerify if user is able to login into practice",
  "id": "practice-login",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@PracticeLogin"
    }
  ]
});
formatter.scenarioOutline({
  "line": 7,
  "name": "Practice Login",
  "description": "",
  "id": "practice-login;practice-login",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "user lands on practice login page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "user enter \"\u003cpracusername\u003e\" and \"\u003cpracuserpwd\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user lands on homepage",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "practice-login;practice-login;",
  "rows": [
    {
      "cells": [
        "pracusername",
        "pracuserpwd"
      ],
      "line": 13,
      "id": "practice-login;practice-login;;1"
    },
    {
      "cells": [
        "mngr253182",
        "YjaguhY"
      ],
      "line": 14,
      "id": "practice-login;practice-login;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3785666413,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Practice Login",
  "description": "",
  "id": "practice-login;practice-login;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@PracticeLogin"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "user lands on practice login page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "user enter \"mngr253182\" and \"YjaguhY\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user lands on homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "PracticeLogin.user_lands_on_practice_login_page()"
});
formatter.result({
  "duration": 9572073642,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mngr253182",
      "offset": 12
    },
    {
      "val": "YjaguhY",
      "offset": 29
    }
  ],
  "location": "PracticeLogin.user_enter_and(String,String)"
});
formatter.result({
  "duration": 3641895956,
  "status": "passed"
});
formatter.match({
  "location": "PracticeLogin.user_lands_on_homepage()"
});
formatter.result({
  "duration": 64269605,
  "status": "passed"
});
formatter.after({
  "duration": 87598,
  "status": "passed"
});
formatter.after({
  "duration": 750974632,
  "status": "passed"
});
});