insert into patient(name, gender, age, height, contact)
values ('Noah Harith bin Hazman', 'Male', 35, 170, '017-2467989');

insert into patient(name, gender, age, height, contact)
values ('Lee Xiu Ying', 'Female', 40, 155, '019-3897544');

insert into patient(name, gender, age, height, contact)
values ('Arjun A/L Vikram', 'Male', 23, 180, '013-6833878');


insert into health_data(timestamp, temperature, bmi, weight, heart_rate, systolic, diastolic, glucose_level, hdl, ldl, triglycerides, total)
values ('2024-04-20 08:25:05', 37.2, 22.5, 60.0, 80, 140, 90, 80.0, 50.0, 100.0, 30.0, 180.0);

insert into health_data(timestamp, temperature, bmi, weight, heart_rate, systolic, diastolic, glucose_level, hdl, ldl, triglycerides, total)
values ('2024-04-21 09:15:35', 36.8, 27.7, 43.0, 75, 140, 80, 180.0, 60.0, 80.0, 60.0, 200.0);

insert into health_data(timestamp, temperature, bmi, weight, heart_rate, systolic, diastolic, glucose_level, hdl, ldl, triglycerides, total)
values ('2024-04-22 14:45:20', 37.5, 32.1, 100.0, 85, 120, 80, 95.0, 35.0, 150.0, 70.0, 240.0);

update health_data set patient_Id = 1
where data_id = 1;

update health_data set patient_Id = 2
where data_id = 2;

update health_data set patient_Id = 3
where data_id = 3;

