## Shopping Flow Design

```mermaid
sequenceDiagram
    actor consumer
    participant server
    
    activate consumer
    consumer->>server: 1.1 Search product by name
    activate server
    server-->>consumer: 1.2 Return list of match products
    deactivate server
     
    consumer->>server: 2. Get a product detail
    activate server
    server-->>consumer: 3. Return product detail
    deactivate server
    
    consumer->>server: 4. move product to basket
    activate server
    server-->>consumer: 5. return updated basket
    deactivate server
    
    consumer->>server: 6.1 checkout products
    activate server
    server-->>consumer: 6.2 return status of checkout
    deactivate server
    
    consumer->>server: 7.1 Add shipping information
    activate server
    server-->>consumer: 7.2 Return stutus of adding
    deactivate server
    
    consumer->>server: 8.1 Add payment method
    activate server
    server-->>consumer: 8.2 Return status of adding payment method
    deactivate server
    
    consumer->>server: 9. Comfirm to Order
    activate server
    server-->>consumer: 10. Return Summary Receipt
    deactivate server
    
    deactivate consumer
```

 ##APIs Design

###Products
| Description        | Method | URI                   |
|--------------------|--------|-----------------------|
| Get all products   | GET    | /products             |
| Get product detail | GET    | /products/{productId} |

###Baskets
| Description                     | Method | URI                 |
|---------------------------------|--------|---------------------|
| Get user's basket               | GET    | /baskets/{basketId} |
| Create user's basket            | POST   | /baskets            |
| Update user's basket by product | UPDATE | /baskets            |

###Checkout
| Description                | Method | URI       |
|----------------------------|--------|-----------|
| checkout selected products | POST   | /checkout |

###Shipping
| Description              | Method | URI                    |
|--------------------------|--------|------------------------|
| Add shipping information | POST   | /shipping              |

###PaymentMethods
| Description                     | Method | URI             |
|---------------------------------|--------|-----------------|
| Get available payment methods   | GET    | /paymentMethods |


###Orders
| Description      | Method | URI     |
|------------------|--------|---------|
| create new order | POST   | /Orders |


# Models