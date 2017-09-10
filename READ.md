
*Reference:https://javabrains.io/*

This project implements a part of messenger app api which satisfies the Level 4 of Richardson Maturity Model. 
It maintains Messages and comments for messages and supports both XML/JSON.
Project includes the following files:

1.Model- Message, Comment,Link,ErrorResponse- these classes act as the model of the project as instead of
          database customized classes with hashmaps is used.
          
2.Services- MessageService,CommentServcie,Database -There classes act as service classes for providing data
            and functionality of project.
            
3.ErrorHandling- DataNotFoundException,DataNotFoundExceptionMapper -classes handling a particular type of exception.

4.Resources- MessageResource,CommentResource- These classes act as resources for api.

**How to run?**

Client like Postman can be used to get following resources:-

**1.For Messages**
POST: messenger/webapi/messages

GET : messenger/webapi/messages -- for all messages

  :messenger/webapi/messages/messageid - for a particular message
  
PUT : messenger/webapi/messages/messageid

DELETE: messenger/webapi/messages/messageid

**2.For Comments:**
POST:messenger/webapi/messages/messageid/comments

GET: messenger/webapi/messages/messageid/comments - for getting all comments for a particular message 
    :messenger/webapi/messages/messageid/comments/commentid-for getting a particular comment
    
PUT: messenger/webapi/messages/messageid/comments/commentid

DELETE:messenger/webapi/messages/messageid/comments/commentid
