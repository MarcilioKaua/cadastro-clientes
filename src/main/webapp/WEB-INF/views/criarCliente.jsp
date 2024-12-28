<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Cliente</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>Cadastrar Cliente</h2>

<form action="${pageContext.request.contextPath}/cliente/salvar" method="post">
    <label for="nome">Nome: </label>
    <input type="text" id="nome" name="nome" required="true" />
    <br/><br/>

    <label for="email">E-mail: </label>
    <input type="email" id="email" name="email" required="true" />
    <br/><br/>

    <label for="telefone">Telefone: </label>
    <input type="text" id="telefone" name="telefone" />
    <br/><br/>

    <label for="cep">CEP: </label>
    <input type="text" id="cep" name="cep" required="true" />
    <button type="button" id="buscarEndereco">Buscar Endereço</button>
    <br/><br/>

    <label for="endereco">Endereço: </label>
    <input type="text" id="endereco" name="endereco" readonly="true" />
    <br/><br/>

    <label for="bairro">Bairro: </label>
    <input type="text" id="bairro" name="bairro" readonly="true" />
    <br/><br/>

    <label for="cidade">Cidade: </label>
    <input type="text" id="cidade" name="cidade" readonly="true" />
    <br/><br/>

    <label for="estado">Estado: </label>
    <input type="text" id="estado" name="estado" readonly="true" />
    <br/><br/>

    <input type="submit" value="Salvar" />
    <a href="${pageContext.request.contextPath}/cliente/listar">Voltar</a>
</form>

<script>
    $(document).ready(function() {
        $("#buscarEndereco").on("click", function() {
            const cep = $("#cep").val();
            if (cep) {
                console.log("Entrou cep")
                $.ajax({
                    url: "${pageContext.request.contextPath}/cliente/buscarEndereco",
                    type: "POST",
                    data: { cep: cep },
                    success: function(response) {
                        console.log("sucseesss")
                        $("#endereco").val(response.logradouro);
                        $("#bairro").val(response.bairro);
                        $("#cidade").val(response.localidade);
                        $("#estado").val(response.uf);
                    },
                    error: function() {
                        alert("Não foi possível buscar o endereço. Verifique o CEP informado.");
                    }
                });
            } else {
                alert("Por favor, insira um CEP.");
            }
        });
    });
</script>
</body>
</html>