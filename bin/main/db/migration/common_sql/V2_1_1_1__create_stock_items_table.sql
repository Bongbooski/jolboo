CREATE TABLE stock_items (
    `stock_item_code` varchar(6) not null,
    `stock_item_name` varchar(100) not null,
    `stock_div` varchar(10) not null,
    primary key (`stock_item_code`)
)