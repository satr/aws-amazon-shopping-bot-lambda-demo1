package io.github.satr.aws.lambda.shoppingbot;

import java.util.Map;

public class LexRequestFactory {
    public static LexRequest createLexRequest(Map<String, Object> input) {
        Map<String, Object> botMap = (Map<String, Object>) input.get("bot");
        String botName = (String) botMap.get("name");
        LexRequest lexRequest = new LexRequest();
        lexRequest.setBotName(botName);
        Map<String, Object> currentIntent = (Map<String, Object>) input.get("currentIntent");
        lexRequest.setDepartmentName((String)currentIntent.get("name"));
        Map<String, Object> slots = (Map<String, Object>) currentIntent.get("slots");
        lexRequest.setAmount((String)slots.get("Amount"));
        lexRequest.setProduct((String)slots.get("BakeryProduct"));
        lexRequest.setUnit((String)slots.get("BakeryDepartmentUnit"));
        return lexRequest;
    }
}
