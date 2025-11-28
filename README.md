## 1. Como subir o RabbitMQ (local ou Docker)
Existem duas opções para subir o RabbitMQ: local ou Docker.
Na opção Local, é necessário:
1. Baixar o arquivo em: https://www.rabbitmq.com/download.html
2. Subir o serviço com o comando: rabbitmq-server
3. Ativar o plugin de dashboard: rabbitmq-plugins enable rabbitmq_management;
Já através do Docker, baixa rodar o comando:
docker run -d --name rabbit mq \
-p 5672:5672 \
-p 15672:15672 \
rabbitmq:3-management
Depois é possível acessar o painel em: http://localhost:15672

## 2. Como rodar cada serviço:
Ambos são Spring Boot - então basta selecionar uma IDE para rodar, nesse caso, utilizamos o IntelliJ.
1. É possível rodar através do terminal, com o comando: ./mvnw spring-boot: run
2. Rodar pela IDE, indo em RUN → ServicoNotificacaoApplication;

## 3. Como testar o fluxo completo:
1. É preciso confirmar se o RabbitMQ está rodando.
2. Subir o order-service.
3. Subir o notification-service.
4. Criar um pedido utilizando POST.
5. Confirmar se está rodando no terminal do notification-service.
