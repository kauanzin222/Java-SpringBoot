# Projeto: projectbackend 🚀

![Java](https://img.shields.io/badge/Java-21-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen) ![Maven](https://img.shields.io/badge/Maven-✔️-orange)

Este repositório é o primeiro projeto em Java + Spring Boot do aluno, seguindo uma vídeo-aula prática. O objetivo deste README é anotar conceitos básicos aprendidos e mostrar exemplos extraídos diretamente do código do projeto. Abaixo estão notas rápidas, exemplos e dicas para testar a aplicação.

Dica rápida: as rotas são definidas textualmente no código — observe maiúsculas/minúsculas exatamente como estão no controller.

## Resumo do que está neste projeto ✨

- ✅ Aplicação Spring Boot com classe principal `ProjectbackendApplication` anotada com `@SpringBootApplication`.
- ✅ Um modelo simples `Product` (classe Java com atributos e métodos getters/setters).
- ✅ Dois controllers REST em `resources`: `HelloController` e `ProductController` usando anotações do Spring para mapear rotas.
- ✅ Propriedade simples em `src/main/resources/application.properties`.
- ✅ Gerenciamento via Maven (arquivo `pom.xml`).

## Contrato curto (para você lembrar) 📝

- ▶️ Entrada: código fonte Java nesta pasta (`src/main/java/...`).
- ▶️ Saída: endpoints HTTP que retornam dados (JSON / String).
- ⚠️ Erros comuns: rota incorreta (letras maiúsculas/minúsculas), índice fora do intervalo ao buscar produto por id.

## Conceitos e anotações (@) usados 🧠

- `@SpringBootApplication`
  - Presente em `ProjectbackendApplication.java`.
  - Marca a classe principal que inicializa a aplicação Spring Boot. Agrupa `@Configuration`, `@EnableAutoConfiguration` e `@ComponentScan`.

- `@RestController`
  - Usado em `HelloController` e `ProductController`.
  - Indica ao Spring que a classe trata requisições REST e que os métodos retornam o corpo da resposta diretamente (sem view).

- `@GetMapping("caminho")`
  - Mapeia métodos para requisições HTTP GET.
  - Exemplos:
    - `@GetMapping("hello")` em `HelloController` retorna a string `"Hello Spring Boot"`.
    - `@GetMapping("products/{id}")` em `ProductController` recebe um `id` na URL.
    - `@GetMapping("Products")` (observe a letra maiúscula no projeto) retorna a lista completa.

- `@PathVariable`
  - Usado para capturar partes da URL como parâmetro do método. Ex.: `getProduct(@PathVariable int id)` captura `{id}` em `products/{id}`.

- `@PostConstruct` (de `jakarta.annotation`)
  - Método anotado será executado após a construção do bean pelo Spring.
  - Em `ProductController`, o método `init()` popula uma lista de `Product` com exemplos para uso durante a execução.

## Estrutura e exemplos de código (explicação rápida) 🔎

- Model: `Product` (classe simples)
  - Atributos: `id` (int), `name` (String), `price` (double).
  - Padrão Java Beans: campos privados + getters e setters públicos.
  - Essa classe mostra a sintaxe Java básica (declaração de campos, métodos, tipos primitivos e objetos).

- Controller: `ProductController`
  - Mantém uma `List<Product>` em memória.
  - No `@PostConstruct` cria três produtos e adiciona à lista.
  - `getProduct(int id)` retorna `products.get(id - 1)` — ⚠️ cuidado: se for passado um id inválido, isso lança `IndexOutOfBoundsException`.
  - `getProducts()` retorna a lista inteira.
  - Observação: a rota da lista está definida como `"Products"` com P maiúsculo — as rotas são sensíveis à string exata definida.

- Controller: `HelloController`
  - Método simples que responde `"Hello Spring Boot"` para `GET /hello`.

## Caminhos (endpoints) disponíveis no projeto 🌐

- GET /hello
  - Retorna: "Hello Spring Boot" (texto simples)

- GET /products/{id}
  - Retorna: um objeto `Product` correspondente ao id (ex.: `/products/1`).
  - Atenção: o código usa `products.get(id - 1)`, então ids válidos são 1..3 neste exemplo inicial.

- GET /Products
  - Retorna: lista completa de produtos (observe o P maiúsculo conforme definido no código).

### Tabela rápida de endpoints

| Método | Caminho | Descrição | Exemplo |
|---|---:|---|---|
| GET | /hello | Mensagem simples de saudação | curl http://localhost:8080/hello |
| GET | /products/{id} | Retorna um produto pelo id (ids válidos: 1..3) | curl http://localhost:8080/products/1 |
| GET | /Products | Retorna a lista completa de produtos (observe o P maiúsculo) | curl http://localhost:8080/Products |

### Try it — exemplos curl (bash)

```bash
# obter saudação
curl http://localhost:8080/hello

# listar todos (observe o caminho exato)
curl http://localhost:8080/Products

# obter produto por id (ex: id 1)
curl http://localhost:8080/products/1
```

### Testando com Postman (rápido)

1. Abra o Postman e crie uma nova requisição GET.
2. Use uma das URLs acima (ex.: `http://localhost:8080/Products`).
3. Clique em Send e veja a resposta em JSON (ou texto para `/hello`).
4. Dica: salve a requisição em uma coleção para fácil reuso.

## Arquivo de propriedades ⚙️

- `src/main/resources/application.properties`
  - Contém `spring.application.name=projectbackend`.
  - Aqui você pode adicionar outras configurações (porta, datasource, etc.) conforme aprender.

## Dependências e build 🛠️

- O projeto usa Maven. Dependências principais no `pom.xml`:
  - `spring-boot-starter-web` — traz Spring MVC/REST, Tomcat embutido e Jackson para JSON.
  - `spring-boot-devtools` — facilita desenvolvimento (reload automático).

