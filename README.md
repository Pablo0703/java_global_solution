# SMAE - Sistema de Monitoramento e Alerta de Emergências

## Resumo do Status Atual

O backend do SMAE foi desenvolvido utilizando Java Spring Boot, seguindo os princípios de arquitetura REST e implementando padrões de projeto que garantem escalabilidade, manutenibilidade e segurança. A aplicação é responsável por processar dados de sensores, gerenciar usuários, áreas de risco e alertas, além de fornecer APIs para o aplicativo mobile e outros sistemas integrados.

## Tecnologias Utilizadas

* **Java:** versão 21
* **Spring Boot:** 3.5.0
* **Gerenciador de Dependências:** Maven
* **Banco de Dados:** Oracle (acesso via SQL Developer)
* **Mobile (futuro):** React Native
* **Docker:** configurado para facilitar a execução local
* **Swagger:** implementado para documentação e testes de endpoints
* **Hospedagem em Nuvem:** Render

## Execução do Projeto

1. Clone o repositório:

   ```bash
   git clone [<URL_DO_REPOSITORIO>](https://github.com/Pablo0703/java_global_solution)
   ```

2. Navegue até a pasta do projeto:

   ```bash
   cd...
   ```

3. Para rodar via Docker (certifique-se de que Docker esteja instalado):

   ```bash
   docker-compose up
   ```

4. Ou execute localmente com Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

5. A aplicação estará disponível em:

   ```
   http://localhost:8080
   ```

## Banco de Dados

* A aplicação conecta-se a um banco Oracle configurado via application.properties ou application.yml.
* Porta padrão: 1521

> *Informações de acesso ao banco foram omitidas por segurança.*

## Swagger

* **Implementado**.
* A documentação dos endpoints pode ser acessada em:

  * Local: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
  * Render: [https://java-global-solution.onrender.com/swagger-ui/index.html](https://java-global-solution.onrender.com/swagger-ui/index.html)

## Deploy

* Realizado via **Render**.
* URL de produção: [https://java-global-solution.onrender.com](https://java-global-solution.onrender.com)

## Testes da API com Insomnia

Para testar os endpoints da API do SMAE, foi utilizada a ferramenta [Insomnia](https://insomnia.rest/), que permite realizar requisições HTTP de forma prática e eficiente. Com ela, foram testadas todas as funcionalidades principais da API.

As operações testadas incluíram:

* **POST** – Criação de novos registros (usuários, sensores, áreas de risco, alertas, notificações, inscrições)
* **PUT** – Atualização de dados existentes
* **GET** – Consulta de listas e itens individuais por ID
* **DELETE** – Remoção de registros

> Caso deseje reproduzir os testes, recomenda-se criar um workspace no Insomnia e configurar os endpoints com base na documentação da API. Todos os testes foram realizados utilizando o backend rodando em `http://localhost:8080`.

## Endpoints - Acesso Rápido

* Local: `http://localhost:8080`
* Render: `https://java-global-solution.onrender.com`
* Swagger Local: `http://localhost:8080/swagger-ui/index.html`
* Swagger Render: `https://java-global-solution.onrender.com/swagger-ui/index.html`

### Endpoints Disponíveis:

* `GET /usuarios`
* `GET /alertas`
* `GET /areas`
* `GET /inscricoes`
* `GET /leituras`
* `GET /notificacoes`
* `GET /sensores`

### Ordem Recomendada para Testes de POST:

1. **Usuários** → `POST /usuarios`
2. **Áreas de Risco** → `POST /areas`
3. **Sensores** → `POST /sensores` (requere `idArea` já cadastrado)
4. **Leituras de Sensor** → `POST /leituras` (requere `sensorId` já cadastrado)
5. **Alertas** → `POST /alertas` (requere `idArea` já cadastrado)
6. **Notificações** → `POST /notificacoes` (requere `alertaId` já cadastrado)
7. **Inscrição de Alerta** → `POST /inscricoes` (requere `idUsuario` e `idArea` já cadastrados)

---

**Autor:** Pablo Lopes - RM556834
