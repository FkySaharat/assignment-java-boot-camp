## Shopping Flow Design

```mermaid
sequenceDiagram
    actor customer
    participant web app
    participant server
    
   
    customer->>web app: 1.search products by name
    web app->>server: get products by name
    server-->>web app: return list of product
    web app-->> customer: show list of product result
     
    customer->>web app: 2.click on interested product
    web app->>server: get product detail by id
    server-->>web app: return product detail
    web app-->> customer: 3.show detail of selected product
    
    customer->>web app: 4.click on add to basket button
    web app->>server: add product to new basket
    server-->>web app: return updating basket
    web app-->> customer: 5.show data in basket
    
    customer->>web app: 6.click checkout for product in basket
    web app->>server: create checkout
    server-->>web app: return status of checkout
    web app-->> customer: navigate to add shipping step
    
    customer->>web app: 7.add shipping info and click to next process
    web app-->> customer: navigate to add payment step
    customer->>web app: 8.add payment method 
    customer->>web app: 9.click comfirm to order
    web app->>server: create order by paymemt and shiping 
    server-->>web app: return slip
    web app-->> customer:10. navigate to summary page and show slip
   
```

 ## APIs Design

### Products
| Description        | Method | URI                   |
|--------------------|--------|-----------------------|
| Get all products   | GET    | /products             |
| Get product detail | GET    | /products/{productId} |

### Baskets
| Description               | Method | URI                          |
|---------------------------|--------|------------------------------|
| Get basket by id          | GET    | /baskets/{basketId}          |
| Create basket             | POST   | /baskets                     |
| Update product on  basket | UPDATE | /baskets/{basketId}/products |

### Checkout
| Description        | Method | URI       |
|--------------------|--------|-----------|
| checkout products  | POST   | /checkout |

### Orders
| Description                              | Method | URI     |
|------------------------------------------|--------|---------|
| create new order by payment and shipping | POST   | /Orders |


# Models