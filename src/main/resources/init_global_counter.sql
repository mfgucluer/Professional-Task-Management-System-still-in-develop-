-- First create the global counter table if it doesn't exist
CREATE TABLE IF NOT EXISTS taskmanagement.global_task_counter (
    id SERIAL PRIMARY KEY,
    counter_value INTEGER DEFAULT 0,
    counter_name VARCHAR(50) UNIQUE NOT NULL
);

-- Then insert the initial global counter if it doesn't exist yet
INSERT INTO taskmanagement.global_task_counter (counter_value, counter_name)
SELECT 0, 'GLOBAL_COUNTER'
WHERE NOT EXISTS (
    SELECT 1 FROM taskmanagement.global_task_counter WHERE counter_name = 'GLOBAL_COUNTER'
);

-- We can remove the task_counter field from the user table since it's no longer needed
-- ALTER TABLE taskmanagement.user DROP COLUMN IF EXISTS task_counter;
-- (Or you can keep the column but it won't be used anymore) 