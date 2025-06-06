
<%@ page import="java.util.List"%>
<%@ page import="fr.but3.gestion_alimentation.model.Aliment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Liste des Aliments</title>
</head>
<body>
    <h1>Liste des Aliments</h1>
    <ul>
    <%
        List aliments = (java.util.List) request.getAttribute("aliments");
        if (aliments != null) {
            for (Object obj : aliments) {
                Aliment aliment = (Aliment) obj;
    %>
                <li>ID: <%= aliment.getAid() %>, Nom: <%= aliment.getName() %></li>
    <%
            }
        } else {
    %>
        <li>Aucun aliment trouvé.</li>
    <%
        }
    %>
    </ul>
</body>
</html>

