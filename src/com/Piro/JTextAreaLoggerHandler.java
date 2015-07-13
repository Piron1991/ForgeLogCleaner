package com.Piro;

import javax.swing.*;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class JTextAreaLoggerHandler extends StreamHandler {

    private JTextArea textArea = null;

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void publish(LogRecord record) {
        super.publish(record);
        flush();

        if (textArea != null) {
            textArea.append(getFormatter().format(record));
        }
    }
}
