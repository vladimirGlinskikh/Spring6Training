drop table if exists beer_order_line;
drop table if exists beer_order;

CREATE TABLE beer_order
(
    id                 varchar(36) not null,
    created_date       datetime(6)  default null,
    customer_ref       varchar(255) default null,
    last_modified_date datetime(6)  default null,
    version            bigint       default null,
    customer_id        varchar(36)  default null,
    primary key (id),
    constraint foreign key (customer_id) references customer (id)
) ENGINE = InnoDB;

CREATE TABLE beer_order_line
(
    id                 varchar(36) not null,
    beer_id            varchar(36) default null,
    created_date       datetime(6) default null,
    last_modified_date datetime(6) default null,
    order_quantity     int         default null,
    quantity_allocated int         default null,
    version            bigint      default null,
    beer_order_id      varchar(36) default null,
    primary key (id),
    constraint foreign key (beer_order_id) references beer_order (id),
    constraint foreign key (beer_id) references beer (id)
) ENGINE = InnoDB;