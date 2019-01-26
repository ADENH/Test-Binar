# Test-Binar

Aplikasi menggunakan bahasa java dengan IDE eclipse JEE dan menggunakan framework springboot, 
lalu untuk database menggunakan postgresql.

cara menggunakan aplikasi ini, pada eclipse  file->import->maven->existing maven project

lalu jalankan aplikasi ini.

aplikasi ini bisa CRUD, signup dan login.Untuk CRUD sndiri baru bisa dilakukan ketika menggunakan token, token didapatkan dengan login, namun login kali ini menggunakan data static. 
Pada postman param diisi:

grant_type  password
username    john
password    123

Basic Auth :

username  123
password  123

Nantinya akan mendapatkan access_token yang akan digunakan untuk CRUD, setelah itu ketika melakukan CRUD
pada paramnya juga diisi dengan access_token.

Untuk akses database dapat dilihat configurasinya pada aplication.properties

spring.datasource.url=jdbc:postgresql:Test-Binar
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update

URL yang bisa di akses
1. localhost:8080/v1/products/?access_token=*       -> get,post
2. localhost:8080/v1/products/{id}?access_token=*   -> delete,put,get
3. localhost:8080/v2/products/?access_token=*        -> get
4. localhost:8080/oauth/token?grant_type=password&username=john&password=123  -> post (require basic auth)
5. localhost:8080/auth/signup       -> post
