# Courses API

REST API for managing courses, built with Spring Boot.

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker Compose
- Maven
- Lombok

## Features

- Create courses
- List all courses
- Filter courses by `name` and/or `category`
- Find course by ID
- Update course `name` and/or `category`
- Delete course
- Toggle course `active` status

## Running the project

Clone the repository:

```bash
git clone https://github.com/VitorMozer9/courses-api.git
```

Enter the project folder:

```bash
cd courses-api
```

Create a `.env` file in the project root:

```env
POSTGRES_DB=course_api
POSTGRES_USER=your_user
POSTGRES_PASSWORD=your_password
```

Start PostgreSQL with Docker Compose:

```bash
docker compose up -d
```

Run the application:

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

## Environment Variables

```env
POSTGRES_DB=course_api
POSTGRES_USER=your_user
POSTGRES_PASSWORD=your_password
```

## API Endpoints

### Create course

```http
POST /courses/
```

Request body:

```json
{
  "name": "Java Spring Boot",
  "category": "Backend",
  "active": true
}
```

### List courses

```http
GET /courses
```

Optional filters:

```http
GET /courses?name=Java
GET /courses?category=Backend
GET /courses?name=Java&category=Backend
```

### Find course by ID

```http
GET /courses/{id}
```

Example:

```http
GET /courses/550e8400-e29b-41d4-a716-446655440000
```

### Update course

```http
PUT /courses/{id}
```

Request body:

```json
{
  "name": "Advanced Spring Boot",
  "category": "Backend"
}
```

You can also send only one field:

```json
{
  "name": "Advanced Spring Boot"
}
```

or:

```json
{
  "category": "Backend"
}
```

### Delete course

```http
DELETE /courses/{id}
```

Success response:

```http
204 No Content
```

### Toggle active status

```http
PATCH /courses/{id}/active
```

This endpoint switches the current `active` value:

```text
true -> false
false -> true
```

No request body is required.

## Example Response

```json
{
  "idCourse": "550e8400-e29b-41d4-a716-446655440000",
  "name": "Java Spring Boot",
  "category": "Backend",
  "active": true,
  "createdAt": "2026-06-05T10:00:00",
  "updatedAt": "2026-06-05T10:00:00"
}
```

## Security Note

Do not commit real database credentials.

Add `.env` to `.gitignore`:

```gitignore
.env
```

You can keep an example file:

```env
POSTGRES_DB=course_api
POSTGRES_USER=change_me
POSTGRES_PASSWORD=change_me
```

Suggested filename:

```text
.env.example
```

## Author

Developed by [Vitor Mozer](https://github.com/VitorMozer9).
