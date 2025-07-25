-- Ensure the 'patient' table exists
CREATE TABLE
  IF NOT EXISTS patient (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    date_of_birth DATE NOT NULL,
    registered_date DATE NOT NULL
  );

-- Insert well-known UUIDs for specific patients
INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '123e4567-e89b-12d3-a456-426614174000',
  'John Doe',
  'john.doe@example.com',
  '123 Main St, Springfield',
  '555-1234-555-1234',
  '1985-06-15',
  '2024-01-10'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '123e4567-e89b-12d3-a456-426614174000'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '123e4567-e89b-12d3-a456-426614174001',
  'Jane Smith',
  'jane.smith@example.com',
  '456 Elm St, Shelbyville',
  '555-5678-555-5678',
  '1990-09-23',
  '2023-12-01'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '123e4567-e89b-12d3-a456-426614174001'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '123e4567-e89b-12d3-a456-426614174002',
  'Alice Johnson',
  'alice.johnson@example.com',
  '789 Oak St, Capital City',
  '555-8765-555-8765',
  '1978-03-12',
  '2022-06-20'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '123e4567-e89b-12d3-a456-426614174002'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '123e4567-e89b-12d3-a456-426614174003',
  'Bob Brown',
  'bob.brown@example.com',
  '321 Pine St, Springfield',
  '555-4321-555-4321',
  '1982-11-30',
  '2023-05-14'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '123e4567-e89b-12d3-a456-426614174003'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '123e4567-e89b-12d3-a456-426614174004',
  'Emily Davis',
  'emily.davis@example.com',
  '654 Maple St, Shelbyville',
  '555-6789-555-6789',
  '1995-02-05',
  '2024-03-01'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '123e4567-e89b-12d3-a456-426614174004'
  );

-- Insert well-known UUIDs for specific patients
INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174005',
  'Michael Green',
  'michael.green@example.com',
  '987 Cedar St, Springfield',
  '555-9876-555-9876',
  '1988-07-25',
  '2024-02-15'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174005'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174006',
  'Sarah Taylor',
  'sarah.taylor@example.com',
  '123 Birch St, Shelbyville',
  '555-6543-555-6543',
  '1992-04-18',
  '2023-08-25'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174006'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174007',
  'David Wilson',
  'david.wilson@example.com',
  '456 Ash St, Capital City',
  '555-3210-555-3210',
  '1975-01-11',
  '2022-10-10'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174007'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174008',
  'Laura White',
  'laura.white@example.com',
  '789 Palm St, Springfield',
  '555-2109-555-2109',
  '1989-09-02',
  '2024-04-20'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174008'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174009',
  'James Harris',
  'james.harris@example.com',
  '321 Cherry St, Shelbyville',
  '555-1098-555-1098',
  '1993-11-15',
  '2023-06-30'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174009'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174010',
  'Emma Moore',
  'emma.moore@example.com',
  '654 Spruce St, Capital City',
  '555-0987-555-0987',
  '1980-08-09',
  '2023-01-22'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174010'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174011',
  'Ethan Martinez',
  'ethan.martinez@example.com',
  '987 Redwood St, Springfield',
  '555-9870-555-9870',
  '1984-05-03',
  '2024-05-12'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174011'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174012',
  'Sophia Clark',
  'sophia.clark@example.com',
  '123 Hickory St, Shelbyville',
  '555-8760-555-8760',
  '1991-12-25',
  '2022-11-11'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174012'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174013',
  'Daniel Lewis',
  'daniel.lewis@example.com',
  '456 Cypress St, Capital City',
  '555-7650-555-7650',
  '1976-06-08',
  '2023-09-19'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174013'
  );

INSERT INTO
  patient (
    id,
    name,
    email,
    address,
    phone_number,
    date_of_birth,
    registered_date
  )
SELECT
  '223e4567-e89b-12d3-a456-426614174014',
  'Isabella Walker',
  'isabella.walker@example.com',
  '789 Willow St, Springfield',
  '555-6540-555-6540',
  '1987-10-17',
  '2024-03-29'
WHERE
  NOT EXISTS (
    SELECT
      1
    FROM
      patient
    WHERE
      id = '223e4567-e89b-12d3-a456-426614174014'
  );