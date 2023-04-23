<h1 align="center">IPv6 check</h1>

----

----
## Stack
Java, Spring Boot, Spring Data Jpa, Spring Web, Spring Security, FlywayDB, PostgreSQL, Lombok.
____
## Задание
<details>
<summary>Подробнее</summary>

___
### Необходимо сделать:
- локальный контроль версий (git)
- закомитить изначальную стадию проекта
- реализовать фичу описанную ниже отдельным коммитом


#### Необходимая фича:
API endpoint для проверки поддержки IPv6 сайтом.

Характеристики этого endpoint'a:
- публичный
- /api/web/checkIpv6Support - путь.
- siteUrl - query parameter. Сюда приходит url сайта который нужно проверить на поддержку IPv6.
- success - boolean. Такой должен быть ответ, с 200 кодом.

Примечания:
- siteUrl - принимает как домен в чистом виде, так и полный URI.
</details>

---
## Решение

---
### Request
```
GET http://localhost:8080/api/web/checkIpv6Support?siteUrl=https://www.yandex.ru/
```
Controller метод
```java
@GetMapping("/api/web/checkIpv6Support")
public ResponseEntity<Boolean> checkIpv6Support(@RequestParam String siteUrl) throws NotValidURLException {
    return ResponseEntity.ok(service.checkURL(siteUrl).isSuccess());
    }
```
Параметры:
- siteUrl - как домен в чистом виде, так и полный URI;

---
### Response
```json
{
    "success": true
}
```
```json
{
    "success": false
}
```