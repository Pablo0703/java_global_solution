# SMAE - Sistema de Monitoramento e Alerta de Emergências

![Status](https://img.shields.io/badge/status-concluído-brightgreen)

## Tabela de Conteúdos

1. [Descrição do Projeto](#1-descrição-do-projeto)
2. [Tecnologias Utilizadas](#2-tecnologias-utilizadas)
3. [Execução do Projeto](#3-execução-do-projeto)
4. [Sequência de Funcionamento](#4-sequência-de-funcionamento)
5. [Banco de Dados](#5-banco-de-dados)
6. [Swagger](#6-swagger)
7. [Deploy](#7-deploy)
8. [Testes com Insomnia](#8-testes-com-insomnia)
9. [Endpoints - Acesso Rápido](#9-endpoints---acesso-rápido)
10. [Ordem Recomendada para Testes](#10-ordem-recomendada-para-testes)
11. [Prints do Swagger](#11-prints-do-swagger)
12. 
13. [Autores](#13-autores)

---

## 1. Descrição do Projeto

O **SMAE** é um sistema backend construído com **Java Spring Boot**, seguindo arquitetura REST. Seu objetivo é permitir o monitoramento de áreas de risco através de sensores ambientais, alertas automatizados e notificações aos usuários. Ele serve como base para integração com um aplicativo mobile e futuros sistemas distribuídos.

---

## 2. Tecnologias Utilizadas

* **Java:** 21
* **Spring Boot:** 3.5.0
* **Maven:** gerenciamento de dependências
* **Banco de Dados:** Oracle
* **Swagger:** documentação da API
* **Docker:** para execução local simplificada
* **Hospedagem:** Render
* **Mobile (futuro):** React Native

---

## 3. Execução do Projeto

### 3.1 Clonando o Repositório

```bash
git clone https://github.com/Pablo0703/java_global_solution
```

### 3.2 Executando via Docker

```bash
docker-compose up
```

### 3.3 Executando Localmente

```bash
./mvnw spring-boot:run
```

### 3.4 Acesso

```
http://localhost:8080
```

---

## 4. Sequência de Funcionamento

1. **Cadastro de Usuário**
2. **Cadastro de Área de Risco**
3. **Cadastro de Sensor**
4. **Registro de Leitura do Sensor**
5. **Criação de Alerta**
6. **Inscrição em Alerta**
7. **Geração de Notificação**

---

## 5. Banco de Dados

* Conexão com **Oracle DB**
* Configuração via `application.properties` ou `application.yml`
* Porta padrão: `1521`

> *Informações sensíveis como login e senha foram omitidas.*

---

## 6. Swagger

* Local: [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)
* Deploy: [`https://java-global-solution.onrender.com/swagger-ui/index.html`](https://java-global-solution.onrender.com/swagger-ui/index.html)

---

## 7. Deploy

* Hospedagem via **Render**
* Produção: [`https://java-global-solution.onrender.com`](https://java-global-solution.onrender.com)

---

## 8. Testes com Insomnia

A API foi testada usando o [Insomnia](https://insomnia.rest/), realizando requisições:

* `POST`: criação de entidades
* `PUT`: atualização de registros
* `GET`: listagem e busca por ID
* `DELETE`: exclusão de registros

> Recomendado: criar um workspace no Insomnia e seguir os endpoints documentados via Swagger.

---

## 9. Endpoints - Acesso Rápido

| Ambiente       | Link                                                              |
| -------------- | ----------------------------------------------------------------- |
| Local          | `http://localhost:8080`                                           |
| Swagger Local  | `http://localhost:8080/swagger-ui/index.html`                     |
| Render         | `https://java-global-solution.onrender.com`                       |
| Swagger Render | `https://java-global-solution.onrender.com/swagger-ui/index.html` |

Endpoints Diretos (em ordem de uso recomendada):

http://localhost:8080/usuarios

http://localhost:8080/areas

http://localhost:8080/sensores

http://localhost:8080/leituras

http://localhost:8080/alertas

http://localhost:8080/notificacoes

http://localhost:8080/inscricoes

---

## 10. Ordem Recomendada para Testes

1. `POST /usuarios`
2. `POST /areas`
3. `POST /sensores`
4. `POST /leituras`
5. `POST /alertas`
6. `POST /notificacoes`
7. `POST /inscricoes`

---

## 11. Prints do Swagger

A seguir, prints da documentação Swagger demonstrando cada etapa do funcionamento da API:

| Funcionalidade            | Imagem                                         |
| ------------------------- | ---------------------------------------------- |
| Cadastro de Usuário       | ![image](https://github.com/user-attachments/assets/df630f43-c668-4df9-9a56-48e45ee090af)|

| Cadastro de Área de Risco | ![image](https://github.com/user-attachments/assets/50b6f69d-2056-4359-b516-5f1d6425a07e)|

| Cadastro de Sensor        | ![image](https://github.com/user-attachments/assets/b82f2540-453a-4779-8597-48fa243a18f7)|

| Leitura de Sensores       | ![image](https://github.com/user-attachments/assets/4915bfcb-f813-4369-9261-1360fb53bbb2)|

| Criação de Alerta         | ![image](https://github.com/user-attachments/assets/cc877b92-b855-45b9-9856-08fbfe904881)|

| Inscrição em Alerta       | ![image](https://github.com/user-attachments/assets/5d94a087-6e2e-4c5b-a2e0-042009163e98)|

| Tela de Notificações      | ![image](https://github.com/user-attachments/assets/7c0accc1-6941-4595-8a44-2b0a64616ab8)|

## 12. Json
{
  "usuario": {
    "nome": "Joana Mendes",
    "email": "joana@email.com",
    "senha": "senhaSegura123",
    "telefone": "11988887777",
    "perfil": "CIDADAO"
  },
  "sensor": {
    "idSensor": "SENSOR001",
    "idArea": 1,
    "tipoSensor": "NIVEL_AGUA",
    "modelo": "Modelo-X",
    "ultimaManutencao": "2025-06-01",
    "statusSensor": "ATIVO"
  },
  "notificacao": {
    "idAlerta": 100,
    "idUsuario": 1,
    "canalEnvio": "EMAIL"
  },
  "leituraSensor": {
    "idSensor": "SENSOR001",
    "valorLeitura": 2.8,
    "unidadeMedida": "m"
  },
  "inscricaoAlerta": {
    "idUsuario": 1,
    "idArea": 1,
    "receberEmail": true,
    "receberSms": false,
    "receberPush": true
  },
  "areaRisco": {
    "nomeArea": "Bairro do Centro",
    "latitude": -23.5505,
    "longitude": -46.6333,
    "nivelNormalEstacaoSeca": 1.2,
    "nivelNormalEstacaoChuva": 2.0,
    "nivelAlertaPreventivo": 2.5,
    "nivelAlertaEmergencia": 3.0,
    "nivelEvacuacao": 3.5,
    "areaAlagadaAlerta": 1.5,
    "areaAlagadaEmergencia": 2.5,
    "metodoMedicaoNivel": "Sensor IoT",
    "metodoMedicaoExtensao": "LIDAR",
    "fonteDados": "Sistema Integrado",
    "responsavelAtualizacao": "Equipe Técnica",
    "descricao": "Área próxima ao rio com alto risco em época de chuvas"
  },
  "alerta": {
    "idArea": 1,
    "idLeituraGatilho": 10,
    "tipoAlerta": "EMERGENCIA",
    "mensagemAlerta": "Nível crítico atingido, evacuação necessária."
  }
}

## 13. Autores

| RM     | Nome                            |
| ------ | ------------------------------- |
| 556834 | Pablo Lopes Doria de Andrade    |
| 558711 | Diego Santos Cardoso            |
| 557047 | Vinicius Leopoldino de Oliveira |
