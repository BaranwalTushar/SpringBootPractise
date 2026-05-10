DELETE FROM appointment;
DELETE FROM patient;
DELETE FROM doctor;
DELETE FROM users;

INSERT INTO users (id, username, password)
VALUES
    (1, 'doctor1', '123'),
    (2, 'patient1', '123');


INSERT INTO patient
(user_id, name, birth_date, email, gender, blood_group)
VALUES

    (2, 'Ankit', '1999-08-15', 'ankit@gmail.com', 'Male', 'B_Positive');

INSERT INTO doctor (user_id,name, specialization, email) VALUES
    (1, 'Dr. Amit Sharma', 'Cardiologist', 'amit.sharma@gmail.com');



INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id) VALUES
                                                                              ('2025-11-01 10:00:00', 'Fever', 1, 2),
                                                                              ('2025-11-02 11:00:00', 'Cold', 1, 2),
                                                                              ('2025-11-03 12:00:00', 'Checkup', 1, 2);