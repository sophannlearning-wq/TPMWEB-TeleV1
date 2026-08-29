CREATE TABLE shifts(id UUID PRIMARY KEY DEFAULT gen_random_uuid(),code VARCHAR(50) NOT NULL UNIQUE,name VARCHAR(100) NOT NULL,active BOOLEAN NOT NULL DEFAULT TRUE);
CREATE TABLE locations(id UUID PRIMARY KEY DEFAULT gen_random_uuid(),code VARCHAR(50) NOT NULL UNIQUE,name VARCHAR(150) NOT NULL,active BOOLEAN NOT NULL DEFAULT TRUE);
ALTER TABLE employees ADD COLUMN join_date DATE;
ALTER TABLE training_sessions ADD COLUMN capacity INT CHECK(capacity IS NULL OR capacity>0);
CREATE TABLE follow_ups(id UUID PRIMARY KEY DEFAULT gen_random_uuid(),employee_id UUID NOT NULL REFERENCES employees(id),assignment_id UUID REFERENCES training_assignments(id),reason VARCHAR(50) NOT NULL,status VARCHAR(30) NOT NULL,assigned_to UUID REFERENCES employees(id),due_date DATE,created_at TIMESTAMPTZ NOT NULL DEFAULT now(),completed_at TIMESTAMPTZ);
CREATE TABLE job_executions(id UUID PRIMARY KEY DEFAULT gen_random_uuid(),job_name VARCHAR(100) NOT NULL,started_at TIMESTAMPTZ NOT NULL,finished_at TIMESTAMPTZ,status VARCHAR(30) NOT NULL,processed_count INT NOT NULL DEFAULT 0,error_reference VARCHAR(100));
CREATE INDEX idx_sessions_date_status ON training_sessions(session_date,status);
CREATE INDEX idx_attendance_employee ON attendance(employee_id);
CREATE INDEX idx_scores_employee ON scores(employee_id,score_date);
