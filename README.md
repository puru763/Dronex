
# DroneX 

A backend microservices system for managing drones, missions, and sites — built with Java, Spring Boot, and MongoDB.

---

## Architecture Overview

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│   User Service  │     │  Drone Service  │     │ Mission Service │
│  Register/Login │────▶│  Assign to Site │────▶│  Waypoints/Path │
└─────────────────┘     └─────────────────┘     └─────────────────┘
         │                       │                       │
         ▼                       ▼                       ▼
┌─────────────────┐     ┌─────────────────┐
│   Site Service  │     │Category Service │
│  Manage Locations│    │  Mission Groups │
└─────────────────┘     └─────────────────┘
         │
         ▼
┌─────────────────┐
│    MongoDB      │
│   (Database)    │
└─────────────────┘
```

---

## Services

### 1. User Service
Handles user registration, authentication, and profile management.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/users/register` | Register a new user |
| POST | `/users/login` | Login and get access token |
| GET | `/users/{id}` | Get user by ID |
| PUT | `/users/{id}` | Update user details |
| DELETE | `/users/{id}` | Delete user account |

---

### 2. Drone Service
Manages drones and their assignment to sites and users.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/drones` | Add a new drone |
| GET | `/drones/site/{siteId}` | Get all drones at a site |
| GET | `/drones/user/{userId}` | Get all drones by user |
| PUT | `/drones/{id}` | Update drone / reassign site |
| DELETE | `/drones/{id}` | Remove drone |

---

### 3. Mission Service
Creates and manages drone missions with waypoint-based paths.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/missions` | Create a new mission |
| GET | `/missions/site/{siteId}` | Get missions for a site |
| GET | `/missions/category/{categoryId}` | Get missions by category |
| PUT | `/missions/{id}` | Update mission details |
| DELETE | `/missions/{id}` | Delete a mission |

---

### 4. Site Service
Manages physical locations where drones are deployed.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/sites` | Add a new site |
| GET | `/sites/user/{userId}` | Get all sites by user |
| PUT | `/sites/{id}` | Update site details |
| DELETE | `/sites/{id}` | Delete a site |

---

### 5. Category Service
Groups missions into categories for better organization.

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/categories` | Add a new category |
| GET | `/categories/user/{userId}` | Get categories by user |
| PUT | `/categories/{id}` | Update category |
| DELETE | `/categories/{id}` | Delete category |

---

## Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java |
| Framework | Spring Boot |
| Database | MongoDB |
| Authentication | JWT |
| API Style | REST |
| Build Tool | Maven |

---

## Data Models

```
User
├── id
├── username (unique)
├── password (hashed)
├── droneIds[]
└── siteIds[]

Drone
├── id
├── name
├── siteId (ref → Site)
└── userId (ref → User)

Mission
├── id
├── siteId (ref → Site)
├── droneId (ref → Drone)
├── waypoints[] (geolocations)
└── categoryId (ref → Category)

Site
├── id
└── name

Category
├── id
└── name
```

---

## How to Run

```bash
# Clone the repository
git clone https://github.com/puru763/dronex

# Navigate to project
cd dronex

# Run with Maven
mvn spring-boot:run
```

Make sure MongoDB is running locally on port `27017` before starting the application.

---

## Key Design Decisions

- **MongoDB** used for flexible geolocation storage in mission waypoints
- **JWT-based auth** for stateless user session management
- **Service-Repository pattern** maintained across all 5 services
- **Foreign key references** between Drone → Site → User for clean ownership model
- Mission site **cannot be changed** after creation to maintain data integrity

---

## Author

**Purvesh Krishnani**
[linkedin.com/in/purvesh15](https://linkedin.com/in/purvesh15) • [github.com/puru763](https://github.com/puru763)
