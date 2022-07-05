# Tecnologias utilizadas
* Java 11
* Spring Boot (2.6.9)
* Banco de dados Mysql
* Lombok
* Junit

# Configurações
Link: http://localhost:8081
Nome base de dados: sessao_pauta

# Endpoints:
**//POST**

**Cadastrar um associado** => /associado

body:
```json
{
    "cpf" : "11111111111",
    "nome" : "Teste"
}
```

**Cadastrar uma pauta** => /pauta

body:
```json
{
    "name" : "Pauta 2",
    "description" : "Teste Teste"
}
```

**Cadastrar uma sessão** => /sessao

body:
```json
{
    "durationTime" : 20,
    "idPauta" : 1
}
```
**OBS**: durationTime é contabilizado em minutos se não for informado o valor default é de 1 minuto.

**Cadastrar um voto** => /voto

body:
```json
{
    "cpf" : "11111111111",
    "idSessao" : 13,
    "value" : "SIM"
}
```
**OBS**: O campo value permite os valores SIM ou NAO.

**OBS2**: O campo cpf deve ser preenchido com um cpf de um associado cadastrado. 

**//GET**
**Listar um associado** => /associado/{cpf}

**Listar uma pauta** => /pauta/{idPauta}

**Listar uma Sessão** => /sessao/{idSessao}

**
