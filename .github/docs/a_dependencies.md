# Dependencies

> [voltar](../../README.md) para a página anterior

## Sumário

- [Dependencies](#dependencies)
  - [Sumário](#sumário)
  - [`spring-boot-starter-web`](#spring-boot-starter-web)
  - [`spring-boot-starter-validation`](#spring-boot-starter-validation)
  - [`spring-boot-devtools`](#spring-boot-devtools)
  - [`spring-boot-starter-test`](#spring-boot-starter-test)
  - [`spring-boot-starter-data-jpa`](#spring-boot-starter-data-jpa)
  - [`spring-boot-starter-security`](#spring-boot-starter-security)
  - [`postgresql`](#postgresql)
  - [`lombok`](#lombok)
  - [`java-jwt`](#java-jwt)
  - [`JUinit`](#juinit)
  - [`H2 Database`](#h2-database)
  - [`springdoc-openapi-starter-webmvc-ui`](#springdoc-openapi-starter-webmvc-ui)
  - [`Actuator`](#actuator)

## `spring-boot-starter-web`

A dependência "spring-boot-starter-web" é uma parte fundamental do ecossistema Spring Boot, que é uma estrutura de desenvolvimento para aplicativos Java baseados em Spring que visa simplificar o desenvolvimento de aplicativos web e RESTful. Essa dependência é uma das várias "starters" fornecidas pelo Spring Boot para facilitar o desenvolvimento de aplicativos em várias áreas, como web, segurança, dados, entre outras.

A dependência "spring-boot-starter-web" fornece um conjunto de bibliotecas e configurações predefinidas que simplificam o desenvolvimento de aplicativos web. Ela inclui o Spring MVC, que é um framework para o desenvolvimento de aplicativos web baseados em padrões MVC (Model-View-Controller). Com essa dependência, você pode criar controladores, manipular solicitações HTTP, renderizar visualizações e expor serviços RESTful com facilidade.

Algumas das principais funcionalidades e componentes que a dependência "spring-boot-starter-web" inclui são:

1. Spring MVC: Permite criar controladores para lidar com solicitações HTTP, mapeando URLs para métodos de controle e fornecendo uma estrutura organizada para lidar com a lógica de negócios.

2. Configuração automática: Spring Boot fornece configuração automática com base nas bibliotecas detectadas no seu classpath. Isso significa que você não precisa configurar manualmente muitos aspectos do seu aplicativo web.

3. Integrado com o servidor incorporado: Spring Boot vem com um servidor web incorporado (por padrão, o Tomcat, mas você pode trocar para outras opções) para facilitar o desenvolvimento e o teste do seu aplicativo sem a necessidade de implantar em um servidor externo.

4. Suporte a servidores de aplicativos tradicionais: Se você preferir implantar seu aplicativo em um servidor de aplicativos tradicional, o Spring Boot é flexível o suficiente para acomodar essa preferência.

5. Suporte a serviços RESTful: Spring Boot facilita a criação de serviços RESTful usando anotações e convenções, tornando a exposição de APIs simples e eficaz.

6. Suporte a templates: O Spring Boot oferece suporte a uma variedade de mecanismos de renderização de visualizações, como Thymeleaf, FreeMarker e outros.

Em resumo, a dependência "spring-boot-starter-web" desempenha um papel fundamental na simplificação do desenvolvimento de aplicativos web Java usando o Spring Boot. Ela fornece todas as ferramentas e configurações necessárias para criar aplicativos web robustos e eficientes de forma rápida e fácil.

> [retornar](#dependencies) para o topo da página

## `spring-boot-starter-validation`

A dependência "spring-boot-starter-validation" é uma parte do ecossistema Spring Boot e é usada para simplificar a validação de dados em aplicativos Java baseados em Spring. Ela faz parte do módulo de validação do Spring Framework e fornece recursos que ajudam os desenvolvedores a garantir que os dados inseridos ou manipulados em seus aplicativos estejam em conformidade com as regras de validação desejadas.

A principal funcionalidade da dependência "spring-boot-starter-validation" é a integração com a validação baseada em anotações, que é uma parte fundamental do Java Bean Validation (JSR-380). O Java Bean Validation permite definir regras de validação de dados em classes de modelo usando anotações. Algumas das anotações mais comuns incluem `@NotNull`, `@Size`, `@Min`, `@Max`, `@Pattern`, entre outras. Essas anotações são usadas para especificar os requisitos de validação para os campos de um objeto.

Ao incluir a dependência "spring-boot-starter-validation" no seu projeto Spring Boot, você obtém as seguintes vantagens:

1. Integração com o mecanismo de validação: O Spring Boot configura automaticamente o mecanismo de validação para que você possa usar anotações de validação em suas classes de modelo sem configuração adicional.

2. Detecção de erros de validação: Quando os dados não atendem aos critérios de validação especificados nas anotações, o Spring Boot lida com os erros de validação e os apresenta de maneira amigável ao cliente, permitindo a identificação e correção dos problemas.

3. Integração com outras partes do ecossistema Spring: A dependência "spring-boot-starter-validation" funciona perfeitamente com outros módulos Spring, como Spring MVC, permitindo que você valide entradas de solicitação de forma transparente.

4. Personalização de mensagens de erro: É possível personalizar as mensagens de erro exibidas quando a validação falha, para que os usuários recebam mensagens de erro significativas e relevantes.

Em resumo, a dependência "spring-boot-starter-validation" simplifica a validação de dados em aplicativos Spring Boot, permitindo que os desenvolvedores definam facilmente regras de validação usando anotações, evitando a necessidade de escrever código de validação personalizado e facilitando a detecção de erros de validação. Isso contribui para a criação de aplicativos mais robustos e seguros.

> [retornar](#dependencies) para o topo da página

## `spring-boot-devtools`

A dependência "spring-boot-devtools" é uma parte do ecossistema Spring Boot e é projetada para melhorar a experiência de desenvolvimento durante o ciclo de desenvolvimento de aplicativos Spring Boot. Ela fornece várias ferramentas e funcionalidades que facilitam o desenvolvimento, o teste e a depuração de aplicativos, tornando o processo mais eficiente e produtivo para os desenvolvedores.

Aqui estão alguns dos recursos e funcionalidades que a dependência "spring-boot-devtools" oferece:

1. **Auto-reinicialização (LiveReload):** Uma das funcionalidades mais notáveis é a capacidade de auto-reinicialização automática do aplicativo sempre que ocorre uma alteração no código-fonte. Isso significa que, durante o desenvolvimento, você não precisa parar e reiniciar manualmente o aplicativo toda vez que fizer alterações no código. O aplicativo é recarregado automaticamente para refletir as alterações.

2. **Recarregamento de recursos estáticos:** Além de recarregar o código-fonte, o "spring-boot-devtools" também recarrega recursos estáticos, como arquivos HTML, CSS e JavaScript. Isso permite ver imediatamente as alterações nas páginas da web sem atualizar manualmente o navegador.

3. **Desativação de cache:** O DevTools desativa automaticamente o cache do aplicativo durante o desenvolvimento para garantir que as alterações sejam sempre refletidas, o que é especialmente útil ao trabalhar com recursos web.

4. **Suporte a perfis de desenvolvimento:** O "spring-boot-devtools" permite definir perfis de desenvolvimento para personalizar o comportamento do aplicativo durante o desenvolvimento. Isso é útil para ativar ou desativar recursos específicos apenas em ambientes de desenvolvimento.

5. **Monitoramento de alterações em propriedades:** O DevTools monitora as alterações nas propriedades do aplicativo e permite atualizá-las sem reiniciar o aplicativo, o que é útil para ajustar a configuração do aplicativo em tempo real.

6. **Detecção automática:** A dependência é ativada automaticamente quando o aplicativo é executado a partir da IDE (como o IntelliJ IDEA ou o Eclipse) ou usando a linha de comando (por exemplo, com o comando `mvn spring-boot:run` ou `./mvnw spring-boot:run`).

7. **Redução de tempo de compilação:** O DevTools pode acelerar o tempo de compilação de recursos, evitando a recompilação de classes de terceiros quando as classes de código-fonte do aplicativo são modificadas.

Lembrando que, embora o "spring-boot-devtools" seja uma ferramenta valiosa durante o desenvolvimento, geralmente não é recomendado para uso em ambientes de produção, pois pode causar comportamento imprevisível e problemas de desempenho devido à reinicialização automática e desativação do cache.

Em resumo, a dependência "spring-boot-devtools" é uma ferramenta extremamente útil para aumentar a produtividade dos desenvolvedores durante o desenvolvimento de aplicativos Spring Boot, simplificando a recarga automática de código e recursos, a personalização de propriedades e a melhoria da experiência de desenvolvimento em geral.

> [retornar](#dependencies) para o topo da página

## `spring-boot-starter-test`

A dependência "spring-boot-starter-test" é uma parte essencial do ecossistema Spring Boot e é usada para facilitar a escrita de testes automatizados em aplicativos Spring Boot. Ela fornece um conjunto abrangente de bibliotecas, configurações e ferramentas para criar e executar testes unitários, de integração e de ponta a ponta em um ambiente de desenvolvimento Spring Boot. Essa dependência é frequentemente incluída nos projetos Spring Boot para garantir que os testes sejam fáceis de escrever e executar.

A dependência "spring-boot-starter-test" inclui várias bibliotecas de teste populares, como JUnit, TestNG, Hamcrest e Mockito, entre outras. Aqui estão alguns dos principais recursos e benefícios que essa dependência oferece:

1. **Integração com Spring Framework:** O "spring-boot-starter-test" fornece configurações e anotações que facilitam a criação de testes que interagem com os componentes Spring, como serviços, controladores e repositórios. Ele configura automaticamente o contexto de aplicativo Spring para os testes, permitindo a injeção de dependências e o uso de anotações como `@Autowired`.

2. **Suporte a diferentes tipos de testes:** Essa dependência suporta vários tipos de testes, incluindo testes unitários, testes de integração e testes de ponta a ponta. Você pode escolher a abordagem de teste que melhor se adapte às necessidades do seu aplicativo.

3. **Integração com ferramentas de teste:** A dependência facilita a integração com ferramentas de teste populares, como JUnit e TestNG, para escrever casos de teste e executá-los.

4. **Anotações úteis:** Ela inclui anotações úteis, como `@SpringBootTest`, que carrega o contexto de aplicativo completo durante os testes de integração, e `@DataJpaTest`, que simplifica os testes relacionados a JPA (Java Persistence API).

5. **Suporte a teste de controladores:** Você pode testar controladores Spring facilmente usando anotações como `@WebMvcTest`, que carrega apenas o contexto do controlador, isolando-o de outros componentes.

6. **Simulação de dependências:** A dependência facilita o uso de bibliotecas como Mockito para simular objetos de dependência, permitindo testar componentes de forma isolada.

7. **Configuração de ambiente de teste personalizada:** É possível personalizar o ambiente de teste com propriedades específicas do teste, como configurações de banco de dados ou propriedades do aplicativo.

Em resumo, a dependência "spring-boot-starter-test" é uma ferramenta valiosa para simplificar o processo de escrita e execução de testes em aplicativos Spring Boot. Ela fornece um ambiente de teste configurado automaticamente, integração com ferramentas de teste populares e suporte a diferentes tipos de testes, tornando mais fácil garantir a qualidade e a confiabilidade do seu aplicativo durante o desenvolvimento.

> [retornar](#dependencies) para o topo da página

## `spring-boot-starter-data-jpa`

A dependência "spring-boot-starter-data-jpa" faz parte do ecossistema Spring Boot e é projetada para simplificar o desenvolvimento de aplicativos Java que precisam interagir com bancos de dados relacionais usando a tecnologia JPA (Java Persistence API). Essa dependência fornece um conjunto de bibliotecas e configurações predefinidas que tornam mais fácil a implementação de operações de acesso a dados, mapeamento objeto-relacional e consultas de banco de dados em aplicativos Spring Boot.

Aqui estão os principais recursos e benefícios que a dependência "spring-boot-starter-data-jpa" oferece:

1. **Configuração Automática:** O Spring Boot configura automaticamente um ambiente JPA para você, evitando a necessidade de escrever muita configuração manual. Isso inclui a configuração de um EntityManagerFactory, DataSource e transações.

2. **Repositórios JPA:** Essa dependência permite criar repositórios JPA usando a interface `JpaRepository`, que oferece uma série de métodos predefinidos para realizar operações de CRUD (Create, Read, Update, Delete) no banco de dados. Você pode até criar consultas personalizadas usando a sintaxe da Spring Data JPA.

3. **Mapeamento Objeto-Relacional (ORM):** O Spring Boot facilita o mapeamento de entidades Java para tabelas de banco de dados, permitindo que você defina classes de entidade e relacionamentos usando anotações JPA.

4. **Suporte a Diversos Bancos de Dados:** A dependência "spring-boot-starter-data-jpa" é flexível e pode ser configurada para funcionar com diversos bancos de dados relacionais, como MySQL, PostgreSQL, Oracle, H2, entre outros. Você pode definir as propriedades de conexão em um arquivo de configuração.

5. **Transações Gerenciadas:** O Spring Boot gerencia automaticamente transações, permitindo que você defina operações de banco de dados em métodos anotados com `@Transactional`, garantindo a consistência dos dados.

6. **Consultas Personalizadas:** Você pode definir consultas personalizadas usando a sintaxe da Spring Data JPA, o que simplifica a criação de consultas complexas com menos código.

7. **Testes Integrados:** O Spring Boot facilita a escrita de testes integrados para garantir o funcionamento correto das operações de banco de dados.

8. **Auditoria de Dados:** Você pode configurar a auditoria de entidades com anotações JPA, rastreando automaticamente quem criou ou modificou um registro.

Em resumo, a dependência "spring-boot-starter-data-jpa" é uma escolha comum para o desenvolvimento de aplicativos Java que precisam interagir com bancos de dados relacionais usando a tecnologia JPA. Ela simplifica significativamente a configuração e o acesso a dados, permitindo que os desenvolvedores foquem mais na lógica de negócios e menos na configuração de acesso a dados.

> [retornar](#dependencies) para o topo da página

## `spring-boot-starter-security`

A dependência "spring-boot-starter-security" faz parte do ecossistema Spring Boot e é utilizada para adicionar recursos de segurança a aplicativos Java baseados em Spring Boot. Ela facilita a implementação de autenticação, autorização e outras funcionalidades de segurança em seus aplicativos de forma eficaz.

Aqui estão os principais recursos e funcionalidades que a dependência "spring-boot-starter-security" oferece:

1. **Configuração Automática:** O Spring Boot configura automaticamente a segurança do aplicativo com base em opiniões sensatas e padrões de segurança comuns. Isso significa que, com essa dependência, você pode obter um sistema de segurança funcional com configuração mínima.

2. **Autenticação:** A dependência fornece suporte para autenticação de usuários. Você pode configurar a autenticação com base em uma variedade de métodos, como autenticação baseada em formulário, autenticação com LDAP, autenticação OAuth2 e muito mais.

3. **Autorização:** Você pode configurar políticas de autorização para controlar quais recursos e ações um usuário autenticado pode acessar. Isso é feito por meio da configuração de regras de autorização usando expressões de segurança.

4. **Integração com LDAP e OAuth:** O Spring Boot Security oferece suporte para integração com serviços de diretório LDAP para autenticação e autorização. Além disso, ele também suporta a implementação de servidores de autenticação OAuth2 para proteger suas APIs.

5. **Gestão de Sessão:** A segurança do Spring Boot gerencia sessões de usuário, permitindo que você defina configurações, como tempo limite da sessão, e também fornece recursos para impedir ataques de sessão inválida.

6. **Personalização:** Você pode personalizar a configuração de segurança para atender às necessidades específicas do seu aplicativo, definindo suas próprias regras de autorização, formulários de login personalizados e muito mais.

7. **Proteção contra Ataques:** A dependência "spring-boot-starter-security" inclui recursos para proteger o aplicativo contra ataques comuns, como ataques de injeção SQL, Cross-Site Request Forgery (CSRF) e Cross-Site Scripting (XSS).

8. **Testes de Segurança:** O Spring Boot Security também fornece ferramentas e suporte para testes de segurança automatizados, permitindo que você avalie a segurança do seu aplicativo.

Em resumo, a dependência "spring-boot-starter-security" é uma escolha comum para adicionar recursos de segurança a aplicativos Spring Boot. Ela simplifica a configuração e a implementação de autenticação, autorização e proteção contra ameaças de segurança, permitindo que os desenvolvedores protejam seus aplicativos de forma eficaz. É especialmente valiosa para aplicativos que lidam com informações confidenciais e precisam garantir que apenas usuários autorizados tenham acesso a recursos protegidos.

> [retornar](#dependencies) para o topo da página

## `postgresql`

O PostgreSQL não é uma dependência do Java em si, mas é um banco de dados relacional de código aberto que pode ser usado em conjunto com aplicativos Java. O PostgreSQL é um sistema de gerenciamento de banco de dados (SGBD) que permite armazenar, recuperar e gerenciar dados de forma persistente em um formato de tabela relacionado.

Quando você desenvolve um aplicativo Java que precisa armazenar e recuperar dados em um banco de dados, você pode escolher usar o PostgreSQL como seu SGBD. Para fazer isso, você precisará de uma biblioteca Java que permita a interação com o PostgreSQL, chamada de driver JDBC (Java Database Connectivity). O driver JDBC para PostgreSQL é geralmente chamado de "jdbc:postgresql" e é amplamente usado para conectar aplicativos Java ao banco de dados PostgreSQL.

A dependência real no contexto de um projeto Java será uma dependência Maven ou Gradle (ou outra ferramenta de gerenciamento de dependências) que especifica a biblioteca do driver JDBC do PostgreSQL. Aqui está um exemplo de como você pode adicionar essa dependência ao seu projeto usando Maven:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>versão-desejada</version>
</dependency>
```

Depois de adicionar essa dependência ao seu projeto Java, você pode usar as classes e métodos fornecidos pelo driver JDBC do PostgreSQL para estabelecer uma conexão com o banco de dados PostgreSQL, executar consultas SQL, inserir, atualizar ou excluir dados e recuperar resultados em seu aplicativo Java.

Em resumo, o PostgreSQL não é uma dependência do Java em si, mas é um SGBD que pode ser usado em conjunto com aplicativos Java. A dependência real em um projeto Java seria a biblioteca do driver JDBC do PostgreSQL, que permite a comunicação entre o aplicativo Java e o banco de dados PostgreSQL.

> [retornar](#dependencies) para o topo da página

## `lombok`

Lombok é uma biblioteca Java que oferece uma maneira conveniente de reduzir a quantidade de código repetitivo que você escreve em suas classes, especialmente classes de modelo e entidades. Ela faz isso por meio do uso de anotações que geram automaticamente código Java comuns, como getters, setters, construtores, métodos `equals()`, `hashCode()`, `toString()`, entre outros.

Aqui estão alguns dos recursos e funcionalidades mais comuns do Lombok:

1. **Anotações Lombok:** O Lombok fornece um conjunto de anotações que você pode adicionar às suas classes Java para gerar automaticamente código comum. Alguns exemplos de anotações Lombok incluem `@Data` (que gera getters, setters, `equals()`, `hashCode()` e `toString()`), `@Getter` (que gera apenas getters), `@Setter` (que gera apenas setters), `@NoArgsConstructor` (que gera um construtor sem argumentos) e muitas outras.

2. **Redução de Boilerplate:** Com o Lombok, você pode reduzir a quantidade de código "boilerplate" que normalmente escreveria em suas classes. Isso torna o código mais limpo e fácil de manter.

3. **Personalização:** Embora o Lombok ofereça geração automática de código, ele também permite que você personalize o comportamento gerado por meio de configurações e parâmetros específicos das anotações.

4. **Compatibilidade com IDEs:** O Lombok é compatível com várias IDEs populares, como o Eclipse e o IntelliJ IDEA. No entanto, você geralmente precisa de um plugin Lombok instalado na IDE para que ela reconheça e processe as anotações do Lombok corretamente.

5. **Integração com Outras Bibliotecas:** O Lombok pode ser usado em conjunto com outras bibliotecas e estruturas, como o Spring Framework e o Hibernate, para simplificar a criação de classes de modelo e entidades.

6. **Facilita a Leitura do Código:** Ao reduzir a quantidade de código repetitivo, o Lombok pode tornar o código-fonte mais claro e focado nos aspectos essenciais da classe.

Um exemplo simples do uso do Lombok em uma classe Java:

```java
import lombok.Data;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}
```

Neste exemplo, a anotação `@Data` gera automaticamente os métodos getters, setters, `equals()`, `hashCode()` e `toString()` para as propriedades da classe `Person`.

Em resumo, o Lombok é uma biblioteca que pode aumentar a produtividade do desenvolvedor, eliminando a necessidade de escrever código repetitivo e tedioso em suas classes Java. No entanto, é importante lembrar que o uso do Lombok também pode tornar o código menos explícito, portanto, é fundamental equilibrar o uso das anotações do Lombok com a clareza e a manutenibilidade do código.

> [retornar](#dependencies) para o topo da página

## `java-jwt`

Refere-se ao Java JSON Web Token (JWT), uma biblioteca Java que fornece funcionalidades para criar, analisar e validar tokens JWT. Tokens JWT são uma forma de representar informações entre partes como um objeto JSON. Eles são frequentemente usados para autenticação e autorização em sistemas distribuídos, especialmente em aplicativos web e serviços da web.

A biblioteca "java-jwt" permite trabalhar com tokens JWT em aplicativos Java de forma conveniente. Alguns dos recursos e funcionalidades comuns oferecidos por esta biblioteca incluem:

1. **Criação de Tokens JWT:** Você pode criar facilmente tokens JWT assinados usando as informações necessárias, como reclamações (claims), algoritmo de assinatura e chave secreta.

2. **Validação de Tokens JWT:** A biblioteca permite verificar se um token JWT é válido, verificando a assinatura e a integridade dos dados.

3. **Recuperação de Informações do Token:** Você pode extrair informações do token, como as reclamações (claims), que contêm dados relevantes para a autenticação e autorização.

4. **Suporte a Diferentes Algoritmos de Assinatura:** A biblioteca suporta vários algoritmos de assinatura, como HMAC, RSA e ECDSA, permitindo escolher o algoritmo que melhor atende às suas necessidades de segurança.

5. **Tratamento de Data e Hora:** A biblioteca lida com questões de data e hora automaticamente, verificando a validade do token com base nas informações de data de expiração (expiração) e data de emissão (emitido).

6. **Integração com Outras Bibliotecas:** "java-jwt" pode ser usado em conjunto com outras bibliotecas relacionadas à segurança, como bibliotecas de autenticação e autorização.

7. **Suporte a Padrões JWT:** A biblioteca segue as especificações padrão de tokens JWT, tornando-a compatível com outros sistemas que também usam JWT.

É importante lembrar que a segurança de aplicativos que usam tokens JWT é altamente dependente da implementação correta e segura da lógica de autenticação e autorização. Além disso, a proteção adequada das chaves secretas e a gestão de tokens são essenciais para garantir a segurança do sistema.

Em resumo, a biblioteca "java-jwt" é uma ferramenta valiosa para trabalhar com tokens JWT em aplicativos Java, facilitando a criação, validação e manipulação de tokens JWT, o que é comum em cenários de autenticação e autorização em sistemas distribuídos.

> [retornar](#dependencies) para o topo da página

## `JUinit`

JUnit é um framework de teste para a linguagem de programação Java. Ele fornece um conjunto de anotações e métodos para facilitar a escrita e execução de testes unitários, que são testes destinados a verificar se partes específicas do código estão funcionando conforme o esperado.

Aqui estão alguns aspectos principais do JUnit:

1. **Anotações:**
   - JUnit utiliza anotações Java para identificar métodos que devem ser executados como testes. Algumas das anotações mais comuns incluem:
     - `@Test`: Identifica que o método é um teste.
     - `@Before`: Indica que o método deve ser executado antes de cada teste.
     - `@After`: Indica que o método deve ser executado após cada teste.
     - `@BeforeClass`: Indica que o método deve ser executado antes de todos os testes na classe.
     - `@AfterClass`: Indica que o método deve ser executado após todos os testes na classe.

2. **Assertions:**
   - JUnit fornece um conjunto de métodos de assert que são usados nos testes para verificar se as condições esperadas são verdadeiras. Alguns exemplos incluem `assertEquals`, `assertTrue`, `assertFalse`, etc.

3. **Test Runners:**
   - Os testes em JUnit são executados por meio de "test runners", que são classes que orquestram a execução dos testes. JUnit fornece um runner padrão (`BlockJUnit4ClassRunner`), mas também suporta a criação de runners personalizados.

4. **Suite de Teste:**
   - JUnit permite agrupar testes em suites, que são classes que contêm métodos de teste, mas também podem agrupar outros casos de teste ou suites. Isso é útil para organizar e executar conjuntos específicos de testes.

5. **Integração com IDEs:**
   - JUnit é amplamente suportado por ambientes de desenvolvimento integrado (IDEs) como Eclipse, IntelliJ IDEA e NetBeans. Isso facilita a execução e visualização de resultados de testes diretamente no ambiente de desenvolvimento.

6. **Parâmetros em Testes:**
   - A partir da versão 4, o JUnit suporta a passagem de parâmetros para métodos de teste, o que permite executar o mesmo teste com diferentes conjuntos de dados.

7. **Extensibilidade:**
   - JUnit é projetado para ser extensível, permitindo que desenvolvedores criem extensões personalizadas para atender às necessidades específicas de seus projetos.

JUnit é uma ferramenta fundamental para a prática de Desenvolvimento Orientado a Testes (TDD) e é amplamente utilizado na comunidade Java para garantir a qualidade do software por meio da automação de testes.

> [retornar](#dependencies) para o topo da página

## `H2 Database`

O H2 Database é um sistema de gerenciamento de banco de dados relacional escrito em Java. Ele é conhecido por ser leve, rápido e oferecer a capacidade de operar em modos de uso em memória (in-memory), bem como em modos de uso persistente em disco. Algumas características e pontos notáveis do H2 Database incluem:

1. **Java-Based:**
   - O H2 é desenvolvido em Java, o que significa que é independente de plataforma e pode ser facilmente integrado a aplicativos Java.

2. **Em Memória e Persistente:**
   - Pode ser utilizado tanto como um banco de dados em memória (os dados são armazenados na RAM e não persistem após o encerramento da aplicação) quanto como um banco de dados persistente (onde os dados são armazenados em disco e podem ser recuperados entre execuções).

3. **Rápido e Eficiente:**
   - O H2 é conhecido por sua rapidez e eficiência, o que o torna uma escolha popular para cenários de teste e desenvolvimento.

4. **Modo Servidor:**
   - Além do modo incorporado (embedded), o H2 pode ser executado como um servidor autônomo, permitindo que aplicativos cliente se conectem a ele por meio de JDBC (Java Database Connectivity) ou outros protocolos.

5. **Suporte a SQL:**
   - Oferece suporte a uma ampla variedade de comandos SQL padrão, proporcionando aos desenvolvedores uma interface familiar para interagir com o banco de dados.

6. **Suporte a Transações:**
   - Fornece suporte a transações ACID (Atomicidade, Consistência, Isolamento e Durabilidade), garantindo a integridade dos dados.

7. **Conformidade com Padrões JDBC:**
   - Sendo compatível com JDBC, o H2 pode ser facilmente integrado a aplicativos Java existentes que fazem uso desse padrão.

8. **Recursos Avançados:**
   - Inclui recursos avançados, como suporte a gatilhos (triggers), stored procedures, e suporte a índices.

9. **Console Web:**
   - Possui uma console web que permite a administração e visualização dos dados de maneira gráfica, facilitando o gerenciamento durante o desenvolvimento e testes.

10. **Compatibilidade com Modo MySQL e PostgreSQL:**

- Oferece modos de compatibilidade com MySQL e PostgreSQL, permitindo que os usuários migrem para o H2 com mais facilidade.

O H2 é frequentemente utilizado em ambientes de desenvolvimento e teste, especialmente em situações em que a facilidade de configuração, a velocidade e a simplicidade são cruciais. No entanto, devido à sua natureza leve, também pode ser utilizado em ambientes de produção, dependendo dos requisitos específicos do projeto.

## `springdoc-openapi-starter-webmvc-ui`

O pacote `springdoc-openapi-starter-webmvc-ui` é uma ferramenta do Spring Boot para gerar automaticamente a documentação da API em formato OpenAPI (anteriormente conhecido como Swagger) para projetos que utilizam Spring Web MVC. Ele simplifica bastante o processo de documentação da API, permitindo que os desenvolvedores foquem mais na lógica de negócios do que na documentação manual.

Aqui estão algumas informações detalhadas sobre o `springdoc-openapi-starter-webmvc-ui`:

1. **Objetivo Principal**:
   - O principal objetivo deste pacote é integrar facilmente a geração de documentação OpenAPI em projetos Spring Boot que utilizam Spring Web MVC para construir APIs RESTful.

2. **Funcionalidades**:
   - Geração automática de documentação OpenAPI: Ele analisa automaticamente os controladores e modelos do Spring MVC e gera a documentação correspondente em formato OpenAPI.
   - Interface de usuário interativa: Além da geração de documentação, ele também fornece uma interface de usuário interativa (UI) para visualizar e interagir com a documentação gerada.
   - Personalização: Permite personalizar a documentação gerada usando anotações específicas ou configuração via código.
   - Suporte ao Swagger UI: Integra-se perfeitamente com o Swagger UI, que é uma interface de usuário popular para explorar e testar APIs documentadas no formato OpenAPI.

3. **Compatibilidade**:
   - É compatível com o Spring Boot, que é uma estrutura popular para o desenvolvimento de aplicativos Java baseados em Spring.
   - Especificamente projetado para trabalhar com o Spring Web MVC, que é uma estrutura do Spring para construir aplicativos da web RESTful.

4. **Configuração Fácil**:
   - Pode ser facilmente integrado a projetos Spring Boot adicionando apenas algumas dependências Maven/Gradle e fazendo algumas configurações mínimas.

5. **Integração com Spring Boot Actuator**:
   - Pode ser integrado ao Spring Boot Actuator para fornecer endpoints adicionais relacionados à documentação da API, como `/actuator/openapi`, que retorna a especificação OpenAPI JSON.

6. **Versatilidade**:
   - Suporta várias versões do OpenAPI (2.x e 3.x) para atender às necessidades do projeto.
   - Pode ser estendido com plugins para adicionar funcionalidades adicionais, se necessário.

Em resumo, o `springdoc-openapi-starter-webmvc-ui` simplifica bastante o processo de documentação de APIs em projetos Spring Boot, permitindo que os desenvolvedores gerem automaticamente a documentação da API em formato OpenAPI e forneçam uma interface de usuário interativa para explorar e testar a API documentada.

## `Actuator`

Em uma aplicação Spring Boot, um "actuator" é um módulo que fornece informações sobre o ambiente da aplicação em execução. Ele expõe endpoints RESTful que permitem monitoramento e gerenciamento da aplicação em tempo de execução. O Spring Boot Actuator fornece uma série de funcionalidades prontas para uso, como:

1. **Endpoints de saúde (Health Endpoints)**: Permitem verificar o estado de saúde da aplicação, como se ela está online, se todos os serviços essenciais estão funcionando corretamente, etc.

2. **Endpoints de informações (Info Endpoints)**: Fornecem informações gerais sobre a aplicação, como versão, descrição, etc.

3. **Endpoints de métricas (Metrics Endpoints)**: Permitem monitorar métricas de desempenho da aplicação, como uso de CPU, memória, solicitações HTTP, entre outros.

4. **Endpoints de auditoria (Auditing Endpoints)**: Registram eventos importantes que ocorrem na aplicação, como acesso a endpoints, alterações de configuração, etc.

5. **Endpoints de ambiente (Environment Endpoints)**: Fornecem informações sobre as configurações do ambiente de execução da aplicação, como variáveis de ambiente, propriedades do sistema, etc.

Esses endpoints são úteis para monitorar a saúde e o desempenho da aplicação, diagnosticar problemas e até mesmo automatizar tarefas de gerenciamento. O Spring Boot Actuator é altamente configurável e pode ser estendido para adicionar funcionalidades personalizadas, se necessário.

> para mais informações: <https://docs.spring.io/spring-boot/docs/2.5.6/reference/html/actuator.html>

> [retornar](#dependencies) para o topo da página
>
> [voltar](../../README.md) para a página anterior
