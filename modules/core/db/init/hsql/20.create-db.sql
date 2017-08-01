-- begin DEMO_ORDER
alter table DEMO_ORDER add constraint FK_DEMO_ORDER_CLIENT foreign key (CLIENT_ID) references DEMO_CLIENT(ID)^
create index IDX_DEMO_ORDER_CLIENT on DEMO_ORDER (CLIENT_ID)^
-- end DEMO_ORDER
