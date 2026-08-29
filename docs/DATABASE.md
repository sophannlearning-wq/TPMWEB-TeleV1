# Database
Flyway owns schema evolution. Hibernate runs in validate mode. Migrations V1 through V8 create RBAC, organization, courses, requirements, plans, assignments, sessions, attendance, scores, certifications, notifications, Telegram links/tokens, import history, audit and settings. Production must never use automatic create/drop. Review every migration in staging before production.
