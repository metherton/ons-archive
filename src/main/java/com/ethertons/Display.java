package com.ethertons;

public class Display {
    
    private String message;
    private Option<String> optionalMessage;

    public Display(Option<String> optionalMessage) {
        this.optionalMessage = optionalMessage;
    }

    public String show() {
        return optionalMessage.getOrElse("default");
//        if (message != null) {
//            return message;
//        }
//        return "default";
    }
}
