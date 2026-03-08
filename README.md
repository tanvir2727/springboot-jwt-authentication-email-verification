# springboot-jwt-authentication-email-verification
A secure authentication system built with Spring Boot, implementing JWT-based authentication, email verification after user registration, and password reset via email. The project demonstrates best practices for building a modern RESTful authentication service with Spring Security, JWT tokens, and MySQL database integration.

## ✨ Features

- 🆕 **User Registration** with email verification (OTP)
- 🔐 **Secure Login** → returns **Access Token** + **Refresh Token**
- 🔄 **Refresh Token** mechanism to get new access token
- 🔑 **Forgot Password** → sends OTP to email
- 🔄 **Reset Password** after OTP verification
- 👥 **Role-based Authorization** (ADMIN, USER, etc.)
- 🔒 Passwords encrypted with **BCrypt**
- 📧 **Email sending** using **JavaMailSender** (Gmail, etc.)
- 📄 **Swagger OpenAPI** documentation
- 🛡️ Global exception handling
- 🗄️ MySQL + **Spring Data JPA**
- ♻️ Clean layered architecture (Controller → Service → Repository)

## 🛠 Tech Stack

| Technology              | Version / Purpose                          |
|-------------------------|--------------------------------------------|
| Java                    | 17                                         |
| Spring Boot             | 3.x                                        |
| Spring Security         | 6.x                                        |
| JWT                     | jjwt                                       |
| Spring Data JPA         | Hibernate                                  |
| Database                | MySQL                                      |
| Email                   | JavaMailSender (SMTP)                      |
| OTP caching             | Caffeine (or similar)                      |
| Documentation           | springdoc-openapi (Swagger UI)             |
| Lombok                  | Boilerplate reduction                      |

## 📂 Project Structure

```text
src/main/java/com/example/demo
├── DemoJwtAuthApplication.java
├── configuration
│   ├── ApplicationConfiguration.java
│   ├── CaffeineCacheConfig.java
│   ├── MailConfiguration.java
│   ├── MvcConfig.java
│   └── OpenAPIConfig.java
├── constants
│   └── ApplicationConstants.java
├── controller
│   ├── AuthenticationController.java
│   └── ProfileController.java
├── exception
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── model
│   ├── User.java
│   ├── Role.java (enum)
│   ├── Gender.java (enum)
│   └── Images.java
├── payload
│   ├── request
│   │   ├── LoginRequest.java
│   │   ├── RegisterRequest.java
│   │   ├── RegisterVerifyRequest.java
│   │   ├── ForgotPasswordRequest.java
│   │   └── ResetPasswordRequest.java
│   └── response
│       ├── GeneralAPIResponse.java
│       ├── RegisterResponse.java
│       ├── RefreshTokenResponse.java
│       └── UserProfile.java
├── repository
│   └── UserRepository.java
├── security
│   ├── JwtAuthenticationEntryPoint.java
│   ├── JwtAuthenticationFilter.java
│   ├── JwtHelper.java / JwtService.java
│   └── SecurityConfiguration.java
├── service
│   ├── AuthenticationService.java (+ Impl)
│   ├── EmailService.java
│   ├── OtpService.java
│   └── ...
└── util
```
    

🏗 **System Architecture**
```text
Client
   │
   ▼
REST API Controller
   │
   ▼
Spring Security Filter
   │
   ▼
JWT Authentication Filter
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
MySQL Database
```


📑 **API Endpoints**
🔐 **Authentication APIs**
| Method | Endpoint                       | Description               |
| ------ | ------------------------------ | ------------------------- |
| POST   | `/api/v1/auth/register`        | Register a new user       |
| POST   | `/api/v1/auth/verify`          | Verify user registration  |
| POST   | `/api/v1/auth/verify-otp`      | Verify OTP                |
| POST   | `/api/v1/auth/login`           | Login user                |
| POST   | `/api/v1/auth/send-otp`        | Forgot password           |
| POST   | `/api/v1/auth/reset-password`  | Reset password            |
| GET    | `/api/v1/auth/getRefreshToken` | Generate new access token |
| POST   | `/api/v1/auth/hello`           | Test secured endpoint     |

👤 **Profile APIs**
| Method | Endpoint                    | Description                |
| ------ | --------------------------- | -------------------------- |
| POST   | `/api/v1/profile/myProfile` | Get logged in user profile |


📖 **Swagger API Documentation**
Swagger UI is available at: 
http://localhost:8080/swagger-ui.html 
or 
http://localhost:8080/swagger-ui/index.html

📧 **Email Verification Flow**
```text
User Register
     │
     ▼
OTP Sent to Email
     │
     ▼
Verify OTP
     │
     ▼
Account Activated
```

🔑 **Authentication Flow**
```text
User Login
    │
    ▼
JWT Access Token Generated
    │
    ▼
Client Sends Token in Header
    │
    ▼
Spring Security Validates Token
```

 🏗 **System Architecture**
```text
Client
   │
   ▼
REST API Controller
   │
   ▼
Spring Security Filter
   │
   ▼
JWT Authentication Filter
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
MySQL Database
```

## ⚙️ Installation & Setup

1️⃣ **Clone the repository**

git clone https://github.com/your-username/springboot-jwt-authentication.git

2️⃣ **Configure MySQL**

spring.datasource.url=jdbc:mysql://localhost:3306/jwt_auth

spring.datasource.username=root

spring.datasource.password=password

3️⃣ **Configure Mail**

spring.mail.host=smtp.gmail.com

spring.mail.port=587

spring.mail.username=your-email@gmail.com

spring.mail.password=your-app-password

spring.mail.properties.mail.smtp.auth=true

spring.mail.properties.mail.smtp.starttls.enable=true



## 🧪 **Testing**

You can test APIs using:

**Swagger UI**

**Postman**

**Insomnia**



## 👨‍💻 Author

**Tazvir Rahman**

- Software Developer
- Java | Spring Boot | Backend Development

Feel free to ⭐ the repo or open issues or PRs.

Happy coding! 🚀

