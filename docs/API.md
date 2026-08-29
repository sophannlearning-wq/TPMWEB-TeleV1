# API
Implemented employee API: `GET /api/v1/employees`, `GET /api/v1/employees/{id}`, `POST /api/v1/employees`, `DELETE /api/v1/employees/{id}`. Request and response DTOs prevent JPA exposure. Server-side authorities are enforced. Remaining resources must follow the same controller-service-repository pattern.
