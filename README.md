# pass-in
O pass.in é uma aplicação de **gestão de participantes em eventos presenciais.**
- A ferramenta permite que o organizador cadastre um evento e abra uma página pública de inscrição.
- Os participantes inscritos podem emitir uma credencial para check-in no dia do evento.
- O sistema fará um scan da credencial do participante para permitir a entrada no evento.

## Requisitos
### Requisitos funcionais:
- O organizador deve poder cadastrar um novo evento;
- O organizador deve poder visualizar dados de um evento;
- O organizador deve poder visualizar a lista de participantes;
- O participante deve poder se inscrever em um evento;
- O participante deve poder visualizar seu crachá de inscrição;
- O participante deve poder realizar check-in no evento;

### Regras de negócio:
- O participante só pode se inscrever em um evento uma única vez;
- O participante só pode se inscrever em eventos com vagas disponíveis;
- O participante só pode realizar check-in em um evento uma única vez;

### Requisitos não funcionais:
O check-in no evento será realizado através de um QRCode;

## Tecnologias utilizadas:
- Java: Linguagem de programação principal.
- Spring Boot: Framework para o desenvolvimento de aplicações Java.
- HyperSQL Database ou HSQLDB: Banco de dados relacional para armazenar as informações dos eventos, participantes e check-ins.

![Modelo do banco de dados do projeto](https://efficient-sloth-d85.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F08f749ff-d06d-49a8-a488-9846e081b224%2F2ba0ffe6-d8d9-465b-a6c0-c92286d84ec3%2Ferd.svg?table=block&id=f08dcda4-fbc0-4217-aed4-e7e9f54e90bc&spaceId=08f749ff-d06d-49a8-a488-9846e081b224&userId=&cache=v2)