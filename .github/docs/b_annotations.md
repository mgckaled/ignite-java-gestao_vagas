# *Annottations*

## Sumario

> [voltar](../../README.md) para a página anterior

- [*Annottations*](#annottations)
  - [Sumario](#sumario)
  - [Spring Boot](#spring-boot)
    - [`@SpringBootApplication`](#springbootapplication)
    - [`@RestController`](#restcontroller)
    - [`@RequestMapping`](#requestmapping)
    - [`@RequestBody`](#requestbody)
    - [`@Autowired`](#autowired)
    - [`@Component`](#component)
    - [`@Service`](#service)
    - [`@Value`](#value)
    - [`@Configuration` e `@Bean`](#configuration-e-bean)
    - [`@ControllerAdvice`](#controlleradvice)
    - [`ExceptionHandler`](#exceptionhandler)
  - [Lombok](#lombok)
    - [`@Data`](#data)
    - [`@AllArgsConstructor`](#allargsconstructor)
    - [`@Builder`](#builder)
  - [Jakarta](#jakarta)
    - [`@Entity`](#entity)
    - [Persistense](#persistense)
    - [`@Valid`](#valid)
    - [Constraints](#constraints)
  - [Swagger](#swagger)
    - [`@Operation`](#operation)
    - [`@ArraySchema`](#arrayschema)
    - [`@Content`](#content)
    - [`@Schema`](#schema)
    - [`@ApiResponses`](#apiresponses)
    - [`@SecurityRequirement`](#securityrequirement)
    - [`@Tag`](#tag)
  - [Anotações de Testes](#anotações-de-testes)
    - [`@Test`](#test)
    - [`@DisplayName`](#displayname)
    - [`@ExtendWith`](#extendwith)
    - [`@Before` e `@BeforeEach`](#before-e-beforeeach)
    - [`@After` e `@AfterEach`](#after-e-aftereach)
  - [Mockito](#mockito)
    - [`@InjectMocks`](#injectmocks)
    - [`@Mock`](#mock)

## Spring Boot

### `@SpringBootApplication`

Anotação especial no Spring Boot que é usada para marcar uma classe principal (geralmente a classe que contém o método `public static void main(String[] args)`) e informar ao Spring Boot que esta classe é a entrada principal para a aplicação Spring Boot. Essa anotação combina várias outras anotações do Spring Framework em uma única anotação conveniente.

A anotação `@SpringBootApplication` realiza o seguinte:

1. `@Configuration`: Indica que a classe é uma classe de configuração do Spring, permitindo a definição de beans gerenciados pelo Spring no aplicativo.

2. `@EnableAutoConfiguration`: Habilita a configuração automática do Spring Boot, que configura automaticamente o aplicativo com base nas bibliotecas e no ambiente em uso.

3. `@ComponentScan`: Especifica os pacotes a serem explorados em busca de componentes gerenciados pelo Spring, como controladores, serviços e repositórios.

No geral, `@SpringBootApplication` é uma anotação conveniente para configurar rapidamente um aplicativo Spring Boot e iniciar a configuração automática. A partir da classe principal anotada com `@SpringBootApplication`, você pode iniciar seu aplicativo Spring Boot e deixar o Spring Boot cuidar de grande parte da configuração e inicialização da aplicação.

Aqui está um exemplo de uso da anotação `@SpringBootApplication` em uma classe principal:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinhaAplicacaoSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacaoSpringBoot.class, args);
    }
}
```

Neste exemplo, a classe `MinhaAplicacaoSpringBoot` é a classe principal, e `@SpringBootApplication` é usada para configurar e iniciar a aplicação Spring Boot.

> [retornar](#annottations) para o topo da página

### `@RestController`

Anotação usada como um controlador de API REST. Controladores são componentes importantes em um aplicativo Spring Boot que lidam com solicitações HTTP e retornam respostas no formato JSON, XML ou outros formatos específicos da web, geralmente para construir uma API RESTful.

Ao usar a anotação `@RestController`, você está basicamente combinando duas outras anotações:

1. `@Controller`: Indica que a classe é um controlador do Spring, responsável por lidar com solicitações HTTP. Um controlador tradicional (anotado com `@Controller`) retorna principalmente visualizações HTML.

2. `@ResponseBody`: Indica que os métodos da classe controladora retornam diretamente dados no corpo da resposta HTTP, em vez de visualizações HTML. No contexto de uma API REST, esse é o comportamento desejado, pois os controladores REST retornam normalmente dados serializados no formato JSON, XML ou outro formato.

Portanto, ao anotar uma classe com `@RestController`, você não precisa mais adicionar `@ResponseBody` aos métodos individuais da classe, uma vez que a anotação `@RestController` já inclui essa funcionalidade.

Aqui está um exemplo de uso da anotação `@RestController`:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExemploController {

    @GetMapping("/recurso")
    public String obterRecurso() {
        return "Este é um exemplo de recurso da API REST.";
    }

    // Outros métodos do controlador para manipular diferentes endpoints da API
}
```

Neste exemplo, a classe `ExemploController` é marcada como um controlador REST usando `@RestController`, e o método `obterRecurso` manipula uma solicitação GET em `/api/recurso` e retorna uma resposta no formato de texto. O Spring Boot cuidará de serializar a resposta no formato apropriado (geralmente JSON) antes de enviá-la de volta ao cliente.

> [retornar](#annottations) para o topo da página

### `@RequestMapping`

Anotação usada para mapear URLs a métodos específicos em controladores. Ela permite que você especifique qual método de um controlador deve ser chamado quando uma solicitação HTTP específica é feita para um determinado URL.

A anotação `@RequestMapping` pode ser usada em nível de classe ou em nível de método em uma classe controladora e fornece flexibilidade na definição de mapeamentos de URLs. Você pode especificar o caminho da URL, o método HTTP, os tipos de mídia aceitos e várias outras opções de mapeamento.

Aqui está um exemplo de uso da anotação `@RequestMapping` em nível de classe e método:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExemploController {

    @GetMapping("/recurso")
    public String obterRecurso() {
        return "Este é um exemplo de recurso da API REST.";
    }

    @RequestMapping(value = "/outrarecurso", method = RequestMethod.POST)
    public ResponseEntity<String> criarRecurso() {
        // Lógica para criar um recurso
        return new ResponseEntity<>("Recurso criado com sucesso", HttpStatus.CREATED);
    }
}
```

Neste exemplo, a classe `ExemploController` é marcada com `@RestController` e `@RequestMapping("/api")`, o que significa que todos os métodos dentro dessa classe serão acessíveis a partir de URLs que começam com `/api`.

- O método `obterRecurso` é mapeado para a URL `/api/recurso` usando `@GetMapping("/recurso")`, o que significa que ele será chamado quando uma solicitação GET for feita para essa URL.

- O método `criarRecurso` é mapeado para a URL `/api/outrarecurso` e só será chamado quando uma solicitação HTTP POST for feita para essa URL. Além disso, ele retorna uma resposta de status HTTP 201 (CREATED) com uma mensagem.

`@RequestMapping` fornece muitas outras opções para personalizar mapeamentos de URL, como a inclusão de parâmetros de consulta, cabeçalhos personalizados e tipos de mídia aceitos. É uma ferramenta flexível para criar controladores em uma aplicação Spring Boot e manipular solicitações HTTP de maneira eficaz.

> [retornar](#annottations) para o topo da página

### `@RequestBody`

A anotação `@RequestBody` faz parte do framework Spring e é usada em métodos de controladores (controllers) do Spring MVC para indicar que um determinado parâmetro do método deve ser vinculado ao corpo (body) da solicitação HTTP. Essa anotação é comumente usada em métodos que manipulam solicitações POST, PUT ou outras operações que enviam dados no corpo da solicitação.

Principais características da anotação `@RequestBody`:

1. **Vinculação de Dados do Corpo da Solicitação:**
   - A anotação `@RequestBody` é usada para vincular os dados do corpo da solicitação (payload) a um parâmetro do método. Isso é particularmente útil quando você está recebendo dados JSON, XML ou outro formato no corpo da solicitação HTTP.

2. **Deserialização Automática:**
   - O Spring MVC automaticamente deserializa os dados do corpo da solicitação para o tipo do parâmetro anotado com `@RequestBody`. A deserialização depende dos conversores de mensagens configurados no aplicativo, como o Jackson para JSON ou JAXB para XML.

3. **Usado em Métodos de Manipulação de Requisições:**
   - A anotação `@RequestBody` é geralmente usada em métodos de controladores que respondem a solicitações HTTP, especialmente métodos que tratam solicitações POST ou PUT, onde os dados são enviados no corpo da solicitação.

Exemplo de uso:

```java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuControlador {

    @PostMapping("/exemplo")
    public String exemploDePost(@RequestBody DadosRequisicao dados) {
        // Lógica para processar os dados recebidos no corpo da solicitação
        return "Dados recebidos com sucesso: " + dados.toString();
    }
}
```

Neste exemplo, o método `exemploDePost` recebe dados do corpo da solicitação através do parâmetro `dados`, que é anotado com `@RequestBody`. O Spring MVC cuida da desserialização automática dos dados do corpo da solicitação para o tipo `DadosRequisicao`.

A classe `DadosRequisicao` poderia ser algo como:

```java
public class DadosRequisicao {

    private String campo1;
    private int campo2;

    // Getters e Setters
}
```

A anotação `@RequestBody` é fundamental para integrar dados recebidos no corpo da solicitação com métodos de controladores no Spring MVC.

> [retornar](#annottations) para o topo da página

### `@Autowired`

A anotação `@Autowired` é usada no Spring Framework, incluindo o Spring Boot, para realizar a injeção de dependências automaticamente em componentes gerenciados pelo contêiner Spring, como serviços, controladores, repositórios e outros. Essa anotação é uma parte essencial do suporte à injeção de dependência no Spring, permitindo que você injete automaticamente beans (objetos) em outros beans sem a necessidade de criar instâncias manualmente.

A funcionalidade principal da anotação `@Autowired` é identificar e injetar automaticamente os beans necessários por tipo. Quando você anota um campo, um método setter ou um construtor com `@Autowired`, o contêiner Spring procurará por um bean que corresponda ao tipo desse campo, método ou construtor e o injetará automaticamente no componente.

Aqui está um exemplo simples de uso da anotação `@Autowired` em uma classe Spring Boot:

```java
@Service
public class MeuServico {

    private MeuRepositorio meuRepositorio;

    @Autowired
    public MeuServico(MeuRepositorio meuRepositorio) {
        this.meuRepositorio = meuRepositorio;
    }

    // Restante da lógica do serviço
}
```

Neste exemplo, o construtor de `MeuServico` é anotado com `@Autowired`, o que indica que o `MeuRepositorio` deve ser injetado automaticamente pelo Spring no momento da criação do `MeuServico`.

O uso de `@Autowired` torna o código mais limpo, ajuda a evitar a necessidade de criar manualmente instâncias de dependências e facilita a manutenção, tornando o gerenciamento de dependências no Spring mais eficiente. Note que, a partir da versão do Spring 4.3, a anotação `@Autowired` tornou-se opcional em construtores se houver apenas um construtor, mas ainda é comumente usada para maior clareza e consistência no código.

> [retornar](#annottations) para o topo da página

### `@Component`

A anotação `@Component` é uma das anotações principais do Spring Framework e é usada para indicar que uma classe é um componente gerenciado pelo contêiner Spring. Em particular, no contexto do Spring Boot, essa anotação é frequentemente usada para identificar classes que devem ser automaticamente escaneadas e registradas como beans no contexto do aplicativo.

Quando uma classe é marcada com `@Component`, o Spring irá detectá-la durante a varredura do classpath e registrá-la como um bean. Beans são objetos gerenciados pelo Spring, que são instanciados, configurados e injetados em outros objetos pelo contêiner Spring.

Exemplo:

```java
import org.springframework.stereotype.Component;

@Component
public class MinhaClasseComponent {
    // código da classe
}
```

Neste exemplo, a classe `MinhaClasseComponent` será automaticamente identificada e registrada como um bean quando o aplicativo Spring Boot for iniciado.

A anotação `@Component` é uma generalização, e existem anotações mais específicas que estendem `@Component`, como `@Service`, `@Repository` e `@Controller`, cada uma delas sendo usada para indicar um papel específico para a classe dentro da arquitetura de aplicativos Spring. No entanto, todas elas compartilham a funcionalidade básica de serem identificadas como componentes gerenciados pelo Spring.

> [retornar](#annottations) para o topo da página

### `@Service`

A anotação `@Service` é usada para marcar uma classe como um bean de serviço. Essa anotação é uma especialização da anotação `@Component` e é comumente usada para identificar classes de serviço na camada de negócios de uma aplicação.

Quando você marca uma classe com `@Service`, o Spring Boot a reconhece durante a varredura do classpath (escaneamento de componentes) e a registra como um bean no contexto do Spring. Beans anotados com `@Service` geralmente representam serviços ou lógica de negócios e são gerenciados pelo contêiner Spring.

A anotação `@Service` é útil por várias razões:

1. **Identificação Semântica:** A anotação ajuda a dar significado semântico ao papel da classe. Quando alguém vê `@Service`, isso sugere que a classe é uma parte do serviço ou da camada de negócios da aplicação.

2. **Injeção de Dependência:** Classes anotadas com `@Service` são elegíveis para injeção de dependência automática em outros componentes gerenciados pelo Spring, como controladores (`@Controller`) ou outros serviços.

3. **Tratamento Transacional:** O Spring fornece suporte transacional para métodos de classes marcadas com `@Service`. Isso significa que você pode usar transações declarativas para controlar a atomicidade das operações realizadas pelos métodos dessa classe.

Aqui está um exemplo simples de uma classe de serviço marcada com `@Service`:

```java
import org.springframework.stereotype.Service;

@Service
public class MeuServico {

    public String realizarOperacao() {
        // Lógica de negócios aqui
        return "Operação realizada com sucesso!";
    }
}
```

Essa classe `MeuServico` seria detectada e gerenciada pelo Spring como um bean de serviço. Pode então ser injetada em outras classes usando, por exemplo, a anotação `@Autowired`.

> [retornar](#annottations) para o topo da página

### `@Value`

Serve para injetar valores diretamente em propriedades de classes gerenciadas pelo contêiner Spring, como serviços, componentes, etc. Essa anotação é uma maneira de fornecer valores de propriedades a partir de várias fontes, como arquivos de propriedades, variáveis de ambiente, argumentos de linha de comando, entre outros.

A anotação `@Value` pode ser usada em métodos, campos ou construtores, e ela aceita expressões de linguagem de expressão de Spring (Spring Expression Language - SpEL). Aqui está um exemplo simples de como você pode usar a anotação `@Value`:

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Value("${my.property}")
    private String myProperty;

    // ... outros membros da classe
}
```

Neste exemplo, a propriedade `my.property` é injetada no campo `myProperty` da classe `MyComponent`. O valor dessa propriedade é geralmente definido em um arquivo de propriedades do Spring Boot ou em outras fontes externas.

Além disso, a anotação `@Value` pode ser usada para injetar valores diretamente em métodos ou construtores. Aqui está um exemplo com um método:

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    private String myProperty;

    @Value("${my.property}")
    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

    // ... outros membros da classe
}
```

Este método `setMyProperty` será chamado pelo contêiner Spring durante a inicialização, e o valor da propriedade `my.property` será passado como argumento para este método.

Em resumo, a anotação `@Value` é uma maneira conveniente de injetar valores em propriedades de componentes gerenciados pelo Spring Boot, proporcionando uma maior flexibilidade na configuração do aplicativo.

> [retornar](#annottations) para o topo da página

### `@Configuration` e `@Bean`

No Spring Boot, as annotations `@Configuration` e `@Bean` desempenham papéis importantes na configuração e definição de beans gerenciados pelo contêiner Spring.

1. **@Configuration:**
   - A anotação `@Configuration` é usada para marcar uma classe como uma classe de configuração no contexto do Spring. Isso significa que a classe contém métodos anotados com `@Bean` e pode ser usada para definir beans e suas configurações.
   - Classes anotadas com `@Configuration` são geralmente usadas para substituir a configuração XML tradicional, permitindo que você configure o contexto do Spring usando classes Java.

   Exemplo:

   ```java
   @Configuration
   public class AppConfig {
       // Métodos @Bean aqui
   }
   ```

2. **@Bean:**
   - A anotação `@Bean` é usada para indicar ao Spring que um método específico em uma classe `@Configuration` irá retornar um objeto que deve ser registrado como um bean no contexto do Spring.
   - O método anotado com `@Bean` é responsável por criar e configurar o bean que será gerenciado pelo contêiner Spring.

   Exemplo:

   ```java
   @Configuration
   public class AppConfig {
       @Bean
       public MinhaClasse meuBean() {
           return new MinhaClasse();
       }
   }
   ```

   Neste exemplo, o método `meuBean()` é um método de fábrica para a criação do bean `MinhaClasse`. Quando o Spring inicializa, ele detecta a classe `AppConfig`, identifica o método anotado com `@Bean`, chama esse método para obter a instância do bean e a registra no contexto do Spring.

Em resumo, `@Configuration` é usada para marcar classes que contêm métodos `@Bean`, enquanto `@Bean` é usado para marcar métodos que definem beans no contexto do Spring. Juntas, essas anotações ajudam a configurar e gerenciar beans no Spring Boot.

> [retornar](#annottations) para o topo da página

### `@ControllerAdvice`

A anotação `@ControllerAdvice` faz parte do framework Spring, mais especificamente do módulo Spring MVC. Ela é usada para definir classes globais que fornecem manipulação centralizada de exceções e vinculações de dados para os controladores. Essas classes podem conter métodos anotados com `@ExceptionHandler`, `@InitBinder` e `@ModelAttribute`, que serão aplicados globalmente a todos os controladores.

Aqui estão as principais funcionalidades associadas à anotação `@ControllerAdvice`:

1. **Tratamento Global de Exceções (`@ExceptionHandler`):**
   - Métodos anotados com `@ExceptionHandler` em classes marcadas com `@ControllerAdvice` podem ser usados para tratar exceções de maneira centralizada. Esses métodos capturam exceções lançadas por qualquer controlador da aplicação e definem como lidar com elas.

2. **Customização do Vinculador de Dados (`@InitBinder`):**
   - Métodos anotados com `@InitBinder` são usados para personalizar o processo de vinculação de dados no Spring MVC. Eles permitem configurar propriedades personalizadas do vinculador de dados para todos os controladores da aplicação.

3. **Atributos Globais (`@ModelAttribute`):**
   - Métodos anotados com `@ModelAttribute` em uma classe `@ControllerAdvice` são usados para adicionar atributos globais a todos os modelos que retornam para as visualizações. Esses atributos são disponibilizados para todos os métodos de todos os controladores.

4. **Escopo Global:**
   - A anotação `@ControllerAdvice` permite que você defina manipuladores globais para diferentes aspectos do ciclo de vida de uma solicitação, proporcionando uma maneira centralizada de gerenciar a lógica comum em toda a aplicação.

Aqui está um exemplo básico de uso da anotação `@ControllerAdvice`:

```java
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        // Lógica para lidar com a exceção globalmente
        return "error"; // Nome da página de erro
    }
}
```

Neste exemplo, o método `handleException` será chamado sempre que ocorrer uma exceção do tipo `Exception` em qualquer controlador da aplicação, permitindo um tratamento centralizado da exceção.

Em resumo, `@ControllerAdvice` é uma anotação poderosa no Spring MVC que oferece uma maneira eficaz de centralizar o tratamento de exceções, personalizar o vinculador de dados e fornecer atributos globais para modelos em toda a aplicação.

> [retornar](#annottations) para o topo da página

### `ExceptionHandler`

A anotação `@ControllerAdvice` faz parte do framework Spring, mais especificamente do módulo Spring MVC. Ela é usada para definir classes globais que fornecem manipulação centralizada de exceções e vinculações de dados para os controladores. Essas classes podem conter métodos anotados com `@ExceptionHandler`, `@InitBinder` e `@ModelAttribute`, que serão aplicados globalmente a todos os controladores.

Aqui estão as principais funcionalidades associadas à anotação `@ControllerAdvice`:

1. **Tratamento Global de Exceções (`@ExceptionHandler`):**
   - Métodos anotados com `@ExceptionHandler` em classes marcadas com `@ControllerAdvice` podem ser usados para tratar exceções de maneira centralizada. Esses métodos capturam exceções lançadas por qualquer controlador da aplicação e definem como lidar com elas.

2. **Customização do Vinculador de Dados (`@InitBinder`):**
   - Métodos anotados com `@InitBinder` são usados para personalizar o processo de vinculação de dados no Spring MVC. Eles permitem configurar propriedades personalizadas do vinculador de dados para todos os controladores da aplicação.

3. **Atributos Globais (`@ModelAttribute`):**
   - Métodos anotados com `@ModelAttribute` em uma classe `@ControllerAdvice` são usados para adicionar atributos globais a todos os modelos que retornam para as visualizações. Esses atributos são disponibilizados para todos os métodos de todos os controladores.

4. **Escopo Global:**
   - A anotação `@ControllerAdvice` permite que você defina manipuladores globais para diferentes aspectos do ciclo de vida de uma solicitação, proporcionando uma maneira centralizada de gerenciar a lógica comum em toda a aplicação.

Aqui está um exemplo básico de uso da anotação `@ControllerAdvice`:

```java
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        // Lógica para lidar com a exceção globalmente
        return "error"; // Nome da página de erro
    }
}
```

Neste exemplo, o método `handleException` será chamado sempre que ocorrer uma exceção do tipo `Exception` em qualquer controlador da aplicação, permitindo um tratamento centralizado da exceção.

Em resumo, `@ControllerAdvice` é uma anotação poderosa no Spring MVC que oferece uma maneira eficaz de centralizar o tratamento de exceções, personalizar o vinculador de dados e fornecer atributos globais para modelos em toda a aplicação.

> [retornar](#annottations) para o topo da página

## Lombok

### `@Data`

A anotação `@Data` é uma característica do Projeto Lombok e é frequentemente usada em classes Java para reduzir a quantidade de código boilerplate relacionado a métodos como getters, setters, `toString()`, `equals()`, e `hashCode()`. Ao aplicar a anotação `@Data` a uma classe, o Lombok gera automaticamente esses métodos, tornando o código mais conciso e fácil de manter.

A anotação `@Data` combina funcionalidades de outras anotações do Lombok, como `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`, e `@RequiredArgsConstructor`. Portanto, ao usar `@Data`, você obtém automaticamente os benefícios dessas outras anotações.

Aqui está um exemplo simples:

```java
import lombok.Data;

@Data
public class Exemplo {
    private String nome;
    private int idade;
}
```

Neste exemplo, a anotação `@Data` está sendo usada na classe `Exemplo`. O Lombok irá automaticamente gerar os métodos `toString()`, `equals()`, `hashCode()`, bem como os getters e setters para as propriedades `nome` e `idade`. Isso reduz a quantidade de código que você precisa escrever manualmente, melhorando a legibilidade e a manutenção do código.

> [retornar](#annottations) para o topo da página

### `@AllArgsConstructor`

A anotação `@AllArgsConstructor` faz parte do projeto Lombok em Java. Lombok é uma biblioteca que ajuda a reduzir a verbosidade do código Java, automatizando a geração de métodos comuns, como construtores, getters, setters e métodos `equals` e `hashCode`.

A anotação `@AllArgsConstructor` é usada para gerar automaticamente um construtor que aceita todos os campos da classe como parâmetros. Em outras palavras, ela cria um construtor que inicializa todos os atributos da classe com base nos parâmetros fornecidos, evitando a necessidade de escrever manualmente construtores extensos.

Aqui está um exemplo de uso:

```java
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Exemplo {

    private int numero;
    private String texto;
    private boolean flag;
}
```

Com a anotação `@AllArgsConstructor`, o código acima é equivalente a escrever o seguinte construtor manualmente:

```java
public class Exemplo {

    private int numero;
    private String texto;
    private boolean flag;

    public Exemplo(int numero, String texto, boolean flag) {
        this.numero = numero;
        this.texto = texto;
        this.flag = flag;
    }
}
```

Ao usar o Lombok com a anotação `@AllArgsConstructor`, você pode simplificar a criação de construtores, especialmente em classes com muitos atributos, tornando o código mais conciso e fácil de manter.

> [retornar](#annottations) para o topo da página

### `@Builder`

A anotação `@Builder` faz parte da biblioteca Lombok no contexto do Java e é usada para simplificar a criação de padrões de construtor, seguindo o padrão de design conhecido como "Builder Pattern". O padrão de construtor é frequentemente utilizado quando uma classe tem muitos atributos opcionais e oferece uma maneira mais flexível e legível de construir objetos.

Ao aplicar a anotação `@Builder` a uma classe, o Lombok gera automaticamente um construtor que aceita todos os atributos da classe como parâmetros. Além disso, ele cria um construtor de "construção" (builder) interno que permite a construção do objeto passo a passo, definindo os valores desejados atributo por atributo.

Aqui está um exemplo simples de como você pode usar a anotação `@Builder`:

```java
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExemploBuilder {
    private String nome;
    private int idade;
    private String endereco;

    public static void main(String[] args) {
        ExemploBuilder pessoa = ExemploBuilder.builder()
                .nome("João")
                .idade(25)
                .endereco("Rua ABC, 123")
                .build();

        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getIdade());
        System.out.println(pessoa.getEndereco());
    }
}
```

Neste exemplo, a anotação `@Builder` elimina a necessidade de escrever manualmente um construtor com diversos parâmetros e fornece um construtor de "construção" que simplifica a criação de instâncias da classe `ExemploBuilder`.

Ao usar o padrão de construtor, você pode criar objetos de maneira mais legível e evitar construtores com muitos parâmetros, tornando seu código mais fácil de entender e manter.

> [retornar](#annottations) para o topo da página

## Jakarta

### `@Entity`

A anotação `@Entity` faz parte da especificação Jakarta Persistence (anteriormente Java Persistence API ou JPA) e é usada para marcar uma classe como uma entidade persistente. Em outras palavras, essa anotação indica que a classe está associada a uma tabela em um banco de dados relacional.

Principais características da anotação `@Entity`:

1. **Associação a uma Tabela:**
   - A anotação `@Entity` associa a classe a uma tabela no banco de dados. Cada instância da classe representa uma linha nessa tabela.

2. **Identificação da Classe como Entidade:**
   - A presença da anotação `@Entity` indica ao provedor de persistência que a classe deve ser gerenciada pelo JPA, e os objetos dessa classe podem ser armazenados e recuperados de um banco de dados.

3. **Mapeamento de Atributos para Colunas:**
   - Atributos da classe são mapeados para colunas na tabela associada. Isso é geralmente feito usando outras anotações, como `@Id` para a chave primária, `@Column` para mapear colunas específicas, etc.

Exemplo de uso:

```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Produto {

    @Id
    private Long id;

    @Column(name = "nome_produto")
    private String nome;

    @Column
    private double preco;

    // Getters e Setters
}
```

Neste exemplo, a classe `Produto` é marcada como uma entidade persistente usando a anotação `@Entity`. Os atributos `id`, `nome` e `preco` são mapeados para colunas na tabela associada. A anotação `@Id` é usada para indicar a chave primária.

Ao utilizar a anotação `@Entity` e outras anotações relacionadas à persistência, você pode criar classes Java que são automaticamente mapeadas para tabelas de banco de dados, facilitando o uso de objetos Java para interagir com dados persistentes em um banco de dados relacional.

> [retornar](#annottations) para o topo da página

### Persistense

As anotações `@Column`, `@GeneratedValue`, `@Id`, e `@ManyToOne` fazem parte da especificação Jakarta Persistence (anteriormente Java Persistence API ou JPA) e são usadas para mapear entidades e estabelecer relações entre elas em um banco de dados relacional.

1. **`@Id` e `@GeneratedValue`:**
   - A anotação `@Id` é usada para identificar a chave primária da entidade, e a anotação `@GeneratedValue` é usada para indicar a estratégia de geração de valores para essa chave primária.

   ```java
   import jakarta.persistence.Id;
   import jakarta.persistence.GeneratedValue;
   import jakarta.persistence.GenerationType;

   public class Produto {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       // outros atributos, getters e setters
   }
   ```

2. **`@Column`:**
   - A anotação `@Column` é usada para mapear um atributo da classe para uma coluna específica no banco de dados. Você pode usar essa anotação para personalizar o nome da coluna, o tipo de dados, etc.

   ```java
   import jakarta.persistence.Column;

   public class Produto {

       @Column(name = "nome_produto", nullable = false)
       private String nome;

       // outros atributos, getters e setters
   }
   ```

3. **`@ManyToOne` e `@JoinColumn`:**
   - As anotações `@ManyToOne` e `@JoinColumn` são usadas para representar relacionamentos muitos-para-um entre entidades. Elas são usadas no lado "muitos" do relacionamento.

   ```java
   import jakarta.persistence.ManyToOne;
   import jakarta.persistence.JoinColumn;

   public class ItemPedido {

       @ManyToOne
       @JoinColumn(name = "produto_id", nullable = false)
       private Produto produto;

       // outros atributos, getters e setters
   }
   ```

Essas anotações são fundamentais ao modelar a persistência de dados em um aplicativo Java usando JPA. Elas ajudam a definir como as entidades são mapeadas para tabelas do banco de dados e como os relacionamentos entre essas entidades são representados.

> [retornar](#annottations) para o topo da página

### `@Valid`

A anotação `@Valid` em Jakarta EE (anteriormente Java EE) é utilizada para indicar que a validação do bean deve ser executada durante a execução de um método ou construtor.

Essa anotação é geralmente usada em parâmetros de métodos ou construtores de CDI (Contexts and Dependency Injection) para garantir que a validação de bean seja realizada nos objetos passados como argumentos.

Exemplo de uso:

```java
import jakarta.validation.Valid;

public class ExemploService {

    public void processarEntidade(@Valid Entidade entidade) {
        // Lógica do serviço
    }
}
```

Neste exemplo, a anotação `@Valid` é aplicada ao parâmetro `entidade` no método `processarEntidade`. Isso indica que a validação de bean deve ser executada no objeto `Entidade` fornecido como argumento. Se houver violações de validação, uma exceção `ConstraintViolationException` será lançada.

Essa anotação é parte da API de Validação do Bean (Bean Validation) e está relacionada à validação de dados em objetos Java. A validação de bean permite definir regras de validação declarativamente em classes de modelo e aplicá-las automaticamente durante a execução do código.

É importante notar que o pacote `jakarta.validation` é usado em Jakarta EE, que é uma evolução do Java EE. Anteriormente, no Java EE, o pacote correspondente era `javax.validation`. As classes e anotações relacionadas à validação de bean são semelhantes entre esses dois contextos.

> [retornar](#annottations) para o topo da página

### Constraints

As anotações `@Email`, `@NotBlank`, e `@Pattern` fazem parte da especificação Jakarta Bean Validation (anteriormente Bean Validation ou JSR 380) e são utilizadas para aplicar restrições de validação em campos de uma classe, normalmente associada a atributos de entidades ou objetos DTO (Data Transfer Object).

1. **`@Email`:**
   - A anotação `@Email` é usada para validar se um campo é um endereço de e-mail válido. Ela verifica se o valor fornecido segue o formato padrão de um endereço de e-mail.

   ```java
   import jakarta.validation.constraints.Email;

   public class ExemploDTO {

       @Email(message = "O formato do e-mail não é válido")
       private String email;

       // Getters e Setters
   }
   ```

2. **`@NotBlank`:**
   - A anotação `@NotBlank` valida se uma string não é nula e seu comprimento é maior que zero, ou seja, se ela contém algum caractere não em branco.

   ```java
   import jakarta.validation.constraints.NotBlank;

   public class ExemploDTO {

       @NotBlank(message = "O campo não pode estar em branco")
       private String nome;

       // Getters e Setters
   }
   ```

3. **`@Pattern`:**
   - A anotação `@Pattern` é usada para validar se um campo atende a um padrão específico definido por uma expressão regular.

   ```java
   import jakarta.validation.constraints.Pattern;

   public class ExemploDTO {

       @Pattern(regexp = "[0-9]{3}-[0-9]{2}-[0-9]{4}", message = "Formato do CPF inválido")
       private String cpf;

       // Getters e Setters
   }
   ```

Essas anotações são poderosas ferramentas para garantir a integridade e validade dos dados em uma aplicação Java. Quando utilizadas, elas especificam as regras que os campos devem seguir, e o mecanismo de validação do Bean Validation as aplica automaticamente, lançando exceções caso as regras não sejam atendidas. Essas exceções podem ser capturadas e tratadas pela lógica da aplicação.

## Swagger

### `@Operation`

A anotação `@Operation` faz parte da especificação OpenAPI (anteriormente conhecida como Swagger) versão 3 para documentação de APIs em Java. Essa anotação é usada para descrever as operações (métodos) disponíveis em um controlador ou classe de API, fornecendo informações detalhadas sobre essas operações para a geração automática de documentação.

Principais características da anotação `@Operation`:

1. **Descrição de Operação:**
   - A anotação `@Operation` é usada para fornecer uma descrição detalhada de uma operação (método) em uma API. Isso inclui informações como o resumo da operação, descrição mais detalhada, tags associadas e outras propriedades.

2. **Parâmetros e Respostas:**
   - A anotação `@Operation` pode ser usada para descrever parâmetros de entrada, códigos de resposta e outros detalhes relacionados à operação. Isso ajuda na geração de documentação precisa e compreensível.

3. **Agrupamento por Tags:**
   - Você pode agrupar operações usando tags, fornecendo uma maneira de organizar e categorizar as operações na documentação.

4. **Personalização da Documentação:**
   - A anotação `@Operation` permite personalizar a documentação da API, tornando-a mais informativa e fácil de entender para os consumidores da API.

Exemplo de uso:

```java
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public class ExemploControlador {

    @Operation(
        summary = "Endpoint para criar um novo recurso",
        description = "Este endpoint cria um novo recurso com base nos dados fornecidos.",
        tags = { "Recurso" }
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
        }
    )
    @RequestBody(description = "Dados do recurso a ser criado")
    public void criarRecurso() {
        // Lógica de criação do recurso
    }
}
```

Neste exemplo, a anotação `@Operation` é usada para descrever a operação de criação de um recurso. Ela fornece um resumo, uma descrição mais detalhada e associa a operação à tag "Recurso". A anotação `@ApiResponses` descreve as possíveis respostas HTTP que a operação pode retornar, e `@RequestBody` fornece detalhes sobre os dados esperados no corpo da solicitação.

Essas anotações são essenciais para documentar APIs de forma eficaz e gerar automaticamente documentação legível e compreensível usando ferramentas compatíveis com OpenAPI, como o Swagger UI.

> [retornar](#annottations) para o topo da página

### `@ArraySchema`

A anotação `@ArraySchema` faz parte da especificação OpenAPI (anteriormente conhecida como Swagger) versão 3 em Java. Essa anotação é utilizada para descrever um esquema de array dentro do contexto de documentação de API, fornecendo informações sobre o array, como tipo de itens, tamanho mínimo e máximo, etc.

Principais características da anotação `@ArraySchema`:

1. **Tipo de Itens do Array:**
   - A anotação `@ArraySchema` permite especificar o tipo de itens que o array contém. Isso é útil para a geração automática de documentação, onde é importante entender a estrutura dos dados em um array.

2. **Tamanho Mínimo e Máximo:**
   - Você pode definir o tamanho mínimo e máximo esperado do array usando as propriedades `minItems` e `maxItems`. Isso fornece informações sobre a validação esperada do tamanho do array.

3. **Permitir Itens Nulos:**
   - A propriedade `uniqueItems` permite especificar se os itens no array devem ser únicos.

Exemplo de uso:

```java
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

public class ExemploDto {

    @ArraySchema(
        arraySchema = @Schema(
            description = "Lista de itens",
            minItems = 1,
            maxItems = 10,
            uniqueItems = true
        ),
        schema = @Schema(implementation = ItemDto.class)
    )
    private List<ItemDto> itens;

    // Getters e Setters
}
```

Neste exemplo, a anotação `@ArraySchema` é aplicada a um campo `itens` em uma classe chamada `ExemploDto`. O esquema do array é definido usando a anotação `@Schema` dentro de `@ArraySchema`. São fornecidas informações como descrição, tamanho mínimo e máximo e se os itens devem ser únicos.

A classe `ItemDto` seria uma classe que representa o tipo de itens no array.

Essa anotação é útil para descrever a estrutura e as características de arrays em sua API, facilitando a geração de documentação precisa e compreensível usando ferramentas compatíveis com OpenAPI, como o Swagger UI.

> [retornar](#annottations) para o topo da página

### `@Content`

A anotação `@Content` faz parte da especificação OpenAPI (anteriormente conhecida como Swagger) versão 3 para documentação de APIs em Java. Ela é usada para descrever o conteúdo de uma resposta ou solicitação HTTP, incluindo os tipos de mídia (media types) suportados e os esquemas associados a esses tipos de mídia.

Principais características da anotação `@Content`:

1. **Especificação de Tipos de Mídia:**
   - A anotação `@Content` é usada para especificar os tipos de mídia (media types) suportados para um determinado conteúdo. Isso inclui tipos como `application/json`, `application/xml`, etc.

2. **Associação com Esquemas (`@Schema`):**
   - A anotação `@Content` pode ser associada a esquemas (schemas) usando a anotação `@Schema`. Isso descreve a estrutura dos dados associados ao tipo de mídia.

3. **Exemplos (`@Example`):**
   - É possível incluir exemplos de dados associados ao conteúdo usando a anotação `@Example`. Isso fornece exemplos concretos que podem ajudar na compreensão do formato dos dados.

Exemplo de uso:

```java
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;

public class RespostaDto {

    @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = RespostaDetalhadaDto.class),
        examples = @ExampleObject(value = "{ \"id\": 123, \"nome\": \"Exemplo\" }")
    )
    private RespostaDetalhadaDto detalhes;

    // Getters e Setters
}
```

Neste exemplo, a anotação `@Content` é aplicada a um campo chamado `detalhes` em uma classe chamada `RespostaDto`. Ela especifica que o conteúdo da resposta é do tipo `application/json` e está associado ao esquema definido pela classe `RespostaDetalhadaDto`. Além disso, um exemplo JSON é fornecido usando a anotação `@ExampleObject`.

A classe `RespostaDetalhadaDto` seria uma classe que representa a estrutura dos dados associados ao conteúdo.

A anotação `@Content` é crucial para descrever detalhes sobre o conteúdo das respostas ou solicitações em uma API, o que é fundamental para a geração precisa de documentação usando ferramentas compatíveis com OpenAPI, como o Swagger UI.

> [retornar](#annottations) para o topo da página

### `@Schema`

A anotação `@Schema` faz parte da especificação OpenAPI (anteriormente conhecida como Swagger) versão 3 em Java. Essa anotação é usada para descrever as propriedades e o comportamento de um esquema de dados, que pode representar um objeto, uma coleção, uma resposta ou qualquer outra estrutura de dados utilizada em uma API.

Principais características da anotação `@Schema`:

1. **Descrição do Esquema:**
   - A anotação `@Schema` é usada para fornecer informações detalhadas sobre um esquema, incluindo a descrição geral do esquema.

2. **Nome do Esquema:**
   - Pode-se especificar o nome do esquema usando a propriedade `name`. Isso é útil para identificar o esquema quando usado em outras partes da documentação.

3. **Tipo de Dados (`type`):**
   - A propriedade `type` permite especificar o tipo de dados associado ao esquema, como "object", "array", "string", "integer", etc.

4. **Formato (`format`):**
   - A propriedade `format` é usada para fornecer informações adicionais sobre o formato dos dados, como "date", "date-time", "email", etc., dependendo do tipo de dados.

5. **Exemplo (`example`):**
   - A propriedade `example` permite fornecer um exemplo concreto dos dados associados ao esquema. Isso ajuda na compreensão do formato dos dados.

Exemplo de uso:

```java
import io.swagger.v3.oas.annotations.media.Schema;

public class ExemploDto {

    @Schema(description = "Identificador único", example = "123")
    private Long id;

    @Schema(description = "Nome do objeto", required = true)
    private String nome;

    @Schema(description = "Quantidade de itens", minimum = "0")
    private int quantidade;

    // Getters e Setters
}
```

Neste exemplo, a anotação `@Schema` é aplicada a campos da classe `ExemploDto` para descrever propriedades específicas do esquema. O campo `id` é um exemplo de um identificador único, o campo `nome` é uma propriedade obrigatória e o campo `quantidade` tem um valor mínimo especificado.

A anotação `@Schema` é fundamental para descrever detalhes sobre a estrutura dos dados em uma API, ajudando na geração precisa de documentação usando ferramentas compatíveis com OpenAPI, como o Swagger UI.

> [retornar](#annottations) para o topo da página

### `@ApiResponses`

A anotação `@ApiResponses` faz parte da especificação OpenAPI (anteriormente conhecida como Swagger) versão 3 em Java. Ela é usada para agrupar várias anotações `@ApiResponse`, permitindo a descrição de respostas HTTP específicas para operações (métodos) em uma API.

Principais características da anotação `@ApiResponses`:

1. **Agrupamento de Respostas:**
   - A anotação `@ApiResponses` é usada para agrupar várias anotações `@ApiResponse` sob uma única anotação, facilitando a organização e leitura do código.

2. **Mapeamento de Códigos de Resposta:**
   - Permite mapear códigos de resposta HTTP para métodos específicos de uma API. Cada `@ApiResponse` dentro de `@ApiResponses` pode especificar um código de resposta HTTP, uma descrição e detalhes adicionais, como referências a modelos ou exemplos.

Exemplo de uso:

```java
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@ApiResponses({
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
    @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
})
public class ExemploControlador {

    // Código do método
}
```

Neste exemplo, a anotação `@ApiResponses` é aplicada à classe `ExemploControlador`, agrupando várias anotações `@ApiResponse`. Cada `@ApiResponse` especifica um código de resposta HTTP e uma descrição correspondente.

Essas anotações são fundamentais para descrever as possíveis respostas de uma operação em uma API, fornecendo informações detalhadas sobre o comportamento esperado da API. Elas são utilizadas na geração automática de documentação usando ferramentas compatíveis com OpenAPI, como o Swagger UI.

> [retornar](#annottations) para o topo da página

### `@SecurityRequirement`

A anotação `@SecurityRequirement` faz parte da especificação OpenAPI (anteriormente conhecida como Swagger) versão 3 em Java. Essa anotação é utilizada para especificar os requisitos de segurança associados a uma operação (método) ou à API como um todo. Ela é usada para indicar como as solicitações para a operação ou API devem ser autenticadas e autorizadas.

Principais características da anotação `@SecurityRequirement`:

1. **Requisitos de Segurança Globais:**
   - Pode ser aplicada a uma classe de controlador (controller) para definir requisitos de segurança globais para todas as operações na classe.

2. **Requisitos de Segurança Locais:**
   - Também pode ser aplicada a métodos específicos para definir requisitos de segurança específicos para operações individuais.

3. **Lista de Esquemas de Segurança:**
   - Permite especificar uma lista de esquemas de segurança (`security schemes`) que devem ser atendidos para acessar a operação ou a API.

Exemplo de uso:

```java
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "jwt-token")
public class ExemploControlador {

    // Código do método
}
```

Neste exemplo, a anotação `@SecurityRequirement` é aplicada à classe `ExemploControlador`, indicando que a autenticação deve ser realizada usando um esquema de segurança chamado "jwt-token". Esse esquema deve ser definido em outro lugar na documentação OpenAPI, geralmente usando a anotação `@SecurityScheme`.

É importante observar que a anotação `@SecurityRequirement` é apenas uma parte do modelo de segurança em OpenAPI, e geralmente é utilizada em conjunto com outras anotações, como `@SecurityScheme`, para fornecer uma descrição abrangente dos requisitos de segurança da API.

Essas anotações são cruciais para descrever como a autenticação e a autorização devem ser tratadas em uma API, ajudando na geração precisa de documentação usando ferramentas compatíveis com OpenAPI, como o Swagger UI.

> [retornar](#annottations) para o topo da página

### `@Tag`

A anotação `@Tag` faz parte da especificação OpenAPI (anteriormente conhecida como Swagger) versão 3 em Java. Essa anotação é utilizada para adicionar informações de tag a uma classe de controlador (controller) ou a um método específico, facilitando a organização e categorização da documentação da API.

Principais características da anotação `@Tag`:

1. **Categorização de Operações:**
   - A anotação `@Tag` é usada para adicionar informações de tag a uma classe de controlador ou a um método específico. Essas tags são usadas para categorizar operações na documentação OpenAPI.

2. **Descrição da Tag:**
   - Permite incluir uma descrição para a tag, fornecendo informações adicionais sobre o propósito ou o contexto da categoria.

3. **Organização da Documentação:**
   - As tags ajudam a organizar a documentação da API, agrupando operações relacionadas sob categorias específicas.

Exemplo de uso:

```java
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clientes", description = "Operações relacionadas a clientes")
public class ClienteControlador {

    // Código do método
}
```

Neste exemplo, a anotação `@Tag` é aplicada à classe `ClienteControlador`, indicando que as operações nesta classe estão relacionadas a clientes. A descrição fornece mais informações sobre o propósito dessa categoria.

Ao usar essa anotação em vários controladores ou métodos, você pode organizar a documentação da sua API de maneira mais clara e compreensível.

Essa anotação é especialmente útil quando há muitas operações em sua API, permitindo que você as organize em categorias significativas para facilitar a navegação na documentação gerada usando ferramentas compatíveis com OpenAPI, como o Swagger UI.

> [retornar](#annottations) para o topo da página

## Anotações de Testes

### `@Test`

A anotação `@Test` faz parte do framework de teste JUnit 5, específicamente do módulo JUnit Jupiter (`org.junit.jupiter.api`). Essa anotação é usada para marcar um método como um método de teste. Quando você executa os testes, o JUnit Jupiter identifica e executa todos os métodos marcados com `@Test`.

Aqui estão algumas características e funcionalidades associadas à anotação `@Test`:

1. **Identificação de Métodos de Teste:**
   - Ao marcar um método com `@Test`, você está indicando ao JUnit que este método contém lógica de teste. Durante a execução dos testes, o JUnit executa todos os métodos marcados como testes.

2. **Asserções:**
   - Dentro de um método marcado com `@Test`, você geralmente encontra asserções que verificam se determinadas condições são verdadeiras. As asserções são usadas para validar o comportamento esperado do código sendo testado.

3. **Ciclo de Vida do Teste:**
   - O JUnit oferece métodos de ciclo de vida, como `@BeforeEach` e `@AfterEach`, que podem ser usados para executar código de configuração ou limpeza antes e depois de cada método de teste marcado com `@Test`. Isso ajuda a garantir um estado consistente antes da execução de cada teste.

4. **Parâmetros de Teste (JUnit 5+):**
   - O JUnit 5 introduziu a capacidade de passar parâmetros para métodos de teste. Você pode utilizar a anotação `@ParameterizedTest` ou `@ValueSource` para testes parametrizados.

5. **Testes de Exceção (JUnit 4):**
   - No JUnit 4, para testar exceções, você pode usar a atributo `expected` da anotação `@Test`. Já no JUnit 5, o suporte a testes de exceção foi aprimorado com a anotação `@Test` suportando diretamente a assertiva de exceção.

Exemplo de uso básico:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeuTeste {

    @Test
    public void meuMetodoDeTeste() {
        // Lógica de teste e asserções aqui
        assertEquals(2, 1 + 1);
    }
}
```

Neste exemplo, o método `meuMetodoDeTeste` é marcado como um teste usando `@Test`, e a asserção `assertEquals` verifica se a soma de 1 + 1 é igual a 2. Se a asserção falhar, o teste é considerado como falhado.

> [retornar](#annottations) para o topo da página

### `@DisplayName`

A anotação `@DisplayName` faz parte do framework de teste JUnit 5 (JUnit Jupiter) e é utilizada para fornecer um nome mais descritivo aos métodos de teste. Ela não afeta o resultado dos testes, mas pode ser útil para tornar os relatórios de testes mais legíveis e compreensíveis. Essa anotação é opcional e é uma prática recomendada para melhorar a clareza dos relatórios de execução de testes.

Aqui está um exemplo de como a anotação `@DisplayName` pode ser usada em conjunto com a anotação `@Test`:

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeuTeste {

    @Test
    @DisplayName("Teste de soma")
    public void meuMetodoDeTeste() {
        // Lógica de teste e asserções aqui
        assertEquals(2, 1 + 1);
    }
}
```

Neste exemplo, o método de teste `meuMetodoDeTeste` está marcado com a anotação `@DisplayName("Teste de soma")`. Isso significa que, ao executar os testes, o relatório indicará que este teste específico tem o nome "Teste de soma". Isso pode ser particularmente útil quando você tem muitos testes e deseja tornar o propósito de cada teste mais claro no relatório de execução.

Lembrando que a anotação `@DisplayName` é completamente opcional, e se não for fornecida, o nome do método de teste será utilizado nos relatórios padrão de execução de testes.

> [retornar](#annottations) para o topo da página

### `@ExtendWith`

A anotação `@ExtendWith` é parte do framework de teste JUnit 5 (JUnit Jupiter) e é utilizada para registrar extensões (extensions) que podem ser usadas para estender o comportamento dos testes. As extensões são uma forma de modularizar e reutilizar código que precisa ser compartilhado entre vários testes.

Aqui estão alguns pontos importantes sobre a anotação `@ExtendWith`:

1. **Registro de Extensões:**
   - `@ExtendWith` é usada para registrar uma ou mais classes que implementam a interface `Extension` (ou suas subinterfaces). Essas classes são então consideradas como extensões que afetam o comportamento dos testes.

2. **Uso de Extensões:**
   - As extensões podem ser utilizadas para adicionar funcionalidades extras aos testes, como ações de inicialização e limpeza, manipulação de contexto de teste, entre outros.

3. **Múltiplas Extensões:**
   - Você pode usar `@ExtendWith` para registrar várias extensões, criando assim uma cadeia de extensões. A ordem em que as extensões são registradas pode ser significativa, pois a execução ocorre na ordem em que as extensões são registradas.

4. **Exemplo de Uso Básico:**

   ```java
   import org.junit.jupiter.api.Test;
   import org.junit.jupiter.api.extension.ExtendWith;
   import some.package.MyExtension;

   @ExtendWith(MyExtension.class)
   public class MeuTeste {

       @Test
       public void meuMetodoDeTeste() {
           // Lógica de teste aqui
       }
   }
   ```

   Neste exemplo, `MyExtension` é uma classe que implementa a interface `Extension`, e ela será utilizada como uma extensão para o teste.

5. **Extensões Padrão:**
   - O JUnit Jupiter fornece algumas extensões padrão, como `TestInfo`, `TestReporter`, `MockitoExtension`, entre outras. Essas extensões oferecem funcionalidades adicionais que podem ser úteis durante a execução dos testes.

Em resumo, a anotação `@ExtendWith` é usada para associar extensões aos métodos de teste, permitindo uma modularização e reutilização eficientes de código que afeta o comportamento dos testes.

> [retornar](#annottations) para o topo da página

### `@Before` e `@BeforeEach`

A anotação `@Before` faz parte do framework de teste JUnit em Java. No entanto, a partir do JUnit 5 (JUnit Jupiter), a anotação `@Before` foi substituída por `@BeforeEach`. A função principal de ambas as anotações é marcar um método para ser executado antes de cada método de teste dentro da classe de teste.

Aqui estão alguns pontos-chave sobre a anotação `@Before` e sua substituta `@BeforeEach`:

1. **Inicialização Pré-Teste:**
   - O método marcado com `@Before` (ou `@BeforeEach` no JUnit 5) é executado antes de cada método de teste na classe de teste. Ele é comumente usado para realizar a inicialização necessária, como a criação de objetos ou a configuração de condições iniciais.

2. **Diferenças entre `@Before` e `@BeforeEach`:**
   - No JUnit 4 (e versões anteriores), a anotação usada era `@Before`. No entanto, no JUnit 5, para melhorar a clareza e consistência, a anotação foi renomeada para `@BeforeEach`. Portanto, se você estiver usando o JUnit 5, é recomendável usar `@BeforeEach` para indicar a inicialização pré-teste.

3. **Exemplo de Uso (JUnit 4):**

   ```java
   import org.junit.Before;
   import org.junit.Test;

   public class MeuTeste {

       @Before
       public void configurar() {
           // Código de inicialização pré-teste
       }

       @Test
       public void meuMetodoDeTeste1() {
           // Lógica do primeiro teste
       }

       @Test
       public void meuMetodoDeTeste2() {
           // Lógica do segundo teste
       }
   }
   ```

4. **Exemplo de Uso (JUnit 5):**

   ```java
   import org.junit.jupiter.api.BeforeEach;
   import org.junit.jupiter.api.Test;

   public class MeuTeste {

       @BeforeEach
       public void configurar() {
           // Código de inicialização pré-teste
       }

       @Test
       public void meuMetodoDeTeste1() {
           // Lógica do primeiro teste
       }

       @Test
       public void meuMetodoDeTeste2() {
           // Lógica do segundo teste
       }
   }
   ```

5. **Múltiplos Métodos `@BeforeEach` (JUnit 5):**
   - No JUnit 5, você pode ter vários métodos marcados com `@BeforeEach` dentro da mesma classe de teste. Todos esses métodos serão executados antes de cada método de teste na ordem em que são definidos.

Em resumo, `@Before` (JUnit 4) ou `@BeforeEach` (JUnit 5) são usados para executar código de inicialização antes de cada método de teste em uma classe de teste. O uso do JUnit 4 ou JUnit 5 determina qual anotação deve ser utilizada.

> [retornar](#annottations) para o topo da página

### `@After` e `@AfterEach`

A anotação `@After` faz parte do framework de teste JUnit em Java. Essa anotação é usada para marcar um método que deve ser executado após cada método de teste na classe de teste. Sua principal função é permitir a realização de tarefas de limpeza ou liberação de recursos após a execução de cada teste.

Aqui estão alguns pontos-chave sobre a anotação `@After`:

1. **Tarefas de Limpeza Pós-Teste:**
   - O método marcado com `@After` é executado após cada método de teste. Ele é comumente usado para realizar tarefas de limpeza, como a liberação de recursos, fechamento de conexões, ou qualquer outra ação necessária após a execução de um teste.

2. **Exemplo de Uso (JUnit 4):**

   ```java
   import org.junit.After;
   import org.junit.Test;

   public class MeuTeste {

       @Test
       public void meuMetodoDeTeste() {
           // Lógica do teste
       }

       @After
       public void limparRecursos() {
           // Código de limpeza pós-teste
       }
   }
   ```

3. **Exemplo de Uso (JUnit 5):**

   ```java
   import org.junit.jupiter.api.AfterEach;
   import org.junit.jupiter.api.Test;

   public class MeuTeste {

       @Test
       public void meuMetodoDeTeste() {
           // Lógica do teste
       }

       @AfterEach
       public void limparRecursos() {
           // Código de limpeza pós-teste
       }
   }
   ```

4. **Diferenças entre `@After` e `@AfterEach`:**
   - No JUnit 4, a anotação usada é `@After`, enquanto no JUnit 5, a anotação correspondente é `@AfterEach`. A mudança no nome foi feita para melhorar a clareza e consistência, seguindo a mesma lógica da transição de `@Before` para `@BeforeEach`.

5. **Múltiplos Métodos `@AfterEach` (JUnit 5):**
   - Assim como `@BeforeEach`, no JUnit 5, você pode ter vários métodos marcados com `@AfterEach` dentro da mesma classe de teste. Todos esses métodos serão executados após cada método de teste na ordem em que são definidos.

Em resumo, `@After` (JUnit 4) ou `@AfterEach` (JUnit 5) são usados para executar código de limpeza após a execução de cada método de teste em uma classe de teste. O uso do JUnit 4 ou JUnit 5 determina qual anotação deve ser utilizada.

> [retornar](#annottations) para o topo da página

## Mockito

### `@InjectMocks`

A anotação `@InjectMocks` é parte do framework de mocking Mockito em Java. Ela é usada em conjunto com a injeção de dependência para injetar automaticamente as dependências marcadas como `@Mock` ou `@Spy` em um objeto que está sendo testado.

Aqui estão alguns pontos-chave sobre a anotação `@InjectMocks`:

1. **Injeção de Dependência Automática:**
   - A anotação `@InjectMocks` é usada para injetar automaticamente as dependências mockadas (marcadas com `@Mock` ou `@Spy`) em um objeto que está sendo testado. Isso é particularmente útil para evitar a necessidade de criar manualmente instâncias de objetos mockados e configurar as dependências.

2. **Uso em Testes Unitários:**
   - Geralmente, você usará `@InjectMocks` em classes de teste unitário para injetar mocks ou espiões nas dependências da classe que está sendo testada.

3. **Exemplo de Uso Básico:**

   ```java
   import org.junit.jupiter.api.Test;
   import org.mockito.InjectMocks;
   import org.mockito.Mock;

   import static org.mockito.Mockito.verify;
   import static org.mockito.Mockito.when;
   import org.mockito.junit.jupiter.MockitoExtension;
   import org.junit.jupiter.api.extension.ExtendWith;

   @ExtendWith(MockitoExtension.class)
   public class MeuTeste {

       @Mock
       private Dependencia dependenciaMock;

       @InjectMocks
       private ObjetoSobTeste objetoSobTeste;

       @Test
       public void meuMetodoDeTeste() {
           // Configuração do comportamento do mock
           when(dependenciaMock.metodoDoMock()).thenReturn("Algo");

           // Chama o método que está sendo testado
           objetoSobTeste.executarAlgumaLogica();

           // Verifica se o método do mock foi chamado
           verify(dependenciaMock).metodoDoMock();
       }
   }
   ```

   Neste exemplo, `dependenciaMock` é um mock de uma dependência, e `objetoSobTeste` é o objeto que está sendo testado. A anotação `@InjectMocks` injeta automaticamente `dependenciaMock` em `objetoSobTeste`.

4. **Considerações:**
   - É importante notar que `@InjectMocks` tenta injetar mocks nas propriedades da classe de teste. Se a injeção não for bem-sucedida (por exemplo, devido à falta de setters correspondentes), o Mockito pode lançar uma exceção.

5. **Compatibilidade com JUnit 5:**
   - A presença de `@ExtendWith(MockitoExtension.class)` indica que estamos usando o suporte do Mockito para JUnit 5. Certifique-se de que você tenha a dependência correta do Mockito no seu projeto para habilitar essa extensão.

> [retornar](#annottations) para o topo da página

### `@Mock`

A anotação `@Mock` faz parte do framework de mocking Mockito em Java. Ela é usada para criar objetos simulados (mocks) de classes ou interfaces. Esses mocks são usados em testes para isolar a unidade de código que está sendo testada, substituindo as dependências reais por comportamentos simulados controlados pelo teste.

Aqui estão alguns pontos-chave sobre a anotação `@Mock`:

1. **Criação de Mocks:**
   - A anotação `@Mock` é usada para criar um mock de uma classe ou interface. O Mockito cria automaticamente uma instância simulada do tipo da classe ou interface marcada com `@Mock`.

2. **Uso em Testes:**
   - Geralmente, você usará `@Mock` em classes de teste para substituir as dependências reais por mocks controlados pelo teste. Isso ajuda a isolar a unidade de código que está sendo testada, focando apenas no comportamento da unidade de código em questão.

3. **Exemplo de Uso Básico:**

   ```java
   import org.junit.jupiter.api.Test;
   import org.mockito.Mock;

   import static org.mockito.Mockito.when;
   import static org.junit.jupiter.api.Assertions.assertEquals;

   public class MeuTeste {

       @Mock
       private MinhaClasse minhaClasseMock;

       @Test
       public void meuMetodoDeTeste() {
           // Configuração do comportamento do mock
           when(minhaClasseMock.metodoDoMock()).thenReturn("Algo");

           // Chama o método que está sendo testado
           String resultado = minhaClasseMock.metodoDoMock();

           // Verifica se o método do mock foi chamado
           assertEquals("Algo", resultado);
       }
   }
   ```

   Neste exemplo, `minhaClasseMock` é um mock da classe `MinhaClasse`. O comportamento do método `metodoDoMock` é configurado para retornar "Algo". No teste, verifica-se se o método do mock é chamado conforme esperado.

4. **Considerações:**
   - Os mocks geralmente são usados para isolar o código em teste de suas dependências externas, permitindo que o teste se concentre em um aspecto específico do comportamento do código.

5. **Compatibilidade com JUnit 5:**
   - O exemplo acima é para JUnit 5, mas o Mockito também é compatível com JUnit 4. Certifique-se de incluir as dependências apropriadas no seu projeto para usar o Mockito em conjunto com seu framework de teste preferido.

> [retornar](#annottations) para o topo da página
>
> [voltar](../../README.md) para a página anterior
