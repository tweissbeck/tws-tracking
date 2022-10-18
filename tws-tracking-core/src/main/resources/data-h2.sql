insert into measure_unit(`measure_unit__id`, `measure_unit__name`, `measure_unit__symbol`) values
(1, 'Kilomètre', 'km'),
(2, 'Watt', 'w');

insert into counter(`counter__id`, `counter__name`, `counter__measure_unit`, `counter__periodicity`, `counter__start_date`) values
(1, 'Clio', 1, 'MONTHLY', '2022-01-01'),
(2, 'Honda', 1, 'MONTHLY', '2022-01-01');

insert into counter_data(  `counter_data__id`, `counter_data_value`, `counter_data__date`, `counter_data__counter_id`) values
(1, '0', '2022-01-01', 1),
(2, '507', '2022-02-01', 1),
(3, '507', '2022-03-01', 1),
(4, '0', '2022-01-01', 2),
(5, '18', '2022-01-02', 2),
(6, '25', '2022-01-02', 2)