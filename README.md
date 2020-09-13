# TinderAPI-SpringBoot-Hibernate

#API
- Get all matched person with a person's id (admin): GET /{id}/getAllMatch 
- Get account list (admin): GET /get
- Get random person for a person's id (user): GET /id
- Like a person (user): POST /{id}/like/{idTarget}
- Super like a person (user): POST /{id}/superLike/{idTarget}
- Login (user): GET /login?username=...&&password=...
- Sign in (user): POST /signin with an account entity in request body
- Update password (user): POST /updatePassword?id=...&&password=...
- Update information (user): POST /updateInfo?id=... with an person entity in request body

#Dependency
- Hibernate 5.3.7.Final
- MSSQL Driver 6.1.0.jre8
- JSON 20180130
- Spring boot newest version

