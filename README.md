# Market API

This is an API to expose services related to a market

The architecture of this project is based on the 3 layer model.

| Layer       | Components                                                            |
|-------------|-----------------------------------------------------------------------|
| Domain      | DTOs & Domain Objects <br/> Services <br/> Repositories Specification |
| WEB         | Rest API Controllers                                                  |
| Persistence | Repositories <br/> Entities                                           |

## Data Model

Tables:

### Categories
| Field       | Type        |
|-------------|-------------|
| id_category | INT *pk*    |
| description | VARCHAR(45) |
| state       | TINYINT     |


### Products
| Field       | Type                  |
|-------------|-----------------------|
| id_category | INT *pk*              |
| name        | VARCHAR(45)           |
| barcode     | VARCHAR(150)          |
| sell_price  | DECIMAL(16, 2)        |
| in_stock    | INT                   |
| state       | TINYINT               |
| id_category | INT  *fk(categories)* |


### buys_products
| Field       | Type                  |
|-------------|-----------------------|
| quantity    | INT                   |
| total       | DECIMAL(16, 2)        |
| state       | TINYINT               |
| id_buy      | INT *fk(buys)*        |
| id_product  | INT *fk(products)*    |


### buys
| Field          | Type                      |
|----------------|---------------------------|
| id_buy         | INT *pk*                  |
| buy_date       | DATETIME                  |
| payment_method | CHAR(1)                   |
| comment        | VARCHAR(300)              |
| state          | CHAR(1)                   |
| id_client      | VARCHAR(20) *fk(clients)* |


### clients
| Field     | Type             |
|-----------|------------------|
| id_client | VARCHAR(20) *pk* |
| name      | VARCHAR(40)      |
| lastname  | VARCHAR(100)     |
| cellphone | DECIMAL          |
| address   | VARCHAR(80)      |
| email     | VARCHAR(70)      |