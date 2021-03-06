//json de prueba
{
    "nombreUsuario": "TestRest",
    "edad": 31,
    "genero": "FEMENINO",
    "sigoVirgo": "N",
    "facha": "N",
    "versiones": [
        "V3",
        "V4",
        "V5",
        "V6"
    ]
}

{
    "id": 46,
    "nombreUsuario": "TestRestUpdate",
    "edad": 19,
    "genero": "FEMENINO",
    "sigoVirgo": "N",
    "facha": "N",
    "versiones": [
        "V3",
        "V4",
        "V5",
        "V6"
    ]
}

//



--codigo para seguridad en spring
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "TARINGA"."USERS" 
   (	"USERNAME" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE), 
	"ENABLED" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into TARINGA.USERS
SET DEFINE OFF;
Insert into TARINGA.USERS (USERNAME,PASSWORD,ENABLED) values ('radamanthys','{noop}test123',1);
Insert into TARINGA.USERS (USERNAME,PASSWORD,ENABLED) values ('toto32','{noop}test123',1);
Insert into TARINGA.USERS (USERNAME,PASSWORD,ENABLED) values ('facha','{noop}test123',1);
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TARINGA"."USERS_PK" ON "TARINGA"."USERS" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "TARINGA"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "TARINGA"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "TARINGA"."USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  
  --------------------------------------------------------
