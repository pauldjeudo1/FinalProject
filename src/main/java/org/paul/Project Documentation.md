# **Final Project Documentation**
### *Paul Djeudo - 2586403*
## Project Purpose

This project is a student management system made to
simulate how a college might manage students, departments,
and grades in a structured and object-oriented way.

The system allows:

- Creation of departments
- Management of students and their personal information(such as gender, address, student ID, etc.)
- Creation of courses linked to departments
- Registration and dropping of students from courses
- Management of assignments, scores and weighted averages
- Ensuring data consistency between students, courses and assignments

JUnit tests are equally included to verify the correctness and reliability of the system's logic.

## **Class Descriptions**

### `Student`
Represents a student enrolled at the institution.

**Responsibilities:**

- Stores personal information (name, gender, address)
- Tracks the student’s department
- Can register and drop courses
- Maintains consistency between students and courses


### `Course`
Represents a course offered by a department.

**Responsibilities:**

- Stores course information (name, credits, department)
- Manages registered students
- Manages assignments and their weights
- Calculates final weighted averages for students

### `Assignment`
Represents an assignment within a course.

**Responsibilities:**

- Stores an assignment's name, weight and student scores
- Calculates assignment averages
- Generate random scores for simulation

### `Address`
Represents a student’s physical address.

**Responsibilities:**

- Store street number, street name, city, province, and postal code
- Validate postal codes using Canadian postal code rules (letter–digit pattern)
- Prevent invalid addresses from being created

### `Department`
Represents an academic department (e.g., Computer Science, Health Science).

**Responsibilities:**

- Store a department’s name and unique ID
- Validate department names (letters and spaces only)
- Automatically generate department IDs

### `Util`
A utility/helper class.

**Responsibilities:**

- Converts strings to title case