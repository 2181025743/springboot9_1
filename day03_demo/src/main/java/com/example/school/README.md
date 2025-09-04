# school-demo (embedded README)

This Spring Boot project demonstrates:
- Loading teacher and students information from YAML (`application.yml`).
- Multi-environment configuration via Spring profiles (`test`, `dev`, `prod`) with different `server.port` and `school.communityProgram` values.
- Controller endpoints to:
  - `/teacher` : return teacher info.
  - `/students/averages` : return each student's 3-subject average (rounded to 2 decimals).
  - `/students/chinese-average` : return overall Chinese (语文) average across students.
  - `/community-program` : return the community program string for the current environment.

Default active profile: `test` (port 8080). To run with another profile:
- `-Dspring.profiles.active=dev` for development (port 8081)
- `-Dspring.profiles.active=prod` for production (port 8082)

Build and run:
- `mvn package`
- `java -jar target/school-demo-0.0.1-SNAPSHOT.jar`
  (optionally add `-Dspring.profiles.active=dev` to choose profile)