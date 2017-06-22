package io.github.satr.aws.lambda.shoppingbot;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class ShoppingBotLambda implements RequestHandler<Map<String, Object>, Object> {

    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {

        LexRequest lexRequest = LexRequestFactory.createLexRequest(input);
        String content = String.format("Request came from the bot: %s, Department: %s;" +
                                        "You ordered: %s %s of %s",
                                        lexRequest.getBotName(),
                                        lexRequest.getDepartmentName(),
                                        lexRequest.getAmount(),
                                        lexRequest.getUnit(),
                                        lexRequest.getProduct()
                                        );
        Message message = new Message("PlainText", content);
        DialogAction dialogAction = new DialogAction("Close", "Fulfilled", message);
        return new LexRespond(dialogAction);
    }

}
