@Login
Feature: Verify the Login Feature with all users login
  I want to use this template for my feature file

  Background:
    Given User launches the SwagLabs
    Then URL of the page should be "https://www.saucedemo.com/"

  @standard_user_login
  Scenario: Login Functionality with Standard user
    Given User landed on Swag Labs Application Home Page
    When User attempts to login with below credentials
      | standard_user | secret_sauce |
    Then user should be directed to product catalog page

  @locked_out_user_login
  Scenario: Login Functionality with locked_out_user
    Given User landed on Swag Labs Application Home Page
    When User attempts to login with below credentials
      | locked_out_user | secret_sauce |
    Then user should be directed to product catalog page

  @problem_user_login
  Scenario: Login Functionality with problem_user
    Given User landed on Swag Labs Application Home Page
    When User attempts to login with below credentials
      | problem_user | secret_sauce |
    Then user should be directed to product catalog page

  @performance_glitch_user_login
  Scenario: Login Functionality with performance_glitch_user
    Given User landed on Swag Labs Application Home Page
    When User attempts to login with below credentials
      | performance_glitch_user | secret_sauce |
    Then user should be directed to product catalog page
