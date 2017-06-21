# aws-amazon-shopping-bot-lambda-demo1
Amazon Lambda function, implemented on Java, for AWS Lex bot. 
Demo project for the introduction video tutorial: https://youtu.be/cy9GX33nuKM

Amazon Lex allows to build conversation bots and integrate them to Facebook Messenger, Slack or Twilio:
https://aws.amazon.com/lex/

AWS Lambda a set of functions and components, which can be implemented on different runtimes - Node, Java, C#, Python:
https://aws.amazon.com/lambda/

AWS Services console:
console.aws.amazon.com

Amazon Lex Developer Guide:
https://aws.amazon.com/documentation/lex/

AWS Lambda Developer Guide:
https://aws.amazon.com/documentation/lambda/

Example of AWS Lambda function implemented on Java 8:
https://github.com/satr/aws-amazon-shopping-bot-lambda-func

Java SDK:
com.amazonaws:aws-lambda-java-core
com.amazonaws:aws-java-sdk-lambda

JSON request example:
{
  "bot": {
    "alias": "null",
    "name": "ShoppingBot",
    "version": "$LATEST"
  },
  "currentIntent": {
    "confirmationStatus": "None",
    "name": "BakeryDepartment",
    "slots": {
      "Amount": "1",
      "BakeryProduct": "bread",
      "BakeryDepartmentUnit": "loaf"
    }
  }
}

NodeJS Lambda function example for the request above:
exports.handler = (event, context, callback) => {
    var product = event.currentIntent.slots.BakeryProduct;
    var amount = event.currentIntent.slots.Amount;
    var unit = event.currentIntent.slots.BakeryDepartmentUnit;
    callback(null, {
                    "dialogAction": {
                        "type": "Close",
                        "fulfillmentState": "Fulfilled",
                        "message": {
                          "contentType": "PlainText",
                          "content": "Thank you for your order of " + amount + " " + unit + " of " + product 
                        }
                      }
                    });
};


