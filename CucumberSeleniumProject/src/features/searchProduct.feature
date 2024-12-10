Feature: Search and Place the order for Products

Scenario: Search Experience for product search in both home and offer page

Given User is on GreenCart Landing page
When User searched with "Tom" and extaracted actual name of product
Then User searched for the same shortname in offers page 
And validate product name in offers matches with Landing page
