# Semestrální práce SIN
### Dominik Dvořáček

## Povinná část
- BO layer (`package entity`)
    - UML class diagram ve složce `/doc`
- Repository (`package repository`)
- Service layer (`package service`)
    - Sequence diagram ve složce `/doc/sequence-diagrams`
- Controller layer (`package controller`)
    - REST controller

## Volitelná část (8 bodů)
- testy unit kazda trida na service layer a controller layer (`test.java.cvut.fel`)
- design patternu alespon 6
    - Builder: `dto.request.BookCreate`
        - realizováno pomocí lombok `@Builder` anotace
    - Singleton: `test.java.cvut.fel.utils.Generator`
    - Chain of responsibility: `controller.interceptors`
      - realizováno pomocí implementace interceptoru: metoda preHandle je jeden z 
        článků chain of responsibility zpravávajícího http request
    - Strategy: `controller.interceptors`
      - interceptor pro logování byl doplněn o výběr strategie logování.
        K dispozici jsou dvě strategie - Detailed a Short. Přepínání mezi strategiemi se provádí
        v `application.properties` změnou atributu `requestLogging.detail`
    - Prototype: `package dto`
      - dto třídy implementují návrhový vzor prototype
    - Facade: `repository.SaveEntityFascade`
        - Třida která seskupuje save metody všech repository. Tyto metody byly hojně využívány při adhoc testování 
          funkcí aplikace, proto byla vytvořena fasáda, který odbourává nutnost injektace jednotlivých repository.
- interceptor (`controller.interceptors`)
    - logování zpracování requestu serverem
- další dokumentace UML: diagram nasazení, package diagram (složka `/doc`)
- statická analýza kódu (FindBugs) složka `find-bugs`
    - výpis pred opravou chyb, výpis po opravení chyb
- Springfox (`config.SpringFoxConfig`)
    - Springfox Swagger: http://localhost:8080/swagger-ui/
- Javadoc cele aplikace (složka `/javadoc`)
- mapstruct, convertory, DTO vrstva (`package dto`)

### Resources
Article link :  https://www.mkyong.com/spring-boot/spring-boot-spring-data-jpa/  
Interceptors :  https://www.baeldung.com/spring-mvc-handlerinterceptor  
EAR eshop :     https://gitlab.fel.cvut.cz/ear/b211-eshop/-/tree/main/  