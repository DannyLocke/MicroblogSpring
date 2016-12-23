package com.theironyard;

/**
 * Created by dlocke on 12/22/16.
 */
public class Message {

    //variables
    int id;
    String text;

    //constructor
    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }

    //default constructor
    public Message (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}//end class Message