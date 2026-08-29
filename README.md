# TPM Training Platform
Updated enterprise foundation for a shared Spring Boot, Vaadin, PostgreSQL and Telegram training platform.

## Implemented in this revision
- Database-backed user, role and permission model with BCrypt security service
- Complete baseline Flyway schema for organization, training lifecycle, schedules, attendance, scores, certifications, notifications, Telegram linking, imports, audit and settings
- Employee DTO/API layering with search, pagination and server-side permissions
- Real database-backed dashboard starter metrics
- Score and certification business-rule services with tests
- Secure Telegram link-token generation and hashing primitive
- Idempotent notification delivery queue primitive
- Safe Excel workbook validation/preview primitive
- Glassmorphism Vaadin shell, login, dashboard and employee list
- Docker, Railway health checks, CI and exact environment-variable documentation

## Important completion status
This is a materially repaired foundation, not a claim that every screen and workflow in the master prompt is production-complete. See `FINAL_REPORT.md` and `docs/FEATURE_MATRIX.md`.

## Local run
1. Install Java 21 and Maven 3.9+.
2. Copy `.env.example` to `.env` and provide local values.
3. Run `docker compose up -d db`.
4. Create the first administrator using a controlled SQL/bootstrap operation described in `docs/SECURITY.md`.
5. Run `mvn spring-boot:run`.
6. Open `http://localhost:8080`.

## Verification
Run `mvn verify` and `docker build -t tpm-training-platform .` on a Java 21 workstation or CI runner.
