# encoding: utf-8

@dasa
Feature: Portal Navigation

  Scenario: Validate Company Page Navigation
    Given I Navigate To "http://www.dasa.com.br"
    And I Navigate To Companies Page
    When I Select "São Paulo" As Region 
    Then I Print Filtered Companies URLs on console
    When I Select "delboniauriemo.com.br" Company
    Then I verify if I navigated to "https://delboniauriemo.com.br/"