# Upday backend applicant test

## Task Description
* This news application helps us to create/update/delete an article, it provides multiple APIs to save, get & update the articles, application provides article 
  information based on article author, keywords in article and article creation date. 

The project is based on a small web service which uses the following technologies:

* Java 11
* Spring Boot
* Database H2 (In-Memory)
* Spring Data JPA
* Maven
* EHcache

* NOTE:- This applicaion uses in memory database (H2), data will not be persisted once the application is stopped


## Overview
* You should be able to start the example application by executing com.upday.news.NewsApplication, which starts a webserver on port 8080 (http://localhost:8080) and serves SwaggerUI where can inspect and try existing endpoints.

## Security & Credentials
* Application is secured with credentials admin/admin, to get the jwt token initially we have to pass credentials first, and use this jwt token for sub-sequent
  requests from client.
* Application validates every request coming from client and expects valid jwt token.


## API's available to use
 * [PUT] /v1/article/{articleId} - to update article information.

 * [DELETE] /v1/article/{articleId} - to delete a particular article.

 * [POST] /v1/article - to create a new article.

 * [GET] /v1/article/{id} - to get an article based on id.

 * [GET] /v1/article/keyword/{keyword} - to get the list of articles based on keyword.

 * [GET] /v1/article/author/{author} - to get the list of articles based on author.

 * [GET] /v1/article/filter - to get the list of articles for a time period.
 
 * [GET] /v1/article - to get all the articles without any filers.





