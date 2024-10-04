package com.rimac.app.util;


import jakarta.mail.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

public class ObtenerCodigoHormail {

    private ObtenerCodigoHormail(){
        throw new IllegalStateException("Error en ObtenerCodigoHormail");
    }

    public static String obtener(String user, String pass) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        String codigo = null;
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("outlook.office365.com", user, pass);
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
            Message lastMessage = inbox.getMessage(messageCount);
            String charsToRemove = "?=";


            System.out.println(lastMessage);


            codigo = StringUtils.right(lastMessage.getSubject(), 8);
            for (char c : charsToRemove.toCharArray()) {
                codigo = codigo.replace(String.valueOf(c), "");
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codigo;
    }
}
