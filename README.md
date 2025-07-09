# Java EE Department Management System with EJB and REST Services

This project implements a Java EE enterprise application for managing departments through EJB (Enterprise JavaBeans) and REST services. It provides a scalable, multi-tier architecture that separates business logic, data access, and presentation layers using Java EE 7 technologies.

The system offers department management capabilities through both REST APIs and JSF web interface. It leverages JPA for data persistence, EJB for business logic, and JAX-RS for RESTful services. The application demonstrates enterprise Java best practices including dependency injection, transaction management, and separation of concerns.

## Repository Structure
```
eafirstear/                 # Enterprise Application (EAR) module
├── pom.xml                 # EAR project configuration and dependencies
eafirstejb/                 # EJB module containing business logic
├── src/main/java/         
│   └── eafirstejb/        # EJB components and domain classes
│       ├── DepartmentService.java    # Core business logic for department management
│       └── domain/
│           └── Department.java       # JPA entity for department data
└── src/main/resources/    
    └── META-INF/          # JPA and EJB configuration files
eafirstweb/                # Web module with REST and JSF interfaces
├── src/main/java/
│   └── eafirstweb/
│       ├── managedbeans/  # JSF managed beans
│       └── rest/          # REST service endpoints
└── webapp/                # Web resources and configuration
```

## Usage Instructions
### Prerequisites
- Java Development Kit (JDK) 7 or higher
- Maven 3.1 or higher
- GlassFish Server 4.0 or higher
- A compatible database server (configured with JNDI name "jdbc/hr")

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd <repository-directory>
```

2. Build the project:
```bash
mvn clean install
```

3. Deploy to GlassFish:
```bash
asadmin deploy eafirstear/target/eafirstear-0.0.1-SNAPSHOT.ear
```

### Quick Start

1. Access the REST API:
```bash
# Get all departments
curl http://localhost:8080/eafirstweb/rest/dept

# Add a new department
curl -X POST -d "name=Engineering" http://localhost:8080/eafirstweb/rest/dept

# Get department by ID
curl http://localhost:8080/eafirstweb/rest/dept/1
```

2. Access the web interface:
- Open a browser and navigate to: `http://localhost:8080/eafirstweb/faces/index.html`

### More Detailed Examples

1. Creating a Department using EJB:
```java
@EJB
private DepartmentService departmentService;

// Save a new department
departmentService.save("Research");

// Retrieve all departments
List<Department> departments = departmentService.getAllDepartments();
```

2. Using the REST API:
```java
// GET all departments
GET /eafirstweb/rest/dept
Response: [{"deptId":1,"name":"Engineering"},{"deptId":2,"name":"Research"}]

// POST new department
POST /eafirstweb/rest/dept
Form parameters: name=Marketing
```

### Troubleshooting

Common Issues:
1. Database Connection Issues
   - Error: "Cannot connect to jdbc/hr"
   - Solution: Verify GlassFish JDBC resource configuration
   - Check: `asadmin list-jdbc-resources`

2. Deployment Failures
   - Error: "javax.ejb.EJBException"
   - Enable debug logging in GlassFish:
     ```bash
     asadmin set-log-levels javax.enterprise.system.container.ejb=FINEST
     ```
   - Check server.log at: `<glassfish-home>/domains/domain1/logs/server.log`

## Data Flow
The application follows a three-tier architecture where data flows from the web layer through EJB to the persistence layer.

```ascii
[Web Browser] <-> [REST/JSF Layer] <-> [EJB Service Layer] <-> [JPA/Database]
     |                |                        |                      |
     +----------------+------------------------+----------------------+
            HTTP               Local EJB            JDBC/JPA
```

Component Interactions:
1. Client requests arrive via REST endpoints or JSF pages
2. Requests are delegated to EJB service layer (DepartmentService)
3. EJB handles transaction management and business logic
4. JPA manages entity lifecycle and database operations
5. Results are transformed to JSON/HTML for client response
6. All database operations are executed within JTA transactions
7. Entity state changes are automatically synchronized with database