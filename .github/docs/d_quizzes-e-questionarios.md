# Quizzes e Avaliações

> [voltar](../../README.md) para a página anterior

## Sumário

- [Quizzes e Avaliações](#quizzes-e-avaliações)
  - [Sumário](#sumário)
  - [Módulo 3 - Rotas, Autenticação e Autorização](#módulo-3---rotas-autenticação-e-autorização)
    - [Quiz - Primeiros Passos](#quiz---primeiros-passos)
    - [Quiz - Autenticação e Autorização](#quiz---autenticação-e-autorização)
    - [Questionário Avaliativo do Módulo](#questionário-avaliativo-do-módulo)
  - [Módulo 4 - Documentação](#módulo-4---documentação)

## Módulo 3 - Rotas, Autenticação e Autorização

### Quiz - Primeiros Passos

1 - *Sobre os getters e setters, é correto afirmar:* **Resposta:** Getters e setters são utilizados para acessar e modificar atributos privados de uma classe.

2 - *Sobre o Lombok, é correto afirmar:* **Resposta:** O Lombok ajuda a reduzir a verbosidade do código Java, automatizando a geração de métodos padrão, como getters e setters.

3 - *O que é um banco de dados?* **Resposta:** Uma coleção de dados organizada de forma a facilitar o armazenamento, a recuperação e a análise.

4 - *No contexto da biblioteca Jakarta Validation em Java, qual é a finalidade principal da anotação `@NotNull`?* **Resposta:** A anotação `@NotNull` é usada para garantir que um campo de um objeto não seja nulo.

5 - *No contexto do Spring Boot, qual é o propósito principal de uma classe anotada com `@Controller`?* **Resposta:** A anotação `@Controller` é utilizada para criar controladores que manipulam requisições HTTP, fornecendo uma lógica de apresentação em uma aplicação web.

6 - *No contexto do Spring Framework, qual é o propósito principal da anotação `@Bean`* **Resposta:** Especificar que um método de configuração dentro de uma classe é responsável por criar e configurar um objeto gerenciado pelo container Spring.

### Quiz - Autenticação e Autorização

1 - *Qual é a finalidade principal do JSON Web Token (JWT) em sistemas de autenticação e autorização?* **Resposta:** Transmitir informações de autenticação e autorização entre sistemas.

2 - *Quais são as partes que compõem um token JWT (JSON Web Token)?* **Resposta:** Header, Payload e Signature.

3 - *Com base no código abaixo, qual é o propósito principal do método securityFilterChain e sua anotação `@Bean`?* **Resposta:**

4 - *No contexto da autenticação web, qual é o propósito principal do Bearer Token?* **Resposta:** Utilizado para autenticação em APIs, o Bearer Token é um tipo de token de acesso que é enviado no cabeçalho de uma requisição HTTP

5 - *No contexto do Spring Security, qual é o propósito da anotação `@PreAuthorize("hasRole('COLABORADORES')")`?* **Resposta:** Especifica que o método só pode ser acessado por usuários com a função "COLABORADORES".

### Questionário Avaliativo do Módulo

1 - *Qual é a finalidade das anotações `@AllArgsConstructor` e `@NoArgsConstructor` do Lombok em Java?* **Resposta:** `@AllArgsConstructor` gera automaticamente um construtor com todos os campos da classe como parâmetros, enquanto `@NoArgsConstructor` cria um construtor padrão sem argumentos.

2 - *Qual é a diferença entre JPA (Java Persistence API) e Hibernate no contexto de persistência de dados em Java?* **Resposta:** Hibernate é uma implementação específica de persistência de dados em Java, enquanto JPA é uma especificação padrão que define a API para manipulação de objetos persistentes.

3 - *No contexto do Java Persistence API (JPA), para que serve o conceito de "repository"?* **Resposta:** Em JPA, um "repository" é um componente que lida com a lógica de negócios e a manipulação de entidades, proporcionando uma camada de abstração sobre a interação com o banco de dados.

4 - *Qual é o propósito principal dos casos de uso (use cases) em Java no contexto de arquiteturas de software?* **Resposta:** Use cases em Java são usados para definir as regras de negócios e a lógica de aplicação, encapsulando as interações entre a camada de apresentação e a camada de persistência.

5 - *No contexto do Spring Boot, qual é a finalidade da anotação `@Entity` quando aplicada a uma classe Java?* **Resposta:** @Entity é aplicada para criar uma classe que representa uma tabela no banco de dados, permitindo a persistência de dados.

6 - *Qual é o propósito principal do Spring Security em um projeto baseado no framework Spring?* **Resposta:** Spring Security é um módulo de segurança que fornece autenticação e autorização em nível de aplicação, protegendo contra ameaças como autenticação falsa e autorização não autorizada.

7 - *Qual é a finalidade do Filter Chain em Java no contexto de aplicativos web?* **Resposta:** Em aplicações web Java, o Filter Chain é uma sequência de filtros que processa solicitações HTTP, permitindo a execução de lógica personalizada, como autenticação, autorização e manipulação de cabeçalhos.

8 - *Com base no código abaixo, qual é o objetivo principal da configuração do SecurityFilterChain em uma aplicação Spring Security?* **Resposta:** A configuração está definindo a autenticação obrigatória para todas as requisições, exceto para aquelas que possuem as subcaminhos "/games/" ou "/gamescompany/".

  ```java
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable());
    http.csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> {
        auth.requestMatchers("/games/").permitAll()
          .requestMatchers("/gamescompany/").permitAll();
        auth.anyRequest().authenticated();
      });
    return http.build();
    }
```

9 - *No código abaixo, o que está sendo realizado durante a criação e assinatura do token JWT (JSON Web Token)?* **Resposta:** O código está gerando um token JWT com informações do jogo, como identificador, funções ("roles") e um prazo de validade de 30 minutos.

  ```java
  var token = JWT.create()
    .withIssuer("jwttest")
    .withSubject(game.getId().toString())
    .withClaim("roles", Arrays.asList("game"))
    .withExpiresAt(Instant.now().plus(Duration.ofMinutes(30)))
    .sign(algorithm);

  var AuthGameResponse = AuthGameResponseDTO.builder().access_token(token).build();
```

10 - *No contexto de uma aplicação Spring Boot com autenticação baseada em JWT, o que acontece durante o processo de autorização?* **Resposta:** O servidor verifica a validade e as permissões do token JWT para conceder ou negar acesso a recursos.

> [retornar](#quizzes-e-avaliações) ao topo da página

## Módulo 4 - Documentação

1 - *Qual é o propósito “principal” da documentação de código?* **Resposta:** Facilitar a compreensão do código para desenvolvedores e colaboradores.

2 - *No contexto de documentação de API usando anotações como Swagger, o que representa a anotação `@Schema` no código abaixo?* **Resposta:** Especifica um modo de requisito obrigatório para o campo "Nome do candidato".

```java
@Schema(example = "Maria Gabriela", requiredMode = RequiredMode.REQUIRED, description = "Nome do candidato")
```

3 - *Qual é a função da anotação `@Operation` no Swagger no contexto da documentação de APIs?* **Resposta:** Documenta uma operação HTTP (por exemplo, GET, POST) para um endpoint específico da API.

4 - *O que a anotação `@Tag` é usada para realizar na documentação de APIs?* **Resposta:** Definir um rótulo descritivo para agrupar *endpoints* relacionados na documentação.

5 - *O que a anotação `@ApiResponses` com a configuração apresentada abaixo indica?* **Resposta:** Define uma resposta padrão para códigos de status HTTP bem-sucedidos, como 200 OK.

  ```java
  @ApiResponses({
  @ApiResponse(responseCode = "200", content = {
  @Content(array = @ArraySchema(schema = @Schema(implementation = JobEntity.class)))
  })
  })
```

6 - *Qual é o propósito da anotação `@SecurityScheme` no contexto do Swagger no desenvolvimento de APIs?* **Resposta:** Define o esquema de segurança utilizado para autenticação na API.

7 - *Qual é a função do método `openAPI()` no código abaixo?* **Resposta:** Cria uma documentação básica para a API com título e descrição.

  ```java
  public OpenAPI openAPI() {
  return new OpenAPI()
  .info(new Info().title("Gestão de Jogos").description("API responsável pela gestão de jogos").version("1"))
  .schemaRequirement("jwt_auth", createSecurityScheme());
  }
  ```

8 - *A anotação `@ApiResponse` no código abaixo indica que, em caso de falha na operação, o retorno da API será um objeto com o seguinte conteúdo:* **Resposta:** Um campo `message` do tipo `String` com o valor `"User not found"`.

```java
@ApiResponse(responseCode = "400", description = "User not found")
```

> [retornar](#quizzes-e-avaliações) ao topo da página
>
> [voltar](../../README.md) para a página anterior
