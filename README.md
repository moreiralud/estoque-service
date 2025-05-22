===================================
ESTOQUE-SERVICE - TECH CHALLENGE
===================================

Microsserviço responsável pelo gerenciamento de estoque de produtos no sistema distribuído do Tech Challenge.

-------------------------------
📦 TECNOLOGIAS UTILIZADAS
-------------------------------
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Docker
- Maven
- Lombok

-------------------------------
📁 ESTRUTURA DO PROJETO
-------------------------------
src/
├── main/
│   ├── java/
│   │   └── br.com.techchallenge.estoque/
│   │       ├── application/    -> Controllers (API REST)
│   │       ├── core/           -> Domínio, entidades e interfaces
│   │       └── infrastructure/ -> Repositórios e configurações
│   └── resources/
│       ├── application.yml     -> Configurações do serviço
│       └── ...                 -> Outros recursos
└── test/                       -> Testes unitários e de integração

-------------------------------
⚙️ COMO EXECUTAR LOCALMENTE
-------------------------------
1. Verifique se o Docker está instalado e em execução.
2. Execute o comando:
   docker compose up --build

O serviço estará acessível em: http://localhost:8085

-------------------------------
🔁 ENDPOINTS PRINCIPAIS
-------------------------------
GET     /estoque                 - Lista todos os produtos em estoque
POST    /estoque                 - Adiciona novo item ao estoque
GET     /estoque/{id}            - Consulta item de estoque por ID
PUT     /estoque/{id}            - Atualiza informações do item
DELETE  /estoque/{id}            - Remove item do estoque
PATCH   /estoque/{id}/baixa      - Dá baixa no estoque de um item

-------------------------------
✅ TESTES
-------------------------------
Para executar os testes:
> mvn test

Para gerar o relatório de cobertura:
> mvn jacoco:report

Relatório disponível em:
target/site/jacoco/index.html

-------------------------------
📌 OBSERVAÇÕES
-------------------------------
- Este serviço é essencial para o controle da disponibilidade de produtos.
- Integra-se aos serviços de pedidos e pagamentos.
- Banco de dados PostgreSQL configurável via `application.yml`.

-------------------------------
👩‍💻 DESENVOLVIDO POR
-------------------------------
Ludmila Moreira - Tech Challenge 2025
