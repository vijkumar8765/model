--------------------------------------------------------
--  DDL for Table APP_LND_PRCL
--------------------------------------------------------

  insert into "D608411DEV"."APP_LND_PRCL" 
   (
	"APPLICATION_ID", 
	"LPIS_LND_PRCL_ID", 
	"PRCL_ID", 
	"DIGITISED_AREA", 
	"IS_PERM_FLAG", 
	"LOCATION_ID", 
	"APP_LND_PRCL_ALIAS", 
	"IS_VERIFIED_FLAG", 
	"IS_CONFIRMED_FLAG", 
	"IS_REMOVED_FLAG", 
	"LAST_UPDATED_DATE", 
	"LAST_UPDATED_BY", 
	"JPA_VERSION_NUMBER"
   ) 
   
   values (
		"APPLICATION_ID" NUMBER(38,0), 
		3, "LPIS_LND_PRCL_ID" NUMBER(38,0), 
		'11/22/333', -- "PRCL_ID" VARCHAR2(250 BYTE), 
		5.6, -- "DIGITISED_AREA" NUMBER(38,4), 
		'0', "IS_PERM_FLAG" NUMBER(1,0), 
		8, -- "LOCATION_ID" NUMBER(38,0), 
		'bad drainage', -- "APP_LND_PRCL_ALIAS" VARCHAR2(100 BYTE), 
		1, -- "IS_VERIFIED_FLAG" NUMBER(1,0), 
		1, -- "IS_CONFIRMED_FLAG" NUMBER(1,0), 
		0, -- "IS_REMOVED_FLAG" NUMBER(1,0), 
		SYSDATE, -- "LAST_UPDATED_DATE" DATE DEFAULT SYSDATE, 
		5, --"LAST_UPDATED_BY" NUMBER(38,0), 
		1 -- "JPA_VERSION_NUMBER" NUMBER(38,0) DEFAULT 1
   )