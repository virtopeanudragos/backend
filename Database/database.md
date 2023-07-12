1. Student Table
Description: This table stores information about the students.
Columns:
id integer (Primary Key)
name varchar
email varchar
university varchar
team_id integer (Foreign Key referencing Team table)
leader boolean

2. Team Table
Description: This table stores information about the teams.
Columns:
id integer (Primary Key)
activity_id integer (Foreign Key referencing Activity table)

3. Activity Table
Description: This table stores information about the activities.
Columns:
id integer (Primary Key)
name varchar
description varchar

4. Mentor Table
Description: This table stores information about the mentors.
Columns:
Id integer (Primary Key)
Name varchar
Email varchar

5. Attendance Table
Description: This table stores information about the attendance of students in activities.
Columns:
id integer (Primary Key)
student_id integer (Foreign Key referencing Student table)
activity_id  integer (Foreign Key referencing Activity table)
date date
status boolean

6. Grade Table
Description: This table stores the grades of students, evaluated by mentors in a specific team.
Columns:
id integer (Primary Key)
student_id integer (Foreign Key referencing Student table)
team_id integer (Foreign Key referencing Team table)
mentor_id integer (Foreign Key referencing Mentor table)
grade float
comment varchar

7. Mentor_Team Table
Description: This table creates a many-to-many relationship between the mentors and teams. A mentor can be associated with multiple teams and a team can have multiple mentors.
Columns:
mentor_id integer (Foreign Key referencing Mentor table)
team_id integer (Foreign Key referencing Team table)

8. Team_Activity Table
Description: This table creates a many-to-many relationship between the teams and activities. An activity can be associated with multiple teams and a team can have multiple activities.
Columns:
team_id integer (Foreign Key referencing team table)
activity_id integer (Foreign Key referencing activity table)


Relations:

Student to Team: A student belongs to one team, while a team can have multiple students. This is a one-to-many relationship from Team to Student.

Team to Activity: A many-to-many relationship, where a team can participate in many activities and an activity can be associated with many teams. Managed via the Team_Activity table.

Attendance to Student: An attendance record belongs to one student, while a student can have many attendance records. This is a one-to-many relationship from Student to Attendance.

Grade to Team and Mentor: A grade is associated with one team and one mentor, while a team can have many grades and a mentor can assign many grades. This is a one-to-many relationship from Team to Grade and from Mentor to Grade.

Mentor to Team: A mentor can mentor many teams, and a team can have many mentors. This is a many-to-many relationship and would need a junction table, Mentor_Team, to manage this relationship.


