<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Listar Clientes</title>
</head>
<body>
<h2>Lista de Clientes</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>E-mail</th>
        <th>Telefone</th>
        <th>CEP</th>
        <th>Endereço</th>
        <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cliente" items="${clientes}">
        <tr>
            <td>${cliente.id}</td>
            <td>${cliente.nome}</td>
            <td>${cliente.email}</td>
            <td>${cliente.telefone}</td>
            <td>${cliente.cep}</td>
            <td>${cliente.endereco}</td>
            <td>
                <a href="${pageContext.request.contextPath}/cliente/excluir/${cliente.id}">Excluir</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${not empty clientes}">
    <ul>
        <c:forEach var="cliente" items="${clientes}">
            <li>${cliente.id} - ${cliente.nome} - ${cliente.email}</li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty clientes}">
    <p>Nenhum cliente encontrado.</p>
</c:if>

<h3>Clientes enviados pelo Model:</h3>
<c:out value="${clientes}" />

<h3>Nome do Primeiro Cliente: ${clienteName}</h3>

<a href="${pageContext.request.contextPath}/cliente/novo">Novo Cliente</a>
</body>
</html>
