# Hibernate5ModuleIssueDemo

This is a demo for reproducing a [issue in jackson-datatype-hibernate5](https://github.com/FasterXML/jackson-datatype-hibernate/issues/108).

## Reproduce
1. Prepare mysql database with `test.sql` and run `cn.chenhuanming.hibernate5ModuleIssueDemo.Application` as spring boot application.

2. visit http://localhost:8010/students/1/teacher and will get


        {
          "name" : "Martin",
          "sex" : "male",
          "handler" : { },
          "hibernateLazyInitializer" : { },
          "_links" : {
            "self" : {
              "href" : "http://localhost:8010/teachers/1"
            },
            "teacher" : {
              "href" : "http://localhost:8010/teachers/1"
            },
            "students" : {
              "href" : "http://localhost:8010/teachers/1/students"
            }
          }
        }

Up to now, `jackson-datatype-hibernate5` is not be added into project.
It just sets `SerializationFeature.FAIL_ON_EMPTY_BEANS` to false in `application.yml`,so `handler` and `hibernateLazyInitializer` is appear in json.

3. And **now uncommented `jackson-datatype-hibernate5` dependency in pom.xml**,then repeat the step two,and we got

        {
          "content" : {
            "name" : "Martin",
            "sex" : "male"
          },
          "_links" : {
            "self" : {
              "href" : "http://localhost:8010/teachers/1"
            },
            "teacher" : {
              "href" : "http://localhost:8010/teachers/1"
            },
            "students" : {
              "href" : "http://localhost:8010/teachers/1/students"
            }
          }
        }
  
 I think it is not proper that `content` is added into json because entire json is a resource represents Teacher `Martin`.