--  DDL for Table AUTHORITIES
--------------------------------------------------------

  CREATE TABLE "TARINGA"."AUTHORITIES" 
   (	"USERNAME" VARCHAR2(50 BYTE), 
	"AUTHORITY" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into TARINGA.AUTHORITIES
SET DEFINE OFF;
Insert into TARINGA.AUTHORITIES (USERNAME,AUTHORITY) values ('facha','ROLE_TARINGUERO');
Insert into TARINGA.AUTHORITIES (USERNAME,AUTHORITY) values ('facha','ROLE_VIRGO');
Insert into TARINGA.AUTHORITIES (USERNAME,AUTHORITY) values ('radamanthys','ROLE_ADMIN');
Insert into TARINGA.AUTHORITIES (USERNAME,AUTHORITY) values ('radamanthys','ROLE_VIRGO');
Insert into TARINGA.AUTHORITIES (USERNAME,AUTHORITY) values ('toto32','ROLE_PORINGUERO');
Insert into TARINGA.AUTHORITIES (USERNAME,AUTHORITY) values ('toto32','ROLE_VIRGO');
--------------------------------------------------------
--  DDL for Index AUTHORITIES_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "TARINGA"."AUTHORITIES_UK1" ON "TARINGA"."AUTHORITIES" ("USERNAME", "AUTHORITY") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table AUTHORITIES
--------------------------------------------------------

  ALTER TABLE "TARINGA"."AUTHORITIES" MODIFY ("AUTHORITY" NOT NULL ENABLE);
  ALTER TABLE "TARINGA"."AUTHORITIES" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "TARINGA"."AUTHORITIES" ADD CONSTRAINT "AUTHORITIES_UK1" UNIQUE ("USERNAME", "AUTHORITY")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table AUTHORITIES
--------------------------------------------------------

  ALTER TABLE "TARINGA"."AUTHORITIES" ADD CONSTRAINT "AUTHORITIES_FK1" FOREIGN KEY ("USERNAME")
	  REFERENCES "TARINGA"."USERS" ("USERNAME") ENABLE;
	  
--------------------------------------------------------
--  DDL for Table PERMISO_RECURSO
--------------------------------------------------------

  CREATE TABLE "TARINGA"."PERMISO_RECURSO" 
   (	"RECURSO" VARCHAR2(300 BYTE), 
	"AUTHORITIES" VARCHAR2(50 BYTE), 
	"CODIGO" NUMBER(15,0), 
	"ACTIVO" VARCHAR2(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into TARINGA.PERMISO_RECURSO
SET DEFINE OFF;
Insert into TARINGA.PERMISO_RECURSO (RECURSO,AUTHORITIES,CODIGO,ACTIVO) values ('/','VIRGO',5,'S');
Insert into TARINGA.PERMISO_RECURSO (RECURSO,AUTHORITIES,CODIGO,ACTIVO) values ('/taringuero/**','TARINGUERO',4,'N');
Insert into TARINGA.PERMISO_RECURSO (RECURSO,AUTHORITIES,CODIGO,ACTIVO) values ('/taringuero/**','ADMIN',3,'S');
Insert into TARINGA.PERMISO_RECURSO (RECURSO,AUTHORITIES,CODIGO,ACTIVO) values ('/poringuero/**','PORINGUERO',2,'S');
Insert into TARINGA.PERMISO_RECURSO (RECURSO,AUTHORITIES,CODIGO,ACTIVO) values ('/poringuero/**','ADMIN',1,'S');
Insert into TARINGA.PERMISO_RECURSO (RECURSO,AUTHORITIES,CODIGO,ACTIVO) values ('/taringuero/busquedaTabla','TARINGUERO',6,'S');
--------------------------------------------------------
--  DDL for Index PERMISO_RECURSO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TARINGA"."PERMISO_RECURSO_PK" ON "TARINGA"."PERMISO_RECURSO" ("CODIGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table PERMISO_RECURSO
--------------------------------------------------------

  ALTER TABLE "TARINGA"."PERMISO_RECURSO" MODIFY ("ACTIVO" NOT NULL ENABLE);
  ALTER TABLE "TARINGA"."PERMISO_RECURSO" ADD CONSTRAINT "PERMISO_RECURSO_PK" PRIMARY KEY ("CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "TARINGA"."PERMISO_RECURSO" MODIFY ("CODIGO" NOT NULL ENABLE);
  ALTER TABLE "TARINGA"."PERMISO_RECURSO" MODIFY ("AUTHORITIES" NOT NULL ENABLE);
  ALTER TABLE "TARINGA"."PERMISO_RECURSO" MODIFY ("RECURSO" NOT NULL ENABLE);


-- fin

SET SERVEROUTPUT ON;
DECLARE 
   a number(4);
BEGIN 
   FOR a in 1 .. 50 LOOP 
       INSERT INTO USUARIO (CODIGO, NOMBRE_USUARIO, FK_GENERO, SIGO_VIRGO, FACHA, EDAD) 
       VALUES (a, 'Usuario'||TO_CHAR(a), 'MASCULINO', 'S', 'S', (70-a));
    
       INSERT INTO USUARIO_VERSION (FK_USUARIO, FK_VERSION) 
                    VALUES (a, 'V4');
       INSERT INTO USUARIO_VERSION (FK_USUARIO, FK_VERSION) 
                    VALUES (a, 'V5');
       INSERT INTO USUARIO_VERSION (FK_USUARIO, FK_VERSION) 
                    VALUES (a, 'V6');
  END LOOP; 
END; 
/






CREATE TABLE "TARINGA"."GENERO" 
   (	"TIPO" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "GENERO_PK" PRIMARY KEY ("TIPO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
  
CREATE TABLE "TARINGA"."USUARIO" 
   (	"CODIGO" NUMBER(35,0) NOT NULL ENABLE, 
	"NOMBRE_USUARIO" VARCHAR2(25 BYTE) NOT NULL ENABLE, 
	"FK_GENERO" VARCHAR2(50 BYTE), 
	"SIGO_VIRGO" VARCHAR2(1 BYTE) NOT NULL ENABLE, 
	"FACHA" VARCHAR2(1 BYTE), 
	"EDAD" NUMBER(3,0), 
	 CONSTRAINT "USUARIO_PK" PRIMARY KEY ("CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 CONSTRAINT "USUARIO_FK1" FOREIGN KEY ("FK_GENERO")
	  REFERENCES "TARINGA"."GENERO" ("TIPO") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

  
CREATE TABLE "TARINGA"."USUARIO_VERSION" 
   (	"FK_USUARIO" NUMBER(35,0) NOT NULL ENABLE, 
	"FK_VERSION" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "USUARIO_VERSION_PK" PRIMARY KEY ("FK_USUARIO", "FK_VERSION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 CONSTRAINT "USUARIO_VERSION_FK1" FOREIGN KEY ("FK_VERSION")
	  REFERENCES "TARINGA"."VERSION" ("CODIGO") ENABLE, 
	 CONSTRAINT "USUARIO_VERSION_FK2" FOREIGN KEY ("FK_USUARIO")
	  REFERENCES "TARINGA"."USUARIO" ("CODIGO") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

 CREATE TABLE "TARINGA"."VERSION" 
   (	"CODIGO" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"DESCRIPCION" VARCHAR2(50 BYTE), 
	 CONSTRAINT "VERSION_PK" PRIMARY KEY ("CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
  