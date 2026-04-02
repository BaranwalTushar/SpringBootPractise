DELETE FROM patient;

INSERT INTO patient (name, birth_date, email, gender, blood_group)
VALUES
    ('Tushar', '2000-05-10', 'tushar@gmail.com', 'Male', 'A_Positive'),
    ('Ankit', '1999-08-15', 'ankit@gmail.com', 'Male', 'B_Positive'),
    ('Priya', '2001-02-20', 'priya@gmail.com', 'Female', 'O_Negative'),
    ('Neha', '1998-11-30', 'neha@gmail.com', 'Female', 'AB_Positive'),
    ('Rahul', '2000-07-25', 'rahul@gmail.com', 'Male', 'O_Positive');


INSERT INTO doctor (name, specialization, email) VALUES
                                                     ('Dr. Amit Sharma', 'Cardiologist', 'amit.sharma@gmail.com'),
                                                     ('Dr. Neha Verma', 'Dermatologist', 'neha.verma@gmail.com'),
                                                     ('Dr. Rajesh Gupta', 'Orthopedic', 'rajesh.gupta@gmail.com');



INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id) VALUES
                                                                              ('2025-11-01 10:00:00', 'Fever', 1, 2),
                                                                              ('2025-11-02 11:00:00', 'Cold', 1, 2),
                                                                              ('2025-11-03 12:00:00', 'Checkup', 1, 2),
                                                                              ('2025-11-04 13:00:00', 'Headache', 1, 2),
                                                                              ('2025-11-05 14:00:00', 'General Visit', 1, 2);