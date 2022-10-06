CREATE TABLE stock_price (
    `stock_item_code` varchar(6) not null,
    `trade_date` varchar(6) not null,
    `open` int null,
    `high` int null,
    `low` int null,
    `close` int null,
    `volume` int null,
    primary key (`stock_item_code`, `trade_date`)
)