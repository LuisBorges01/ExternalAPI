# ExternalAPI
### Status: 
Cada bug é uma oportunidade de aprendizado. 
### Progresso:
95%
### Descrição: 
External API consumption(PokeAPI) 
### Anotações:
[Notion](https://www.notion.so/Anota-es-Desafio-Looqbox-f47de419273b49c2a338f8aa938ee4cf?pvs=4)(Não necessária)


# Desafio de Backend
**MICROSERVIÇO** usando a pilha de tecnologias abaixo e a [PokeAPI](https://pokeapi.co/docs/v2).

## Tecnologias:
* Java 17
* Spring Boot para o framework 
* Gradle para gerenciamento de dependências e implantação local

## Funcionalidades:

* Consumo de dados da PokéAPI
* 2 endpoints

**ORDENAÇÃO:**

* Alfabética

* Tamanho ⇒ Indevitável melhoria

**URL 1:** http://localhost:8080/OBTER

**Retorno:**

```java
{
"name": null,
"highlight": null,
"results": [
{
"name": "bulbasaur"
},
{
"name": "ivysaur"
},
{
"name": "venusaur"
},
```

URL 2.1:
http://localhost:8080/OBTER/pokemon?lenght=1

Retorno:

```java
{
"name": null,
"highlight": null,
"results": [
{
"name": "bulbasaur"
},
{
"name": "ivysaur"
},
{
"name": "venusaur"
},
{
"name": "charmander"
},
```

URL 2.2: http://localhost:8080/OBTER/pokemon?q=la

RETORNO:

```java
{
    "name": "latios",
    "highlight": "<pre>la</pre>tios",
    "results": null
  },
  {
    "name": "lapras",
    "highlight": "<pre>la</pre>pras",
    "results": null
  },
```

## **Melhorias:**

Retorno **/OBTER**

Proposta de Melhoria ⇒ Versionamento da classe Pokemon

```java
{
  "name": null,
  "highlight": null,
  "results": [
    {
      "name": "bulbasaur"
    },
    {
      "name": "ivysaur"
    },
```

Retorno /OBTER/pokemon

Proposta de Melhoria ⇒ Versionamento da classe Pokemon

```java
"name": null,
    "highlight": null,
    "results": [
      {
        "name": "bulbasaur"
      },
      {
        "name": "ivysaur"
      },
```

Retorno OBTER/pokemon?q=pidg

Proposta de Melhoria ⇒ Versionamento da classe Pokemon

```java
[
  {
    "name": "pidgey",
    "highlight": "<pre>pidg</pre>ey",
    **"results": null**
  },
```

Retorno /OBTER/pokemon?leght

Proposta de Melhoria ⇒ Trabalhar em cima da interface Ordenável

```java
[
  {
    "name": null,
    "highlight": null,
    "results": [
      {
        "name": "bulbasaur"
      },
      {
        "name": "ivysaur"
      },
```

## **Requisitos não Funcionais**

- [x]Explicar a lógica implementada.

- [x]Consumir e expor **TODOS** os pokémons existentes da **PokéAPI:**

- [x]Desenhe um **diagrama** explicando sua arquitetura.

- [x]A API deve ser construída tendo em mente o desempenho e a facilidade de manutenção.

- [x]Identifique pontos de gargalo em seu código, se houver, e forneça uma possível solução para eles.****

## **Diagrama**

![image](https://github.com/LuisBorges01/ExternalAPI/assets/102482876/ff6e3b65-e2a8-4d83-8cb5-f115bb1c9982)




## Pontos bônus

- [x]Padrões de design: Padrão REST

- [x]Cache

### Autor
  
<img style="border-radius: 50%;" src="https://user-images.githubusercontent.com/102482876/269443996-0ef731c0-d23d-4c98-bc79-624f6eec2ea7.jpg" width="100px;" alt=""/>
<sub><b>Luis Eduardo(O mais bonito de todos)</b></sub></a> <a href="Rocketseat">🚀</a>


Feito por Luis Eduardo

Entre em contato! 👋🏽 

 [![Linkedin Badge](https://img.shields.io/badge/-Luis_Borges-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/luisborges01/)](https://www.linkedin.com/in/luisborges01/) 
[![Gmail Badge](https://img.shields.io/badge/-luiseduardobborges@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:luiseduardobborges@gmail.com)](mailto:luiseduardobborges@gmail.com)
