package ru.itis.javalab.utils;


public interface MailsGenerator {
    String getMailForConfirm(String serverUrl, String confirmedCode);
}
