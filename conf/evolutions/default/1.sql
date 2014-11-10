# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table animal (
  id                        bigint not null,
  identificacao             varchar(255),
  nome                      varchar(255),
  ativo                     boolean,
  em_lactacao               boolean,
  nascido_na_propriedade    boolean,
  informacoes               varchar(255),
  raca_id                   bigint,
  constraint pk_animal primary key (id))
;

create table pesagem (
  id                        bigint not null,
  peso                      double,
  animal_id                 bigint,
  constraint pk_pesagem primary key (id))
;

create table raca (
  id                        bigint not null,
  nome                      varchar(255),
  constraint pk_raca primary key (id))
;

create sequence animal_seq;

create sequence pesagem_seq;

create sequence raca_seq;

alter table animal add constraint fk_animal_raca_1 foreign key (raca_id) references raca (id) on delete restrict on update restrict;
create index ix_animal_raca_1 on animal (raca_id);
alter table pesagem add constraint fk_pesagem_animal_2 foreign key (animal_id) references animal (id) on delete restrict on update restrict;
create index ix_pesagem_animal_2 on pesagem (animal_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists animal;

drop table if exists pesagem;

drop table if exists raca;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists animal_seq;

drop sequence if exists pesagem_seq;

drop sequence if exists raca_seq;

