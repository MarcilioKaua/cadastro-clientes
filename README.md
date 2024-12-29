# Cadastro de Clientes

Este projeto é uma aplicação web desenvolvida em **Java** usando **Spring Boot** com funcionalidades de gerenciamento de cadastro de clientes. A aplicação utiliza **JPA** para persistência e **H2 Database** para armazenamento em memória. Além disso, integra-se ao serviço **ViaCEP** para buscar informações de endereços.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **JPA**
- **H2 Database**
- **ViaCEP API**

---

## 🔧 Funcionalidades Implementadas

- **Cadastro de Clientes**: Adicionar informações de clientes.
- **Listagem de Clientes**: Exibir todos os clientes cadastrados.
- **Edição de Clientes**: Editar informações dos clientes cadastrados.
- **Exclusão de Clientes**: Excluir clientes cadastrados.
- **Busca de Endereço**: Integração com o serviço **ViaCEP** para busca automática de endereço por CEP.
- **Banco de Dados H2**: Banco de dados em memória para armazenamento temporário dos dados.

---

## 🛠️ Configuração do Ambiente

### Pré-requisitos

- **Java 17** instalado
- Uma IDE compatível (Recomendado o IntelliJ IDEA)

---

## ⚙️ Configuração do Projeto

### Clonar o Repositório

1. Clone o repositório para seu ambiente local:
   ```bash
   git clone https://github.com/MarcilioKaua/cadastro-clientes.git

2. Certifique-se de que o **Java 17** e o **Maven** estão instalados no seu ambiente.

3. Se necessário instale as dependências do maven, abrindo a opção do maven e selecionando Reload All Maven Projects

## ▶️ Executando a Aplicação

1. Execute o projeto rodando a classe CadastoClientesApplication

2. Após a execução bem-sucedida, acesse a aplicação em seu navegador no seguinte endereço:

   ```bash
   http://localhost:8080/cliente/listar

## 🗄️ Acesso ao Console do H2

1. Durante a execução da aplicação, o console do banco de dados H2 estará disponível no seguinte endereço:

   ```bash
   http://localhost:8080/h2-console

2. Detalhes da Configuração
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: (Deixar em branco)

## 📝 Observações

- O banco de dados H2 é configurado para rodar em memória, o que significa que os dados serão apagados quando a aplicação for encerrada.
