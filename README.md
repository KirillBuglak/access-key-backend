<h1 align="center">IPv6 check</h1>

----

----
## Stack
Java, Spring Boot, Spring Data Jpa, Spring Web, Spring Security, FlywayDB, PostgreSQL, Lombok.
____
## Task
<details>
<summary>Details</summary>

___
### Todo:
- local version control (git)
- commit first project version
- implement described feature and commit


#### Feature:
API endpoint for IPv6 support.

Endpoint's characteristics:
- public;
- /api/web/checkIpv6Support - path;
- siteUrl - query parameter;
- success - boolean. response with 200 status;

Additional details:
- siteUrl - should take full and partial URI.
</details>

---
## Implementation

---
### Request
```
GET http://localhost:8080/api/web/checkIpv6Support?siteUrl=https://www.yandex.ru/
```
Controller method
```java
@GetMapping("/api/web/checkIpv6Support")
public ResponseEntity<Boolean> checkIpv6Support(@RequestParam String siteUrl) throws NotValidURLException {
    return ResponseEntity.ok(service.checkURL(siteUrl).isSuccess());
    }
```
Parameters:
- siteUrl - full or partial URI;

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
