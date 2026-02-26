# ☕ Meu Primeiro Projeto Spring Boot - API de Produtos

![Status](https://img.shields.io/badge/Status-Finalizado-green)

Este repositório registra meus primeiros passos no desenvolvimento back-end utilizando **Java** e **Spring Boot**. Seguindo uma abordagem prática, este projeto foi essencial para entender como o Spring gerencia requisições e como estruturar uma API REST inicial para o meu objetivo de ser um **Desenvolvedor Full-Stack**.

## 🚀 Principais Aprendizados

Durante este primeiro contato, explorei os conceitos base que sustentam grandes aplicações:

- 🏗️ **Configuração de API REST**: Uso da anotação `@RestController` para definir classes que tratam requisições e retornam dados diretamente ao cliente.
- 🔄 **Mapeamento de Rotas**: Prática com `@GetMapping` para criar endpoints de saudação e consulta de produtos, incluindo a sensibilidade a maiúsculas/minúsculas nas rotas.
- 🧬 **Anotações de Ciclo de Vida**: Implementação do `@PostConstruct` para popular a lista de produtos automaticamente assim que a aplicação inicia, simulando um banco de dados em memória.
- 📦 **Estrutura de Models**: Criação de classes Java Beans (`Product`) com atributos privados e métodos getters/setters para representação de dados.
- 📐 **Captura de Parâmetros**: Uso de `@PathVariable` para buscar recursos específicos através da URL (ex: buscar produto por ID).

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java 21.
- **Framework**: Spring Boot 3.
- **Gerenciador de Build**: Maven.
- **Design/UI (Padrão)**: Bootstrap (para futuras integrações front-end).

## 🖥️ Endpoints Disponíveis

| Método | Caminho | Descrição |
|---|---|---|
| GET | `/hello` | Mensagem simples de saudação |
| GET | `/Products` | Retorna a lista completa (Atenção ao "P" maiúsculo) |
| GET | `/products/{id}` | Retorna um produto específico pelo ID |

## ⚙️ Como Executar

1. Certifique-se de ter o **Java 21** e o **Maven** instalados.
2. Clone o repositório e acesse a pasta do projeto.
3. Execute o comando:
   ```bash
   mvn spring-boot:run
