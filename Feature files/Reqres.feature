Feature: Reqres link restAPI Automation


@get @smoke
Scenario: Get method

Given user should be able to launch URI
When user hits the url "<URL>" results with a response
Then user gets the status code "<status code>" for the url "<URL>"

Examples:
|URL|status code|
|api/users?page=2|"200"|
|api/users/2|"200"|
|api/users/23|"404"|
|api/unknown|"200"|
|api/unknown/2|"200"|
|api/unknown/23|"404"|
|api/users?delay=3|"200"|


@post @smoke
Scenario: Post method

Given user should be able to launch URI
When user hits the url "<URL>" and "<JSON>" results with a response
Then user gets the status code "<status code>" for the url "<URL>" and "<JSON>"

Examples:
|URL|status code|JSON|
|api/users|"201"|'{ \"name\" : \"morpheus\",\"job\" : \"leader\" }'|
|api/register|"400"|'{ \"email\" : \"eve.holt@reqres.in\",\"password\" : \"pistol\" }'|
|api/register|"400"|'{ \"email\" : \"sydney@fife\" }'|
|api/login|"400"|'{ \"email\" : \"eve.holt@reqres.in\",\"password\" : \"cityslicka\" }'|
|api/login|"400"|'{ \"email\" : \"peter@klaven\" }'|




@put @smoke
Scenario: Put method

Given user should be able to launch URI
When user hits the url "<URL>" and "<JSON>" results with a put response
Then user gets the put status code "<status code>" for the url "<URL>" and "<JSON>"

Examples:
|URL|status code|JSON|
|api/users/2|"200"|'{ \"name\" : \"morpheus\",\"job\" : \"zion resident\" }'|





@patch @smoke
Scenario: Patch method

Given user should be able to launch URI
When user hits the url "<URL>" and "<JSON>" results with a patch response
Then user gets the patch status code "<status code>" for the url "<URL>" and "<JSON>"

Examples:
|URL|status code|JSON|
|api/users/2|"200"|'{ \"name\" : \"morpheus\",\"job\" : \"zion resident\" }'|





@delete @smoke
Scenario: delete method

Given user should be able to launch URI
When user delete the url "<URL>" results with a response
Then user gets the status code "<status code>" for the url "<URL>" deleted

Examples:
|URL|status code|
|api/users/2|"204"|


@db
Scenario: dbconnection

Given user should be able to launch URI
Then user should make db connection


