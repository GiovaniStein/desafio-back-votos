# Tecnologias utilizadas
* Java 11
* Spring Boot (2.6.9)
* Spring Data Jpa
* Spring DevTools 
* Spring Validation
* Banco de dados Mysql
* Lombok
* Junit

# Configurações
Link: http://localhost:8081

Nome base de dados: sessao_pauta

**OBS**É necessário criar o banco de dados antes de rodar a API, a criação das tabelas e seus campos será feita de forma automatica pelo Spring Data.

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

response:
```json
{
    "cpf" : "11111111111",
    "nome" : "Teste"
}
```

**Listar uma pauta** => /pauta/{idPauta}

response:
```json
{
    "id": 15,
    "name": "Pauta 1",
    "description": "Teste Teste"
}
```
**Listar uma sessão** => /sessao/{idSessao}

response:
```json
{
    "id": 12,
    "init": "2022-07-04T17:32:55",
    "close": "2022-07-04T17:52:55",
    "pauta": {
        "id": 15,
        "name": "Pauta 1",
        "description": "Teste Teste"
    }
}
```

**Listar resultado sessão** => /sessao/result/{idSessao}

response:
```json
{
    "namePauta": "Pauta 1",
    "description": "Teste Teste",
    "numberApprovedVotes": 4,
    "numberDisapprovedVotes": 1,
    "numberVotes": 5
}
```

**Listar votos de uma sessão => /voto/{idSessao}

response:
```json
[
    {
        "id": 9,
        "associado": {
            "cpf": "82591398046",
            "nome": "Teste 1"
        },
        "sessao": {
            "id": 13,
            "init": "2022-07-04T18:16:17",
            "close": "2022-07-04T18:36:17",
            "pauta": {
                "id": 15,
                "name": "Pauta 1",
                "description": "Teste Teste"
            }
        },
        "value": "SIM"
    },
    {
        "id": 10,
        "associado": {
            "cpf": "38123305044",
            "nome": "Teste 2"
        },
        "sessao": {
            "id": 13,
            "init": "2022-07-04T18:16:17",
            "close": "2022-07-04T18:36:17",
            "pauta": {
                "id": 15,
                "name": "Pauta 1",
                "description": "Teste Teste"
            }
        },
        "value": "SIM"
    }
]
```
# Tarefas bônus e observações:

* Integração com sistemas externos: Foi utilizado para a integração com o serviço de validação de cpf, o RestTemplate do Spring Web Client devido a sua fácil implementação.

* 

* Versionamento: Utilizando o GitHub



