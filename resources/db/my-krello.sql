create table krl_board
(
    brd_id         int unsigned auto_increment
        primary key,
    brd_name       varchar(100)                         not null,
    brd_created_at datetime default current_timestamp() not null,
    brd_updated_at datetime                             null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table krl_column
(
    clm_id         int unsigned auto_increment
        primary key,
    clm_name       varchar(100)                         not null,
    clm_created_at datetime default current_timestamp() null,
    clm_updated_at datetime                             null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table krl_column_for_board
(
    cfb_id         int unsigned auto_increment
        primary key,
    brd_id_board   int unsigned                         not null,
    clm_id_column  int unsigned                         not null,
    cfb_created_at datetime default current_timestamp() not null,
    cfb_updated_at datetime                             null,
    constraint krl_column_for_board_brd_id_board_clm_id_column_Idx
        unique (brd_id_board, clm_id_column),
    constraint fk_krl_column_for_board_krl_board
        foreign key (brd_id_board) references krl_board (brd_id),
    constraint fk_krl_column_for_board_krl_column
        foreign key (clm_id_column) references krl_column (clm_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create index krl_column_for_board_brd_id_board_Idx
    on krl_column_for_board (brd_id_board);

create index krl_column_for_board_clm_id_column_Idx
    on krl_column_for_board (clm_id_column);

create table krl_task
(
    tsk_id            int unsigned auto_increment
        primary key,
    clm_id_column     int unsigned                         not null,
    brd_id_board      int unsigned                         not null,
    tsk_name          varchar(100)                         not null,
    tsk_description   varchar(2000)                        null,
    tsk_delivery_date datetime                             null,
    tsk_created_at    datetime default current_timestamp() not null,
    tsk_updated_at    datetime                             null,
    constraint fk_krl_task_krl_board
        foreign key (brd_id_board) references krl_board (brd_id),
    constraint fk_krl_task_krl_column
        foreign key (clm_id_column) references krl_column (clm_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table krl_log
(
    log_id          int unsigned auto_increment
        primary key,
    tsk_id_task     int unsigned                         not null,
    clm_id_previous int unsigned                         not null,
    clm_id_current  int unsigned                         not null,
    log_created_at  datetime default current_timestamp() not null,
    constraint fk_krl_log_krl_column_current
        foreign key (clm_id_current) references krl_column (clm_id),
    constraint fk_krl_log_krl_column_previous
        foreign key (clm_id_previous) references krl_column (clm_id),
    constraint fk_krl_log_krl_task
        foreign key (tsk_id_task) references krl_task (tsk_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create index krl_log_clm_id_current_Idx
    on krl_log (clm_id_current);

create index krl_log_clm_id_previous_Idx
    on krl_log (clm_id_previous);

create index krl_log_tsk_id_task_Idx
    on krl_log (tsk_id_task);

create index krl_task_brd_id_Idx
    on krl_task (brd_id_board);

create index krl_task_clm_id_Idx
    on krl_task (clm_id_column);

create index krl_task_clm_id_brd_id_Idx
    on krl_task (clm_id_column, brd_id_board);

insert into krl_board (brd_name) values ("Tablero de pruebas");
insert into krl_column (clm_name)
    values ("Por realizar"), ("En progreso"), ("Terminado");
insert into krl_column_for_board (brd_id_board, clm_id_column)
    values (1, 1), (1, 2), (1, 3);
insert into krl_task (clm_id_column, brd_id_board, tsk_name, tsk_description, tsk_delivery_date)
    values (2, 1, "Crear el frontend", "Es necesario crear primero el frontend", "2022-07-27 23:59:59"),
           (1, 1, "Crear el backend del Reto de Programación Web", null, "2022-07-28 23:59:59"),
           (1, 1, "Realizar las prubas unitarias al backend", null, "2022-07-29 23:59:59"),
           (3, 1, "Esto es un ejemplo de tarea terminada", null, null);
