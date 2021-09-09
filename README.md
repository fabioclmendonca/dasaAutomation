# Desafio Dasa - Jornada Paciente
Projeto desenvolvido utilizando Java, Selenium, Cucumber e Versionado com Git.

## Pre-requisitos
Maven. 
Dependencias estão adicionadas dentro do arquivo pom.xml.

### Instalação e execução.
```
mvn test 
```

## Detalhes do Projeto
### Detalhes
Requisitos para o desafio:
• Utilizar BDD para o desenvolvimento do cenário;
• Preferencialmente, automatizar com Ruby, Cucumber e Capybara;
• Fazer uso de Page Objects;
• A automação deve rodar no Firefox e no Chrome.

___
#### Contexto 
Funcionalidade: Navegar para pagina de parceiro pelo via portal Dasa.
Steps para o teste automatizado:
1. Acesse o site institucional da Dasa(https://dasa.com.br/).
2. Na página da Dasa, clique no link Nossas Marcas.
3. Na página das marcas, procure pelos laboratórios de São Paulo e liste todos os laboratórios do estado, exibindo os resultados no console.
4. Após listar, selecione o laboratório DelboniAuriemo.
5. Na página informativa do Delboni, valide que acessou a área do laboratório e em seguida clique no link com o nome da marca.
6. Após a página carregar, faça uma validação que foi direcionado corretamente para o site do Delboni Auriemo(https://delboniauriemo.com.br/).

--- 
#### Scenario @ID-0001 - Validate Company Page Navigation
Given I Navigate To "http://www.dasa.com.br"
And I Navigate To Companies Page
When I Select "São Paulo" As Region 
Then I Print Filtered Companies URLs on console
When I Select "delboniauriemo.com.br" Company
Then I verify if I navigated to "https://delboniauriemo.com.br/"
 
--- 
