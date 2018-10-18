/* employee table*/
create table empram(
userName varchar2(20) not null primary key,
passWord varchar2(10) not null,
);





/* insurance Table*/
create table insuranceram(
carNumber varchar2(10) not null,
policyId number primary key,
policeType varchar2(20) not null,
policyAmount number check(policyAmount>0)
);

/*changed the one columnName*/

ALTER TABLE insuranceram
RENAME COLUMN policeType TO policyName;


/* customer Table*/
create table customerram(
customerId number primary key,
customerName varchar2(20) not null,
mobileNumber varchar2(15) 
);


/* car Table*/

create table carram(
carNumber varchar2(10) primary key,
carModel varchar2(10) ,
customerId number 
);

/* foreign key */
alter table carram add foreign key (customerId) references customerram (customerId);



/*Service Table*/
create table serviceram(
serviceId number primary key,
serviceType varchar2(30) not null,
serviceAmount number check(serviceAmount>0),
carNumber varchar2(10) not null
);





