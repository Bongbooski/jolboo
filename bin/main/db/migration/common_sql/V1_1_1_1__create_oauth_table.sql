CREATE TABLE oauth (
    `oauth_id` int(11) not null auto_increment,
    `issued_date` varchar(8) not null,
    `access_token` varchar(1000) not null,
    `expired_datetime` datetime not null,
    primary key (`oauth_id`)
)