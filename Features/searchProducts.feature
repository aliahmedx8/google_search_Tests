Feature: searching products

Scenario Outline: Searching Products on amazon

Given I am on the amazon homepage

When i enter the "<product_name>" in the search bar
And i click on the search button

Then i can able to see the product search result sucessfully


Examples: 

| product_name |
|Toys          |
|Flowers       |
|PlayCards     |


