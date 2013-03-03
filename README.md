# eRegister

## Overview

This project is a case study in the 12/13 web architectures module at Sheffield Hallam uni.

It's used to explore various aspects of web application including

* Configuration management - how the web dev process interacts with git
* Domain modelling - Transitioning from class models to MVC database structures
* Controller developmnet
* RESTful web services

This project is specifically avoiding authentication as we get to grips with web architectures more generally. Authentication is dealt with elsewhere in the course.

## Checking out and Running the project

Some info here about how to run the project

### Prerequisites 

* The project needs a running local mysql database called eregister and by default connects to the database using a user called eregister and a password of eregister. Obviously this should be changed in a production environment.
* The mysql create database command should be create database eregister default charset utf8 default collate utf8_bin; The character set encoding is important as the web application is capable of accepting UTF8 input.
* The project is a groovy/grails project and needs an installed Java7 JDK and installed grails SDK (http://www.grails.org)

### Major use cases

I decided to focus on the check-in process. In particular, I really wanted to experiment with REST interfaces. I'd like to be able to test those interfaces with curl using commands to create classes and check in specific students. My URL design for this is

* create classes - PUT request to http://localhost/eRegister/classes/${courseCode}/${classCode} will create the appropriate class entry for a course provided the course exists and the class exists
* register student POST to http://localhost/eRegister/classes/${courseCode}/${classCode} with regaction=sign, student=x will create a reg entry if the student is exists and is enrolled on the course.

## What I learned / what I enoyed

* I really enjoyed the domain modelling part of the project, particularly creating the domain classes and working with the database. I found the view parts a little harder as I'm not visually minded. The relationships on the domain classes were hardest to get right, but I found commenting up the domain classes really helped. For example, see: https://github.com/acesii/eRegister/blob/lectures/grails-app/domain/uk/ac/shu/webarch/eregister/Student.groovy


