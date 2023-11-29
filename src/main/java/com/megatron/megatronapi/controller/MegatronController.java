package com.megatron.megatronapi.controller;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static jakarta.servlet.SessionTrackingMode.URL;

@Component
public class MegatronController implements MegatronControllerInterface{
    @Override
    public String testeApi()
    {
        return "Testando API megatron.";
    }

    @Override
    public List<String> atualizarMoeda(){
        List<String> minhaLista = new ArrayList<>();
        minhaLista.add("Primeiro item da lista");
        minhaLista.add("Segundo item da lista");
        minhaLista.add("Terceiro item da lista");
        return minhaLista;
    }

    @Override
    public String generateBasicHtml(){
        List<String> minhaLista = atualizarMoeda();
        // Construa o HTML usando a lista
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>\n");
        htmlBuilder.append("<html>\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("<title>Lista Atualizada</title>\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");
        htmlBuilder.append("<h2>Lista Atualizada:</h2>\n");
        htmlBuilder.append("<ul>\n");

        for (String elemento : minhaLista) {
            htmlBuilder.append("<li>").append(elemento).append("</li>\n");
        }

        htmlBuilder.append("</ul>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }

}