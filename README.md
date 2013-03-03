# eRegister

## Overview

This project is a case study in the 12/13 web architectures module at Sheffield Hallam uni.

It's used to explore various aspects of web application including

* Configuration management - how the web dev process interacts with git
* Domain modelling - Transitioning from class models to MVC database structures
* Controller developmnet
* RESTful web services

## Checking out and Running the project

Some info here about how to run the project

### Prerequisites 

* The project needs a running local mysql database called eregister and by default connects to the database using a user called eregister and a password of eregister. Obviously this should be changed in a production environment.
* The mysql create database command should be create database eregister default charset utf8 default collate utf8_bin; The character set encoding is important as the web application is capable of accepting UTF8 input.
* The project is a groovy/grails project and needs an installed Java7 JDK and installed grails SDK (http://www.grails.org)

## What I learned / what I enoyed

* I really enjoyed the domain modelling part of the project, particularly creating the domain classes and working with the database. I found the view parts a little harder as I'm not visually minded. The relationships on the domain classes were hardest to get right, but I found commenting up the domain classes really helped. For example, see: https://github.com/acesii/eRegister/blob/lectures/grails-app/domain/uk/ac/shu/webarch/eregister/Student.groovy


